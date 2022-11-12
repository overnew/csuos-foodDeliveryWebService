package uoscs.rescue.foodDeliveryWebService.api;

public class TokenData {
    private static final String[] dinner = {"발렌타인", "프렌치", "잉글리시", "샴페인"};
    private static final String[] style = {"심플", "그랜드", "디럭스"};
    private static final String[] order = {"하나", "한개", "둘", "두개", "셋", "세개", "넷", "네개", "다섯", "여섯", "일곱", "여덜", "아홉", "열"};

    public String[] getDinner() {
        return dinner;
    }

    public String[] getStyle() {
        return style;
    }

    public String[] getOrder() {
        return order;
    }

    public static String[] getAll() {
        int resLength = dinner.length + style.length + order.length;
        String[] res = new String[resLength];
        
        System.arraycopy(dinner, 0, res, 0, dinner.length);
        System.arraycopy(style, 0, res, dinner.length, style.length);
        System.arraycopy(order, 0, res, dinner.length + style.length, order.length);

        return res;
    }
}