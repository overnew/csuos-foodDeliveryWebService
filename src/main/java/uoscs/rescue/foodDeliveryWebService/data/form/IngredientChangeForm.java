package uoscs.rescue.foodDeliveryWebService.data.form;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IngredientChangeForm {
    private int steak;
    private int bacon;
    private int eggScramble;
    private int bread;
    private int baguetteBread;
    private int salad;
    private int coffee_cup;
    private int coffee_port;
    private int wine;
    private int champagne;
}
