package uoscs.rescue.foodDeliveryWebService.data.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import uoscs.rescue.foodDeliveryWebService.data.entity.Member;

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