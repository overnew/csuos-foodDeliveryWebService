package uoscs.rescue.foodDeliveryWebService.data.dao.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uoscs.rescue.foodDeliveryWebService.data.dao.MemberDao;
import uoscs.rescue.foodDeliveryWebService.data.dao.OrderDao;
import uoscs.rescue.foodDeliveryWebService.data.dto.OrderDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Member;
import uoscs.rescue.foodDeliveryWebService.data.entity.Order;
import uoscs.rescue.foodDeliveryWebService.data.mapper.OrderMapper;
import uoscs.rescue.foodDeliveryWebService.data.repository.MemberRepository;
import uoscs.rescue.foodDeliveryWebService.data.repository.OrderRepository;
import uoscs.rescue.foodDeliveryWebService.exception.NoSuchOrderException;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final MemberDao memberDao;
    @Autowired
    private final OrderMapper orderMapper;

    @Override
    public OrderDto saveWithMemberId(OrderDto orderDto) {
        Member orderedMember = memberDao.findMemberEntityById(orderDto.getOrderedMemberId());

        Order order = orderMapper.dtoToOrder(orderDto);
        order.setOrderedMember(orderedMember);  //Member는 직접 setting

        Order savedOrder = orderRepository.save(order);
        log.info("save order {}", savedOrder);

        return orderMapper.orderToDto(savedOrder);
    }

    private Order getOrderEntityById(Long id){
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if(optionalOrder.isEmpty()){
            throw new NoSuchOrderException("no such order id: "+ id);
        }

        return optionalOrder.get();
    }

    @Override
    public OrderDto findById(Long id) {
        Order orderEntity = getOrderEntityById(id);

        return orderMapper.orderToDto(orderEntity);
    }

    @Override
    public void acceptOrderById(Long id) {
        Order order = getOrderEntityById(id);
        order.setAccepted(true);

        log.info("accept order id: ");
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);

        log.info("DELETE order id: " + id);
    }
}
