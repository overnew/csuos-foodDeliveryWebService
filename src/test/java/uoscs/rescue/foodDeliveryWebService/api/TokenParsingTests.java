package uoscs.rescue.foodDeliveryWebService.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import uoscs.rescue.foodDeliveryWebService.data.entity.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static uoscs.rescue.foodDeliveryWebService.api.TokenParsing.parsingOrder;

@SpringBootTest
public class TokenParsingTests {

    @Test
    void requestTextToOrders() {
        List<String> text = new ArrayList<>(Arrays.asList(
                "발렌타인", "심플", "하나랑", "프렌치", "그랜드", "그리고", "발렌타인", "디럭스",
                "다섯", "개", "주세요", "아", "그리고", "샴페인", "하고", "잉글리쉬", "하나씩", "주세요"));

        List<Order> orders = new ArrayList<>(parsingOrder(text));
        System.out.println(orders);

        int a = 0;

        for (Order order: orders) {
            System.out.print(a);
            System.out.print(order.getDinnerType());
            System.out.println(order.getDinnerStyle());
            a++;
        }
    }
}
