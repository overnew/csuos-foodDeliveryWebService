package uoscs.rescue.foodDeliveryWebService.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import uoscs.rescue.foodDeliveryWebService.api.STTService;
import uoscs.rescue.foodDeliveryWebService.data.entity.Order;
import uoscs.rescue.foodDeliveryWebService.utils.SessionConst;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/stt")
public class STTController {

    @PostMapping("/voice-data")
    public void voiceData(HttpServletRequest httpServletRequest) throws IOException, ServletException {  //어떤 클래스일지는 모르겠
        //HttpSession session = httpServletRequest.getSession();
        //SessionForm sessionForm = (SessionForm)session.getAttribute(SessionConst.SESSION_FORM);

        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\voice";
        InputStream inputStream;

        List<Order> orderList;

        log.info(httpServletRequest.getPart("file").getHeaderNames().toString());

        inputStream = httpServletRequest.getPart("file").getInputStream();

        STTService sttService = new STTService();

        byte[] bytes = inputStream.readAllBytes();

        log.info(Arrays.toString(bytes));

        orderList = new ArrayList<>(sttService.STTService(bytes));

        int a = 0;

        for (Order order: orderList) {
            System.out.print(a);
            System.out.print(order.getDinnerType());
            System.out.println(order.getDinnerStyle());
            a++;
        }

        //tmp로 만들면 jvm 종료시 자동제거
        File voiceFile = File.createTempFile( "voice_" /*+sessionForm.getId()+"_"*/ +String.valueOf(inputStream.hashCode()), ".tmp", new File(path));
        log.info("success! saved in {}",voiceFile.getAbsolutePath());

    }

}
