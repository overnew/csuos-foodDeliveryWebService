package uoscs.rescue.foodDeliveryWebService.data.dto;

import lombok.*;
import uoscs.rescue.foodDeliveryWebService.data.entity.Ingredient;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StockDto {
    private IngredientDto steak;
    private IngredientDto bacon;
    private IngredientDto eggScramble;
    private IngredientDto bread;
    private IngredientDto baguetteBread;
    private IngredientDto salad;
    private IngredientDto coffee_cup;
    private IngredientDto coffee_port;
    private IngredientDto wine;
    private IngredientDto champagne;
}
