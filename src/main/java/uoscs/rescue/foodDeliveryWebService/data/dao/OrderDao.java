package uoscs.rescue.foodDeliveryWebService.data.dao;

import uoscs.rescue.foodDeliveryWebService.data.dto.OrderDto;

public interface OrderDao {

    OrderDto saveWithMemberId(OrderDto orderDto);

    OrderDto findById(String id);
}
