package uoscs.rescue.foodDeliveryWebService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.form.SessionForm;
import uoscs.rescue.foodDeliveryWebService.service.MemberService;
import uoscs.rescue.foodDeliveryWebService.utils.SessionConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sign")
public class SignController {

    private final MemberService memberService;

    @PostMapping("/signin")
    public ResponseEntity<String> signin(HttpServletRequest request){
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        if(!memberService.checkIdAndPassword(id,password))
            return ResponseEntity.ok("fail");

        //id, password 통과, 권한 찾아오기
        MemberDto memberDto = memberService.findById(id);
        SessionForm sessionForm = new SessionForm(memberDto.getId(), memberDto.getAuthority());

        HttpSession session = request.getSession(); //새로 만드는 거니까 true
        session.setAttribute(SessionConst.SESSION_FORM, sessionForm);

        return ResponseEntity.ok("login success id= " +id);
    }

    @PostMapping("/signup")
    public ResponseEntity<MemberDto> signup(@RequestBody MemberDto memberDto){
        return ResponseEntity.ok(memberService.save(memberDto));
    }

}
