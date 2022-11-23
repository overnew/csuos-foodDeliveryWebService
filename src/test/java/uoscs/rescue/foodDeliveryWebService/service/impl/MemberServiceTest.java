package uoscs.rescue.foodDeliveryWebService.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.enums.Authority;
import uoscs.rescue.foodDeliveryWebService.data.enums.Grade;
import uoscs.rescue.foodDeliveryWebService.service.MemberService;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private EntityManager em;

    @Test
    void saveWithCheckId() {
        MemberDto memberDto = MemberDto.builder().id("1231321").build();
        memberService.saveWithCheckId(memberDto);

        MemberDto savedMemberDto = memberService.findById(memberDto.getId());
        assertThat(savedMemberDto.getGrade()).isEqualTo(Grade.GENERAL);
        assertThat(savedMemberDto.getAuthority()).isEqualTo(Authority.GENERAL);
    }

    @Test
    @Transactional
    void updateMemberByGeneralAuth(){
        //given
        MemberDto memberDto = MemberDto.builder().id("1231321").build();
        MemberDto updateDto = MemberDto.builder().id("disApply").name("mimi").authority(Authority.ADMIN).build();

        //when
        memberService.saveWithCheckId(memberDto);
        memberService.updateMemberByGeneralAuth(memberDto.getId(),updateDto);

        em.flush();
        em.clear();

        MemberDto savedMemberDto = memberService.findById(memberDto.getId());

        //then
        assertThat(savedMemberDto.getName()).isEqualTo(updateDto.getName());
        assertThat(savedMemberDto.getAuthority()).isEqualTo(Authority.GENERAL); //권한 변경은 적용 안됨
    }
}