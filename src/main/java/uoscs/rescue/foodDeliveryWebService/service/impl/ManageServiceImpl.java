package uoscs.rescue.foodDeliveryWebService.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uoscs.rescue.foodDeliveryWebService.data.dao.OrderDao;
import uoscs.rescue.foodDeliveryWebService.data.dto.OrderDto;
import uoscs.rescue.foodDeliveryWebService.service.ManageService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ManageServiceImpl implements ManageService {
    @Autowired
    private final OrderDao orderDao;

    @Override
    public List<OrderDto> getAllOrderDtoList(){
        return orderDao.getAllOrderList();
    }

    @Override
    public void acceptOrderById(Long id){
        orderDao.acceptOrderById(id);
    }

}
