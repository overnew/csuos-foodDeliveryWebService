package uoscs.rescue.foodDeliveryWebService.data.mapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.dto.OrderDto;
import uoscs.rescue.foodDeliveryWebService.data.dto.StockDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Ingredient;
import uoscs.rescue.foodDeliveryWebService.data.entity.Member;
import uoscs.rescue.foodDeliveryWebService.data.entity.Order;
import uoscs.rescue.foodDeliveryWebService.data.entity.Stock;
import uoscs.rescue.foodDeliveryWebService.data.enums.Grade;
import uoscs.rescue.foodDeliveryWebService.data.form.IngredientChangeForm;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class MapperTest {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private IngredientMapper ingredientMapper;
    @Autowired
    private StockMapper stockMapper;

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
    void stockWithIngredient(){
        //given
        Ingredient ingredientBread = Ingredient.builder().name("붕어뽱").quantity(120).build();

        //when
        Stock stock = Stock.builder().id("sldlstkf").bread(ingredientBread).build();

        //then
        StockDto stockDto = stockMapper.toDto(stock);
        System.out.println(stockDto);
        assertThat(stockDto.getBread().getQuantity()).isEqualTo(ingredientBread.getQuantity());
    }

    @Test
    void enumMappingTest(){
        //given
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

    @Test
    void orderToIngredientChangeForm(){
        Order order = Order.builder().bread(10).coffee(1).bacon(2).build();
        IngredientChangeForm ingredientChangeForm = orderMapper.orderToChangeForm(order);

        System.out.println(ingredientChangeForm);
    }

}