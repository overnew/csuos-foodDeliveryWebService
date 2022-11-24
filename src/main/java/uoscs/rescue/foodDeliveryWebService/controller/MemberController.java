package uoscs.rescue.foodDeliveryWebService.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.form.ResponseForm;
import uoscs.rescue.foodDeliveryWebService.data.form.SessionForm;
import uoscs.rescue.foodDeliveryWebService.service.MemberService;
import uoscs.rescue.foodDeliveryWebService.utils.SessionConst;

@Slf4j
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
            @SessionAttribute(name = SessionConst.SESSION_FORM, required = false) SessionForm sessionForm){
        //log.info("session {}" ,sessionForm);
        return ResponseEntity.ok(memberService.findById(sessionForm.getId()));
    }

    @ApiOperation(
            value = "자신의 정보 변경"
            ,notes = "변경할 데이터를 MemberDto에 담아 전달 -> 자동으로 기본 정보만 반영(권한 정보는 담아 보내도반영 안됨)"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message ="업데이트 성공")
    })
    @PostMapping("/update-my-data")
    public ResponseEntity<ResponseForm> updateMyMemberData(
            @SessionAttribute(name = SessionConst.SESSION_FORM, required = false) SessionForm sessionForm,
            @RequestBody MemberDto updateDataMemberDto
    ){
        memberService.updateMemberByGeneralAuth(sessionForm.getId(), updateDataMemberDto);
        return ResponseEntity.ok(ResponseForm.builder().success(true).build());
    }



}
