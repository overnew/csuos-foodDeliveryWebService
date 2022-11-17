package uoscs.rescue.foodDeliveryWebService.api;

import uoscs.rescue.foodDeliveryWebService.data.entity.Order;
import uoscs.rescue.foodDeliveryWebService.data.enums.DinnerStyle;
import uoscs.rescue.foodDeliveryWebService.data.enums.DinnerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// dinner style 이 등장하면 order 객체 생성 시작,
// 다음 dinner style 이 언급되거나 text 가 끝나면 order 객체를 orders list 에 add 하고 order 객체 초기화.
// order 객체 생성에서 order 객체 초기화 사이에 언급된 style type 을 뜻하는 단어가 나오면 해당 정보를 order 객체에 추가함.
// 그 사이에 숫자가 언급되면 number 에 반영하여 끝에 orders list 에 add 할 횟수를 결정함.

class TokenParsing {
    protected static List<Order> parsingOrder(List<String> text) {

        List<Order> orders = new ArrayList<Order>();

        Map<String, DinnerType> type = TokenData.getType();
        Map<String, DinnerStyle> style = TokenData.getStyle();
        Map<String, Integer> number = TokenData.getNumber();

        int point = 0;
        int num = 1;
        Order order = new Order();
        for (String word: text) {

            for (String dinner_type: type.keySet()) {
                if (word.contains(dinner_type)) {
                    if (point == 0) {
                        order.setDinnerType(type.get(dinner_type));
                        point = 1;
                    }
                    else {
                        for (int i = 0; i < num; i ++) {
                            orders.add(order);
                        }
                        point = 0;
                        order = new Order();
                    }
                }
            }

            if (point == 0) {}
            else {
                for (String dinner_style: style.keySet()) {
                    if (word.contains(dinner_style)) {
                        order.setDinnerStyle(style.get(dinner_style));
                    }
                }

                for (String dinner_number: number.keySet()) {
                    if (word.contains(dinner_number)) {
                        num += number.get(dinner_number);
                    }
                }
            }
        }
        return orders;
    }
}