package uoscs.rescue.foodDeliveryWebService.data.mapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.dto.OrderDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Member;
import uoscs.rescue.foodDeliveryWebService.data.entity.Order;
import uoscs.rescue.foodDeliveryWebService.data.enums.Grade;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class MapperTest {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private OrderMapper orderMapper;

/*
    @Test
    void mapperTest(){
        List<Order> orderList = new ArrayList<>();
        orderList.add(Order.builder().id("123").build());

        Member member = Member.builder().id("10").orderList(orderList).build();


        MemberDto memberDto = memberMapper.memberToDto(member);
        System.out.println(memberDto);
    }*/

    @Test
    void enumMappingTest(){
        //givne
        Member member = Member.builder().id("10").grade(Grade.GENERAL).build();

        //when
        MemberDto memberDto = memberMapper.memberToDto(member);

        //then
        assertThat(memberDto.getGrade()).isEqualTo(Grade.GENERAL);
        assertThat(memberMapper.dtoToMember(memberDto).getGrade()).isEqualTo(Grade.GENERAL);

    }

    @Test
    void orderListMapper(){
        //givne
        Order order = Order.builder().id(1L).orderedMember(Member.builder().id("12").build()).build();
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);

        //when
        List<OrderDto> orderDtoList = orderMapper.listToDtoList(orderList);

        //then
        OrderDto orderDto = orderDtoList.get(0);
        assertThat(orderDto.getId()).isEqualTo(order.getId());
        assertThat(orderDto.getOrderedMemberId()).isEqualTo("12");
        System.out.println(orderDto);
    }

}