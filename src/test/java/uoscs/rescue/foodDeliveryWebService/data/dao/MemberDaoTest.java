package uoscs.rescue.foodDeliveryWebService.data.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.exception.NoSuchMemberException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberDaoTest {
    @Autowired
    private MemberDao memberDao;

    @Test
    void saveMember(){
        MemberDto memberDto = MemberDto.builder().id("123").build();
        MemberDto savedDto = memberDao.save(memberDto);

        Assertions.assertThat(savedDto.getId()).isEqualTo(memberDto.getId());
    }

    @Test
    void updateMember(){
        //given
        MemberDto memberDto = MemberDto.builder().id("123").name("sidea").build();
        MemberDto savedDto = memberDao.save(memberDto);

        MemberDto updateMemberDto = MemberDto.builder().name("hakodate").build();

        //when
        memberDao.updateById(savedDto.getId(),updateMemberDto);

        //then
        MemberDto updatedMember = memberDao.findById(savedDto.getId());
        Assertions.assertThat(updatedMember.getName()).isEqualTo(updatedMember.getName());

    }

    @Test
    void deleteMember(){
        //given
        MemberDto memberDto = MemberDto.builder().id("123").name("sidea").build();
        MemberDto savedDto = memberDao.save(memberDto);

        //when
        memberDao.deleteById(savedDto.getId());

        //then
        Assertions.assertThatThrownBy(
                ()->   memberDao.findById(savedDto.getId())
        ).isInstanceOf(NoSuchMemberException.class);
    }
}