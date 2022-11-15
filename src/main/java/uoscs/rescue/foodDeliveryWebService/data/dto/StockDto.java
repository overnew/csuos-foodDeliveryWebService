package uoscs.rescue.foodDeliveryWebService.data.dto;

import lombok.*;

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
    private IngredientDto salad;
    private IngredientDto coffee;
    private IngredientDto wine;
    private IngredientDto champagne;
}
