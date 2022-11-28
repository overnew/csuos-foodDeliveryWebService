package uoscs.rescue.foodDeliveryWebService.data.dao;

import uoscs.rescue.foodDeliveryWebService.data.dto.OrderDto;

import java.util.List;

public interface OrderDao {

    OrderDto saveOrder(OrderDto orderDto);

    OrderDto findById(Long id);
    List<OrderDto> getAllOrderList();

    void acceptOrderById(Long id);

    void deleteById(Long id);
}
