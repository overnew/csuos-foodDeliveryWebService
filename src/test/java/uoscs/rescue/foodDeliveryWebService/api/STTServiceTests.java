package uoscs.rescue.foodDeliveryWebService.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import uoscs.rescue.foodDeliveryWebService.data.entity.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@SpringBootTest
public class STTServiceTests {

    @Test
    void requestSpeechOrder() {
        ClassPathResource resource = new ClassPathResource("SpeechTest.flac");

        STTService sttService = new STTService();
        List<Order> res;


        try {
            res = sttService.STTService(Files.readAllBytes(Paths.get(resource.getURI())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int a = 0;

        for (Order order: res) {
            System.out.print(a);
            System.out.print(order.getDinnerType());
            System.out.println(order.getDinnerStyle());
            a++;
        }

    }
}
