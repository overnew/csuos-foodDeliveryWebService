package uoscs.rescue.foodDeliveryWebService.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.form.ResponseForm;
import uoscs.rescue.foodDeliveryWebService.data.form.SessionForm;
import uoscs.rescue.foodDeliveryWebService.service.MemberService;
import uoscs.rescue.foodDeliveryWebService.utils.SessionConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sign")
public class SignController {

    private final MemberService memberService;

    @ApiOperation(
            value = "로그인"
            ,notes = "paramter에 id와 password 전송"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message ="로그인 성공"),
            @ApiResponse(code= 400, message = "로그인 실패")
    })
    @PostMapping("/signin")
    public ResponseEntity<ResponseForm> signin(HttpServletRequest request){
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        if(!memberService.checkIdAndPassword(id,password)){
            return ResponseEntity.badRequest().body(buildResponseForm(false,"아이디나 비밀번호가 올바르지 않습니다."));
        }

        //id, password 통과, 권한 찾아오기
        MemberDto memberDto = memberService.findById(id);
        SessionForm sessionForm = new SessionForm(memberDto.getId(), memberDto.getAuthority());

        HttpSession session = request.getSession(); //새로 만드는 거니까 true
        session.setAttribute(SessionConst.SESSION_FORM, sessionForm);

        return ResponseEntity.ok(buildResponseForm(true,"로그인 성공"));
    }


    @ApiOperation(
            value = "회원 가입"
            ,notes = "MemberDto에 데이터 채워서 요청"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message ="회원가입 성공"),
            @ApiResponse(code= 400, message = "회원가입 실패")
    })
    @PostMapping("/signup")
    public ResponseEntity<ResponseForm> signup(@Valid @RequestBody MemberDto memberDto){
        if(memberDto.isPersonalInfoAgreement()){
            if(memberDto.getName() ==null  || memberDto.getAddress() ==null)
                return ResponseEntity.badRequest().body(buildResponseForm(false,"개인 정보를 입력해 주세요."));
        }

        MemberDto savedMemberDto = memberService.saveWithCheckId(memberDto);

        if(savedMemberDto ==null){
            return ResponseEntity.badRequest().body(buildResponseForm(false,"중복된 아이디가 존재합니다."));
        }

        return ResponseEntity.ok(buildResponseForm(true,"회원가입 성공"));
    }

    @ApiOperation(
            value = "로그 아웃"
            ,notes = "세션 값만 전달"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message ="로그아웃 성공")
    })
    @PostMapping("/sign-out")
    public ResponseEntity<ResponseForm> singOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();

        return ResponseEntity.ok(buildResponseForm(true,"로그아웃 성공"));
    }


    private ResponseForm buildResponseForm(Boolean isSuccess,String message){
        List<String> messages = new ArrayList<>();
        messages.add(message);

        return ResponseForm.builder()
                .success(isSuccess)
                .messages(messages)
                .build();
    }


}
