package uoscs.rescue.foodDeliveryWebService.data.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;
import uoscs.rescue.foodDeliveryWebService.data.entity.Member;
import uoscs.rescue.foodDeliveryWebService.data.entity.Order;

import javax.persistence.EntityManager;
import java.util.List;

@ComponentScan(basePackages = "uoscs.rescue.foodDeliveryWebService")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@DataJpaTest
//@TestPropertySource(locations = "../main/resources/application.properties")

@SpringBootTest
class RepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private EntityManager em;

    @AfterEach
    void afterEach(){
        //memberRepository.deleteAll();
    }

    @Test
    @Transactional  //테스트에 붙이면 반영된게 롤백
    void saveMember(){
        Member member = Member.builder().id("124").build();
        memberRepository.save(member);

        Assertions.assertThat(memberRepository.findById(member.getId()).get()).isNotNull();
        System.out.println("id: "+ memberRepository.findById(member.getId()).get().getId());
    }

    @Test
    @Transactional  //테스트에 붙이면 반영된게 롤백
    void saveMemberWithListOrder(){
        Member member = Member.builder().id("124").build();
        memberRepository.save(member);

        Order order1 = Order.builder().id("10000").orderedMember(member).price(100).build();
        Order order2 = Order.builder().id("10001").orderedMember(member).price(1200).build();

        orderRepository.save(order1);
        orderRepository.save(order2);

        em.flush();
        em.clear();


        Assertions.assertThat(memberRepository.findById(member.getId()).get()).isNotNull();
        Assertions.assertThat(memberRepository.findById(member.getId()).get().getOrderList().size()).isEqualTo(2);
        for (Order orders: memberRepository.findById(member.getId()).get().getOrderList()) {
            System.out.println(orders);
        }
    }

    @Test
    @Transactional  //테스트에 붙이면 반영된게 롤백
    void saveOrder(){
/*
        //Order order1 = Order.builder().orderpureid("nimi").price(100).build();
        Order order1 = new Order();
        order1.setId("nimi");
        orderRepository.save(order1);

        //Member member = Member.builder().memberid("124").build();
        Member member = new Member();
        member.setId("1324");
        member.setMyorder(order1);

        memberRepository.save(member);

        em.flush();
        em.clear();

        System.out.println("id: "+ memberRepository.findById(member.getId()).get().getMyorder());
        Assertions.assertThat(memberRepository.findById(member.getId()).get().getMyorder().getPrice()).isEqualTo(order1.getPrice());


        System.out.println("id: "+ orderRepository.findById(order1.getId()).get().getOrderedMember());
        Assertions.assertThat(orderRepository.findById(order1.getId()).get().getOrderedMember().getId()).isEqualTo(member.getId());
   */
    }

}