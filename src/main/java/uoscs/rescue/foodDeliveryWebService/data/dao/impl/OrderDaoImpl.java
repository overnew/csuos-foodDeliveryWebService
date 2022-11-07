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

@Slf4j
@Repository
@RequiredArgsConstructor
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    private final MemberRepository memberRepository;

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
}