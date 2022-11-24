package uoscs.rescue.foodDeliveryWebService.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    @ApiOperation(
            value = "주문"
            ,notes = "로그인 상태에서 쿠기에 세션값을 보내서 진행\nOrderDto 채워서 보내기"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message ="주문 성공"),
            @ApiResponse(code= 400, message = "주문 실패")
    })
    @PostMapping("/make-order")
    public ResponseEntity<ResponseForm> makeOrder(@Valid @RequestBody OrderDto orderDto){
        log.info("reserved time: {}", orderDto.getReservationTime());
        if(!checkReservationTime(orderDto))
            return ResponseEntity.badRequest().body(buildResponseForm(false, "15시 반에서 22시까지만 오픈합니다."));


        OrderDto savedOrderDto = orderService.makeOrder(orderDto);
        log.info("savedorder: {}" , savedOrderDto);

        ResponseForm responseForm = ResponseForm.builder().success(true).build();
        return ResponseEntity.ok(responseForm);
    }

    private boolean checkReservationTime(OrderDto orderDto){
        LocalDateTime reservationTime = orderDto.getReservationTime();
        log.info("reserved time: {}", reservationTime);
        if(reservationTime == null)
            return true;

        int reservedHour = reservationTime.getHour();
        log.info("reservedHour: {}, noew{}", reservedHour, LocalDateTime.now());
        if(reservationTime.isAfter(LocalDateTime.now()) &&
                reservedHour > 15.5 && reservedHour < 22){

            log.info("true reservedHour: {}, noew{}", reservedHour, LocalDateTime.now());
            return true;
        }

        return false;
    }

    private ResponseForm buildResponseForm(Boolean isSuccess,String message){
        List<String> messages = new ArrayList<>();
        messages.add(message);

        return ResponseForm.builder()
                .success(isSuccess)
                .messages(messages)
                .build();
    }

}
