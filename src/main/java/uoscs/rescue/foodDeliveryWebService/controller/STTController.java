package uoscs.rescue.foodDeliveryWebService.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
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
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\voice";
        InputStream inputStream = httpServletRequest.getInputStream();

        //tmp로 만들면 jvm 종료시 자동제거
        File voiceFile = File.createTempFile( "voice_"+String.valueOf(inputStream.hashCode()), ".tmp", new File(path));
        log.info("success! saved in {}",voiceFile.getAbsolutePath());
    }

}
