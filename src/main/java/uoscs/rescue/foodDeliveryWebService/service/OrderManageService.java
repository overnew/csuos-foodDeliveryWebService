package uoscs.rescue.foodDeliveryWebService.service;

import uoscs.rescue.foodDeliveryWebService.data.dto.OrderDto;

import java.util.List;

public interface OrderManageService {
    List<OrderDto> getAllOrderDtoList();

    void acceptOrderById(Long id);
}
