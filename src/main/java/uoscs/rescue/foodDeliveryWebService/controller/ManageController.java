package uoscs.rescue.foodDeliveryWebService.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.dto.OrderDto;
import uoscs.rescue.foodDeliveryWebService.data.dto.StockDto;
import uoscs.rescue.foodDeliveryWebService.data.form.IngredientChangeForm;
import uoscs.rescue.foodDeliveryWebService.data.form.ResponseForm;
import uoscs.rescue.foodDeliveryWebService.service.ManageService;
import uoscs.rescue.foodDeliveryWebService.service.MemberService;
import uoscs.rescue.foodDeliveryWebService.service.StockService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    private final MemberService memberService;
    @Autowired
    private final ManageService manageService;
    @Autowired
    private final StockService stockService;

    @ApiOperation(
            value = "모든 주문 리스트 받아오기"
            ,notes = "Page 단위(5개가 들어있는 list)로 넘겨줌, parameter로 page: '숫자' 를 넘기면 해당 페이지를 가져옴"
    )
    @GetMapping("/all-orders")
    public Page<OrderDto> getAllOrderPageList(
            @PageableDefault(size = 5, sort="id",direction = Sort.Direction.DESC) Pageable pageable) {

        List<OrderDto> orderDtoList = manageService.getAllOrderDtoList();

        final int start = (int)pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), orderDtoList.size());
        final Page<OrderDto> page = new PageImpl<>(orderDtoList.subList(start, end), pageable, orderDtoList.size());

        return page;
    }

    @ApiOperation(
            value = "주문 수락하기"
            ,notes = "주문 리스트 페이지에서 주문을 수락, 파라미터로 해당 주문 아이디(Order_id)를 보내야함"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message ="주문 수락 성공"),
            @ApiResponse(code= 400, message = "주문 수락 실패")
    })
    @PostMapping("/accept-order")
    public ResponseEntity<ResponseForm> acceptOrder(@RequestParam Long orderId){
        manageService.acceptOrderById(orderId);

        return ResponseEntity.ok(ResponseForm.builder().success(true).build());
    }

    @ApiOperation(
            value = "재고 데이터 가져오기"
            ,notes = "StockDto로 가져옴"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message ="데이터 가져옴"),
            @ApiResponse(code= 400, message = "데이터 가져오기 실패")
    })
    @GetMapping("/stock")
    public ResponseEntity<StockDto> getStockDtoData(){
        return ResponseEntity.ok(stockService.getStockData());
    }

    @ApiOperation(
            value = "재고 데이터 수정 반영하기"
            ,notes = "IngredientChangeForm에 채운 정수값이 stock에 더해짐"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message ="적용 성공"),
            @ApiResponse(code= 400, message = "적용 실패")
    })
    @PostMapping("/stock")
    public ResponseEntity<StockDto> getAppliedStockDtoData(@RequestBody IngredientChangeForm changeForm){
        stockService.applyIngredientChangeForm(changeForm);

        return ResponseEntity.ok(stockService.getStockData());
    }

    @ApiOperation(
            value = "모든 회원 리스트 받아오기"
            ,notes = "Page 단위(5개가 들어있는 list)로 넘겨줌, parameter로 page: '숫자' 를 넘기면 해당 페이지를 가져옴"
    )
    @GetMapping("/all-members")
    public Page<MemberDto> getAllMemberPageList(
            @PageableDefault(size = 5, sort="id",direction = Sort.Direction.DESC) Pageable pageable) {

        List<MemberDto> memberDtoList = memberService.getAllMemberDtoList();

        final int start = (int)pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), memberDtoList.size());
        final Page<MemberDto> page = new PageImpl<>(memberDtoList.subList(start, end), pageable, memberDtoList.size());

        return page;
    }

    @ApiOperation(
            value = "멤버 데이터 수정 반영하기"
            ,notes = "MemberDto에 해당 id와 같이 바꿀 정보를 보내야만 적용됨, id를 제외한 모든 정보 변경 가능"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message ="관리자 권한 업데이트 적용 성공")
    })
    @PostMapping("/update-member")
    public ResponseEntity<ResponseForm> updateMemberByTargetId(
            @RequestBody MemberDto updateMemberDto
    ){
        //log.info("memberDto :{}", memberDto.toString());
        memberService.updateMemberByAdminAuth(updateMemberDto.getId(), updateMemberDto);
        return ResponseEntity.ok(ResponseForm.builder().success(true).build());
    }
}
