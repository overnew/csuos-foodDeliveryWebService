package uoscs.rescue.foodDeliveryWebService.data.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Setter
@Getter
@Entity(name = "stock")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Stock {
    @Id
    private String id;

    @OneToOne
    @JoinColumn//(name = "ingredient_id")
    private Ingredient steak;

    @OneToOne
    @JoinColumn//(name = "ingredient_id")
    private Ingredient bacon;

    @OneToOne
    @JoinColumn//(name = "ingredient_id")
    private Ingredient eggScramble;

    @OneToOne
    @JoinColumn//(name = "ingredient_id")
    private Ingredient bread;

    @OneToOne
    @JoinColumn//(name = "ingredient_id")
    private Ingredient baguetteBread;

    @OneToOne
    @JoinColumn//(name = "ingredient_id")
    private Ingredient salad;

    @OneToOne
    @JoinColumn//(name = "ingredient_id")
    private Ingredient coffee_cup;

    @OneToOne
    @JoinColumn//(name = "ingredient_id")
    private Ingredient coffee_port;

    @OneToOne
    @JoinColumn//(name = "ingredient_id")
    private Ingredient wine;

    @OneToOne
    @JoinColumn//(name = "ingredient_id")
    private Ingredient champagne;
}
