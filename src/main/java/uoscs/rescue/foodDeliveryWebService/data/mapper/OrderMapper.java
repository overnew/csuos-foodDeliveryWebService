package uoscs.rescue.foodDeliveryWebService.data.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import uoscs.rescue.foodDeliveryWebService.data.dto.OrderDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Order;

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

    Order dtoToOrder(OrderDto orderDto);

    @Named("orderToDto")
    default OrderDto orderToDto(Order order){
        return OrderDto.builder().id(order.getId())
                .orderedMemberId(order.getOrderedMember().getId()).build();
    }
}
