package uoscs.rescue.foodDeliveryWebService.data.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Getter
@Setter
@Entity(name = "ingredient")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ingredient {
    @Id
    @Column(name = "ingredient_id")
    private String id;

    private String name;
    private int quantity;

    public void addQuantity(int quantity){
        this.quantity += quantity;
    }

}
