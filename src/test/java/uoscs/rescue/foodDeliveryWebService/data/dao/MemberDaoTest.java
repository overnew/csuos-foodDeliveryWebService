package uoscs.rescue.foodDeliveryWebService.data.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;

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
}