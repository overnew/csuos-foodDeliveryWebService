package uoscs.rescue.foodDeliveryWebService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<MemberDto> signup(@RequestBody MemberDto memberDto){
        return ResponseEntity.ok(memberService.save(memberDto));
    }
}
