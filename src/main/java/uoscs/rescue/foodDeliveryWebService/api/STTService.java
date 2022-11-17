package uoscs.rescue.foodDeliveryWebService.api;

import uoscs.rescue.foodDeliveryWebService.data.entity.Order;
import uoscs.rescue.foodDeliveryWebService.exception.APIException;

import java.util.ArrayList;
import java.util.List;

public class STTService {
    public List<Order> STTService(String fileName) {

        List<String> res;
        try {
            res = SpeechAPI.syncRecognizeFile(fileName);
        } catch (Exception e) {
            throw new APIException("Speech Client creation failed");
        }

        return new ArrayList<Order>(TokenParsing.parsingOrder(res));
    }
}