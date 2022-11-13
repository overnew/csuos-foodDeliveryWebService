package uoscs.rescue.foodDeliveryWebService.service;

import uoscs.rescue.foodDeliveryWebService.data.dto.OrderDto;

public interface OrderService {
    OrderDto makeOrder(OrderDto orderDto);
}
