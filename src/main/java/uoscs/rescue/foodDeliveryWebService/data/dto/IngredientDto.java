package uoscs.rescue.foodDeliveryWebService.data.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IngredientDto {
    private String name;
    private int quantity;
}
