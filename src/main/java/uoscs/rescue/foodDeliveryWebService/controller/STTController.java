package uoscs.rescue.foodDeliveryWebService.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import uoscs.rescue.foodDeliveryWebService.data.form.SessionForm;
import uoscs.rescue.foodDeliveryWebService.utils.SessionConst;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/stt")
public class STTController {

    @PostMapping("/voice-data")
    public void voiceData(HttpServletRequest httpServletRequest) throws IOException {  //어떤 클래스일지는 모르겠
        //HttpSession session = httpServletRequest.getSession();
        //SessionForm sessionForm = (SessionForm)session.getAttribute(SessionConst.SESSION_FORM);

        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\voice";
        InputStream inputStream = httpServletRequest.getInputStream();

        //tmp로 만들면 jvm 종료시 자동제거
        File voiceFile = File.createTempFile( "voice_" /*+sessionForm.getId()+"_"*/ +String.valueOf(inputStream.hashCode()), ".tmp", new File(path));
        log.info("success! saved in {}",voiceFile.getAbsolutePath());
    }

}
