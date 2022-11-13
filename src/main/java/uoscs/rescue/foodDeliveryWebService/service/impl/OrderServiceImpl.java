package uoscs.rescue.foodDeliveryWebService.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uoscs.rescue.foodDeliveryWebService.data.dao.OrderDao;
import uoscs.rescue.foodDeliveryWebService.data.dto.OrderDto;
import uoscs.rescue.foodDeliveryWebService.service.OrderService;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private final OrderDao orderDao;

    private void setOrderDtoRegularForm(OrderDto orderDto){    //주문 시간과 수락 여부를 저장전에 변경
        orderDto.setOrderTime(LocalDateTime.now());
        orderDto.setAccepted(false);
    }

    @Override
    public OrderDto makeOrder(OrderDto orderDto) {
        setOrderDtoRegularForm(orderDto);
        return orderDao.saveWithMemberId(orderDto);
    }
}
