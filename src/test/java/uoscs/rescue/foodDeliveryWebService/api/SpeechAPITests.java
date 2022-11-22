package uoscs.rescue.foodDeliveryWebService.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import java.util.List;

import static uoscs.rescue.foodDeliveryWebService.api.SpeechAPI.syncRecognizeFile;

@SpringBootTest
public class SpeechAPITests {

    @Test
    void requestSpeechToText() {
        ClassPathResource resource = new ClassPathResource("SpeechTest.flac");

        List<String> res;

        try {
            res = syncRecognizeFile(resource.getURI());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(res);
    }
}