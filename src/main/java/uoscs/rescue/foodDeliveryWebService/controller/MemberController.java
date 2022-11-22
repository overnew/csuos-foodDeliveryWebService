package uoscs.rescue.foodDeliveryWebService.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.form.SessionForm;
import uoscs.rescue.foodDeliveryWebService.service.MemberService;
import uoscs.rescue.foodDeliveryWebService.utils.SessionConst;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private final MemberService memberService;

    @ApiOperation(
            value = "자신의 정보 불러오기"
            ,notes = "로그인 상태로 세션을 보냄 -> MemberDto로 데이터가 날라옴"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message ="MemberDto")
    })
    @PostMapping("/get-my-data")
    public ResponseEntity<MemberDto> getMemberData(
            @SessionAttribute(name = SessionConst.SESSION_FORM, required = false)
            SessionForm sessionForm
    ){
        return ResponseEntity.ok(memberService.findById(sessionForm.getId()));
    }


}
