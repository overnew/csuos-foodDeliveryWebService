package uoscs.rescue.foodDeliveryWebService.data.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Member;
import uoscs.rescue.foodDeliveryWebService.data.entity.Order;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MapperTest {

    private MemberMapper memberMapper = MemberMapper.INSTANCE;

    @Test
    void mapperTest(){
        List<Order> orderList = new ArrayList<>();
        orderList.add(Order.builder().id("123").build());

        Member member = Member.builder().id("10").orderList(orderList).build();


        MemberDto memberDto = memberMapper.memberToDto(member);
        System.out.println(memberDto);
    }
}