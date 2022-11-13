package uoscs.rescue.foodDeliveryWebService.data.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StockDto {
    private int steak;
    private int bacon;
    private int eggScramble;
    private int bread;
    private int salad;
    private int coffee;
    private int wine;
    private int champagne;
}
