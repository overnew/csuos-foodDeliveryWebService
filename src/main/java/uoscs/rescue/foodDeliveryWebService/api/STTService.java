package uoscs.rescue.foodDeliveryWebService.api;

import uoscs.rescue.foodDeliveryWebService.data.entity.Order;
import uoscs.rescue.foodDeliveryWebService.exception.APIException;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class STTService {
    public List<Order> STTService(byte[] data) {

        List<String> res;
        try {
            res = SpeechAPI.syncRecognizeFile(data);
        } catch (Exception e) {
            throw new APIException("Speech Client creation failed", e);
        }

        return new ArrayList<Order>(TokenParsing.parsingOrder(res));
    }
}