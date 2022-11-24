package uoscs.rescue.foodDeliveryWebService.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.nio.file.Files;
<<<<<<< Updated upstream
=======
import java.nio.file.Path;
>>>>>>> Stashed changes
import java.nio.file.Paths;
import java.util.List;

import static uoscs.rescue.foodDeliveryWebService.api.SpeechAPI.syncRecognizeFile;

@SpringBootTest
public class SpeechAPITests {

    @Test
    void requestSpeechToText() {
        ClassPathResource resource = new ClassPathResource("SpeechTest.opus");

        List<String> res;

        try {
            res = syncRecognizeFile(Files.readAllBytes(Paths.get(resource.getURI())));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(res);
    }
}