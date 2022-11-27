package uoscs.rescue.foodDeliveryWebService.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//<<<<<<< api
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uoscs.rescue.foodDeliveryWebService.api.STTService;
import uoscs.rescue.foodDeliveryWebService.data.dto.OrderDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Order;
//=======
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uoscs.rescue.foodDeliveryWebService.data.form.SessionForm;
import uoscs.rescue.foodDeliveryWebService.data.mapper.OrderMapper;
import uoscs.rescue.foodDeliveryWebService.service.OrderService;
import uoscs.rescue.foodDeliveryWebService.utils.SessionConst;
//>>>>>>> master

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
//<<<<<<< api
import java.util.ArrayList;
import java.util.List;
//=======
import java.net.URI;
import java.util.List;

//>>>>>>> master

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/stt")
public class STTController {

    @Autowired
    private final OrderMapper orderMapper;
    @Autowired
    private final OrderService orderService;

    @ApiOperation(
            value = "음성을 form-data, [key:file, data: 음성]  으로 보내며됨"
            ,notes = "반환된 OrderDto list는 type에 따른 재료를 가지고 있음, 이외의 order정보는 null임"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message ="List<OrderDto>, 재료랑 style,type 제외하고는 null")
    })
    @PostMapping("/voice-data")
    public ResponseEntity<List<OrderDto>> voiceData(@RequestParam("file") MultipartFile file) throws ServletException, IOException {  //어떤 클래스일지는 모르겠
        //HttpSession session = httpServletRequest.getSession();
        //SessionForm sessionForm = (SessionForm)session.getAttribute(SessionConst.SESSION_FORM);

        STTService sttService = new STTService();

        InputStream inputStream = file.getInputStream();
        byte[] bytes = inputStream.readAllBytes();

        List<OrderDto> orderList = new ArrayList<>();
        sttService.STTService(bytes).stream().forEach(order -> {
                    log.info("parsed order : {}",order.toString());
                    orderList.add(orderService.fillIngredientByType(order));
                });
        //orderList.stream().forEach(order -> log.info(order.toString()));

        return ResponseEntity.ok(orderList);
    }
}
