package uoscs.rescue.foodDeliveryWebService.data.mapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Member;
import uoscs.rescue.foodDeliveryWebService.data.entity.Order;
import uoscs.rescue.foodDeliveryWebService.data.enums.Grade;

import java.util.ArrayList;
import java.util.List;


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
        Assertions.assertThat(memberDto.getGrade()).isEqualTo(Grade.GENERAL);
        Assertions.assertThat(memberMapper.dtoToMember(memberDto).getGrade()).isEqualTo(Grade.GENERAL);

    }

}