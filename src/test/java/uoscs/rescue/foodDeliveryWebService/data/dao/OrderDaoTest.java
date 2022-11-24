package uoscs.rescue.foodDeliveryWebService.data.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.dto.OrderDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Member;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
class OrderDaoTest {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private EntityManager em;

    @Test
    void saveOrderWithMember(){
        //given
        MemberDto memberDto = MemberDto.builder().id("samayou").build();
        memberDao.save(memberDto);

        //when
        OrderDto orderDto = OrderDto.builder()
                .orderedMemberId(memberDto.getId())
                .build();

        OrderDto savedOrder = orderDao.saveWithMemberId(orderDto);
        Member savedMember = memberDao.findMemberEntityById(memberDto.getId());

        //then
        Assertions.assertThat(savedMember.getOrderList().get(0).getId())
                .isEqualTo(savedOrder.getId());
    }

    @Test
    @Transactional
    void acceptOrder(){
        //given
        MemberDto memberDto = MemberDto.builder().id("samayou").build();
        memberDao.save(memberDto);

        //when
        OrderDto orderDto = OrderDto.builder()
                .accepted(false)
                .orderedMemberId(memberDto.getId())
                .build();

        em.flush();
        em.clear();

        OrderDto savedOrder = orderDao.saveWithMemberId(orderDto);

        orderDao.acceptOrderById(savedOrder.getId());

        em.flush();
        em.clear();

        OrderDto acceptedOrder = orderDao.findById(savedOrder.getId());

        //then
        Assertions.assertThat(acceptedOrder.isAccepted()).isTrue();
    }

    @Test
    @Transactional
    void deleteOrderWithListInMember(){

        //given
        MemberDto memberDto = MemberDto.builder().id("samayou").build();
        memberDao.save(memberDto);

        //when
        OrderDto orderDto = OrderDto.builder()
                .accepted(false)
                .orderedMemberId(memberDto.getId())
                .build();

        em.flush();
        em.clear();

        OrderDto savedOrder = orderDao.saveWithMemberId(orderDto);
        orderDao.deleteById(savedOrder.getId());

        em.flush();
        em.clear();

        //then
        MemberDto savedMember = memberDao.findById(memberDto.getId());
        List<OrderDto> orderDtoList = savedMember.getOrderDtoList();
        Assertions.assertThat(orderDtoList.size()).isEqualTo(0);
    }
}