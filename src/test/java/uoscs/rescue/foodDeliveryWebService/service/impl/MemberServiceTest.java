package uoscs.rescue.foodDeliveryWebService.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.enums.Authority;
import uoscs.rescue.foodDeliveryWebService.data.enums.Grade;
import uoscs.rescue.foodDeliveryWebService.service.MemberService;


@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    void saveWithCheckId() {
        MemberDto memberDto = MemberDto.builder().id("1231321").build();
        memberService.saveWithCheckId(memberDto);

        MemberDto savedMemberDto = memberService.findById(memberDto.getId());
        Assertions.assertThat(savedMemberDto.getGrade()).isEqualTo(Grade.GENERAL);
        Assertions.assertThat(savedMemberDto.getAuthority()).isEqualTo(Authority.GENERAL);
    }
}