package uoscs.rescue.foodDeliveryWebService.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uoscs.rescue.foodDeliveryWebService.api.SpeechAPI;
import uoscs.rescue.foodDeliveryWebService.data.form.SessionForm;
import uoscs.rescue.foodDeliveryWebService.utils.SessionConst;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

import static uoscs.rescue.foodDeliveryWebService.api.SpeechAPI.syncRecognizeFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/stt")
public class STTController {


    @PostMapping("/voice-data")
    public void voiceData(HttpServletRequest httpServletRequest) throws Exception {  //어떤 클래스일지는 모르겠
        //HttpSession session = httpServletRequest.getSession();
        //SessionForm sessionForm = (SessionForm)session.getAttribute(SessionConst.SESSION_FORM);

        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\voice";
        InputStream inputStream = httpServletRequest.getInputStream();

        //tmp로 만들면 jvm 종료시 자동제거
        File voiceFile = File.createTempFile( "voice_" /*+sessionForm.getId()+"_"*/ +String.valueOf(inputStream.hashCode()), ".flac", new File(path));
        log.info("success! saved in {}",voiceFile.getAbsolutePath());
inputStream.close();
        String absolutePath = voiceFile.getAbsolutePath();
        String replacedPath = absolutePath.replace('\\', '/');
        log.info("path: {}", replacedPath);
        //List<String> strings = syncRecognizeFile(URI.create( "file:/"+replacedPath));
        //strings.stream().forEach(str -> log.info(str));
    }

    @GetMapping("voice-test")
    public void voiceTest() throws Exception {
        ClassPathResource resource = new ClassPathResource("SpeechTest.flac");
        log.info("uri: {}", resource.getURI().toString());/*
        List<String> strings = syncRecognizeFile(resource.getURI());
        strings.stream().forEach(str -> log.info(str));*/
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
        List<String> strings = syncRecognizeFile(file.getInputStream().readAllBytes());
        strings.stream().forEach(str -> log.info(str));
        return "success";
    }
}
