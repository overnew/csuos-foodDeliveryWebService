package uoscs.rescue.foodDeliveryWebService.Data.Repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;
import uoscs.rescue.foodDeliveryWebService.Data.Entity.Member;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@ComponentScan(basePackages = "uoscs.rescue.foodDeliveryWebService")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@DataJpaTest
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @AfterEach
    void afterEach(){
        //memberRepository.deleteAll();
    }

    @Test
    @Transactional  //테스트에 붙이면 반영된게 롤백
    void saveMember(){
        Member member = Member.builder().id("124").build();
        memberRepository.save(member);

        Assertions.assertThat(memberRepository.findById(member.getId())).isNotEmpty();
    }
}