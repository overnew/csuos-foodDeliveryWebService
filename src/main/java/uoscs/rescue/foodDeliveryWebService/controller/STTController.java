package uoscs.rescue.foodDeliveryWebService.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import uoscs.rescue.foodDeliveryWebService.api.STTService;
import uoscs.rescue.foodDeliveryWebService.data.entity.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/stt")
public class STTController {

    @PostMapping("/voice-data")
    public void voiceData(HttpServletRequest httpServletRequest) throws ServletException, IOException {  //어떤 클래스일지는 모르겠
        //HttpSession session = httpServletRequest.getSession();
        //SessionForm sessionForm = (SessionForm)session.getAttribute(SessionConst.SESSION_FORM);

        List<Order> orderList;
        STTService sttService = new STTService();

        InputStream inputStream = httpServletRequest.getPart("file").getInputStream();
        byte[] bytes = inputStream.readAllBytes();

        orderList = new ArrayList<>(sttService.STTService(bytes));
    }

}
