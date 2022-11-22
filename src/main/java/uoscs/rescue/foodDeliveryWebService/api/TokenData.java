package uoscs.rescue.foodDeliveryWebService.api;

import uoscs.rescue.foodDeliveryWebService.data.enums.DinnerStyle;
import uoscs.rescue.foodDeliveryWebService.data.enums.DinnerType;

import java.util.*;

public class TokenData {
    private static final Map<String, DinnerType> type = new HashMap<>() {{
        put("발렌타인", DinnerType.VALENTINE);
        put("프렌치", DinnerType.FRENCH);
        put("잉글리쉬", DinnerType.ENGLISH);
        put("샴페인", DinnerType.CHAMPAGNE);
    }};
    private static final Map<String, DinnerStyle> style = new HashMap<>() {{
        put("심플", DinnerStyle.SIMPLE);
        put("그랜드", DinnerStyle.GRAND);
        put("디럭스", DinnerStyle.DELUXE);
    }};
    private static final Map<String, Integer> number = new HashMap<>() {{
        put("하나", 1); put("한개", 1);
        put("둘", 2); put("두개", 2);
        put("셋", 3); put("세개", 3);
        put("넷", 4); put("네개", 4);
        put("다섯", 5);
        put("여섯", 6);
        put("일곱", 7);
        put("여덟", 8);
        put("아홉", 9);
        put("열", 10);
    }};

    public static Map<String, DinnerType> getType() {
        return type;
    }
    public static Map<String, DinnerStyle> getStyle() {
        return style;
    }

    public static Map<String, Integer> getNumber() {
        return number;
    }

    public static List<String> getAllKey() {
        List<String> res = new ArrayList<>();
        res.addAll(new ArrayList<>(type.keySet()));
        res.addAll(new ArrayList<>(style.keySet()));
        res.addAll(new ArrayList<>(number.keySet()));

        return res;
    }
}