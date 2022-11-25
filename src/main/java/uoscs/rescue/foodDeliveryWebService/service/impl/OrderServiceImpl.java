package uoscs.rescue.foodDeliveryWebService.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uoscs.rescue.foodDeliveryWebService.data.dao.OrderDao;
import uoscs.rescue.foodDeliveryWebService.data.dto.OrderDto;
import uoscs.rescue.foodDeliveryWebService.data.enums.DinnerStyle;
import uoscs.rescue.foodDeliveryWebService.data.enums.DinnerType;
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

    @Override
    public OrderDto fillIngredientByType(OrderDto orderDto) {
        DinnerType dinnerType = orderDto.getDinnerType();
        DinnerStyle dinnerStyle = orderDto.getDinnerStyle();
        if(dinnerType ==null)
            return null;

        if(dinnerType.equals(DinnerType.CHAMPAGNE) &&
                (dinnerStyle ==null || dinnerStyle.equals(DinnerStyle.SIMPLE)))
            orderDto.setDinnerStyle(DinnerStyle.GRAND);

        if(dinnerStyle == null)
            orderDto.setDinnerStyle(DinnerStyle.SIMPLE);

        OrderDto rebuildOrder;
        if(dinnerType.equals(DinnerType.ENGLISH)){
             rebuildOrder=OrderDto.builder()
                    .dinnerType(DinnerType.ENGLISH)
                    .dinnerStyle(orderDto.getDinnerStyle())
                    .eggScramble(1)
                    .bacon(1)
                    .bread(1)
                    .steak(1).build();
        }else if(dinnerType.equals(DinnerType.VALENTINE)){
            rebuildOrder=OrderDto.builder()
                    .dinnerType(DinnerType.VALENTINE)
                    .dinnerStyle(orderDto.getDinnerStyle())
                    .wine(1)
                    .steak(1).build();
        }else if(dinnerType.equals(DinnerType.FRENCH)){
            rebuildOrder=OrderDto.builder()
                    .dinnerType(DinnerType.FRENCH)
                    .dinnerStyle(orderDto.getDinnerStyle())
                    .salad(1)
                    .coffee_cup(1)
                    .wine(1)
                    .steak(1).build();
        }else{ //dinnerType.equals(DinnerType.CHAMPAGNE)
            rebuildOrder=OrderDto.builder()
                    .dinnerType(DinnerType.CHAMPAGNE)
                    .dinnerStyle(orderDto.getDinnerStyle())
                    .champagne(1)
                    .baguetteBread(4)
                    .coffee_port(1)
                    .wine(1)
                    .steak(1).build();
        }

        return rebuildOrder;
    }
}
