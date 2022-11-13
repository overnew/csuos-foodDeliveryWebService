package uoscs.rescue.foodDeliveryWebService.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uoscs.rescue.foodDeliveryWebService.data.dto.OrderDto;
import uoscs.rescue.foodDeliveryWebService.service.OrderManageService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/order-manage")
public class OrderManageController {

    @Autowired
    private final OrderManageService orderManageService;

    @GetMapping("/all-orders")
    public Page<OrderDto> getAllOrderPageList(
            @PageableDefault(size = 5, sort="id",direction = Sort.Direction.DESC) Pageable pageable) {

        List<OrderDto> orderDtoList = orderManageService.getAllOrderDtoList();

        final int start = (int)pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), orderDtoList.size());
        final Page<OrderDto> page = new PageImpl<>(orderDtoList.subList(start, end), pageable, orderDtoList.size());

        return page;
    }
}
