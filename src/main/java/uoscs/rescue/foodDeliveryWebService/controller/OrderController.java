package uoscs.rescue.foodDeliveryWebService.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.dto.OrderDto;
import uoscs.rescue.foodDeliveryWebService.data.form.ResponseForm;
import uoscs.rescue.foodDeliveryWebService.service.OrderService;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    @PostMapping("/make-order")
    public ResponseEntity<ResponseForm> makeOrder(@Valid @RequestBody OrderDto orderDto){
        OrderDto savedOrderDto = orderService.makeOrder(orderDto);
        log.info("savedorder: {}" , savedOrderDto);

        ResponseForm responseForm = ResponseForm.builder().success(true).build();
        return ResponseEntity.ok(responseForm);
    }

}
