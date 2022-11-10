package uoscs.rescue.foodDeliveryWebService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.service.MemberService;
import uoscs.rescue.foodDeliveryWebService.utils.SessionConst;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private final MemberService memberService;

    @PostMapping("/get-my-data")
    public ResponseEntity<MemberDto> getMemberData(
            @SessionAttribute(name = SessionConst.SIGN_ID, required = false)
            String id
    ){
        return ResponseEntity.ok(memberService.findById(id));
    }


}
