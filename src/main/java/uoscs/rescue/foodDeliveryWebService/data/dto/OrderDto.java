package uoscs.rescue.foodDeliveryWebService.data.dto;

import lombok.*;
import uoscs.rescue.foodDeliveryWebService.data.enums.DinnerStyle;
import uoscs.rescue.foodDeliveryWebService.data.enums.DinnerType;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDto {
    private Long id;

    private LocalDateTime orderTime;

    private String orderedMemberId;

    private Integer price;

    private String address;

    private boolean accepted;

    private DinnerType dinnerType;
    private DinnerStyle dinnerStyle;

    private int steak;
    private int bacon;
    private int eggScramble;
    private int bread;
    private int salad;
    private int coffee;
    private int wine;
    private int champagne;
}
