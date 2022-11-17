package uoscs.rescue.foodDeliveryWebService.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uoscs.rescue.foodDeliveryWebService.data.dto.OrderDto;
import uoscs.rescue.foodDeliveryWebService.data.dto.StockDto;
import uoscs.rescue.foodDeliveryWebService.data.form.IngredientChangeForm;
import uoscs.rescue.foodDeliveryWebService.data.form.ResponseForm;
import uoscs.rescue.foodDeliveryWebService.service.ManageService;
import uoscs.rescue.foodDeliveryWebService.service.StockService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    private final ManageService manageService;
    @Autowired
    private final StockService stockService;

    @GetMapping("/all-orders")
    public Page<OrderDto> getAllOrderPageList(
            @PageableDefault(size = 5, sort="id",direction = Sort.Direction.DESC) Pageable pageable) {

        List<OrderDto> orderDtoList = manageService.getAllOrderDtoList();

        final int start = (int)pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), orderDtoList.size());
        final Page<OrderDto> page = new PageImpl<>(orderDtoList.subList(start, end), pageable, orderDtoList.size());

        return page;
    }

    @PostMapping("/accept-order")
    public ResponseEntity<ResponseForm> acceptOrder(@RequestParam Long orderId){
        manageService.acceptOrderById(orderId);

        return ResponseEntity.ok(ResponseForm.builder().success(true).build());
    }

    @GetMapping("/stock")
    public ResponseEntity<StockDto> getStockDtoData(){
        return ResponseEntity.ok(stockService.getStockData());
    }

    @PostMapping("/stock")
    public ResponseEntity<StockDto> getAppliedStockDtoData(@RequestBody IngredientChangeForm changeForm){
        stockService.applyIngredientChangeForm(changeForm);

        return ResponseEntity.ok(stockService.getStockData());
    }
}
