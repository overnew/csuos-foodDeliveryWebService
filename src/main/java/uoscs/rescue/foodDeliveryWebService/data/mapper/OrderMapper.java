package uoscs.rescue.foodDeliveryWebService.data.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import uoscs.rescue.foodDeliveryWebService.data.dto.OrderDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Order;
import uoscs.rescue.foodDeliveryWebService.data.form.IngredientChangeForm;

import java.util.ArrayList;
import java.util.List;

@Named("OrderMapper")
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE) //,uses = {MemberMapper.class})
public interface OrderMapper {/*
    @AfterMapping   // 구현체에 들어감
    protected void ignoreMembersOrders(Order order, @MappingTarget OrderDto orderDto){
        orderDto.getOrderedMemberDto().setOrderDtoList(null);
    }*/

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
/*
    @Named("toDto")
    @Mappings({
            @Mapping( source = "orderedMember",target = "orderedMemberDto", qualifiedByName = {"MemberMapper", "toDto"})
    })
    OrderDto orderToDto(Order order);

    @Named("toDtoWithoutMember")
    @Mappings({
            @Mapping(target = "orderedMemberDto",expression = "java(null)")
    })
    OrderDto orderToDtoWithoutMember(Order order);*/

    //@Mapping( target = "orderDto", qualifiedByName = {"OrderMapper", "orderToDto"})

    Order dtoToOrder(OrderDto orderDto);

    @Named("orderToOrderDto")
    default OrderDto orderToOrderDto(Order order){
        return OrderDto.builder().id(order.getId())
                .accepted(order.isAccepted())
                .orderedMemberId(order.getOrderedMember().getId())
                .orderTime(order.getOrderTime())
                .build();
    }


    default List<OrderDto> listToDtoList(List<Order> orderList){
        if ( orderList == null ) {
            return null;
        }

        List<OrderDto> list = new ArrayList<OrderDto>( orderList.size() );
        for ( Order order : orderList ) {
            list.add( orderToOrderDto( order ) );
        }

        return list;
    }

    IngredientChangeForm orderToChangeForm(Order order);
}
