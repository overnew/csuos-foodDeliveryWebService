package uoscs.rescue.foodDeliveryWebService.data.form;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StockApplyForm {
    private int steak;
    private int bacon;
    private int eggScramble;
    private int bread;
    private int salad;
    private int coffee;
    private int wine;
    private int champagne;
}
