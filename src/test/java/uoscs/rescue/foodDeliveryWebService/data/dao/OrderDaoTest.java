package uoscs.rescue.foodDeliveryWebService.data.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.dto.OrderDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Member;

@SpringBootTest
class OrderDaoTest {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private OrderDao orderDao;

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
}