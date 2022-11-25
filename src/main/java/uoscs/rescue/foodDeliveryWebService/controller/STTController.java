package uoscs.rescue.foodDeliveryWebService.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//<<<<<<< api
import org.springframework.web.bind.annotation.*;
import uoscs.rescue.foodDeliveryWebService.api.STTService;
import uoscs.rescue.foodDeliveryWebService.data.entity.Order;
//=======
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uoscs.rescue.foodDeliveryWebService.data.form.SessionForm;
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
    
    @PostMapping("/voice-data")
    public void voiceData(@RequestParam("file") MultipartFile file) throws ServletException, IOException {  //어떤 클래스일지는 모르겠
        //HttpSession session = httpServletRequest.getSession();
        //SessionForm sessionForm = (SessionForm)session.getAttribute(SessionConst.SESSION_FORM);

        List<Order> orderList;
        STTService sttService = new STTService();

        InputStream inputStream = file.getInputStream();
        byte[] bytes = inputStream.readAllBytes();

        orderList = new ArrayList<>(sttService.STTService(bytes));
        orderList.stream().forEach(str -> log.info(str.toString()));
    }

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file) throws Exception {
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\voice";
        InputStream inputStream = file.getInputStream();
        //File savedFile = new File(path);
        //tmp로 만들면 jvm 종료시 자동제거
        //File voiceFile = File.createTempFile( "voice_" /*+sessionForm.getId()+"_"*/ +String.valueOf(inputStream.hashCode()), ".flac", savedFile);
        //log.info("success! saved in {}",voiceFile.getAbsolutePath());
        //inputStream.close();

        //String absolutePath = voiceFile.getAbsolutePath();
        //String replacedPath = absolutePath.replace('\\', '/');
        //log.info("path: {}", savedFile.toURI());
        //List<String> strings = syncRecognizeFile(file.getInputStream().readAllBytes());
        //strings.stream().forEach(str -> log.info(str));
        return "success";
    }
}
