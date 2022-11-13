package uoscs.rescue.foodDeliveryWebService.data.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Getter
@Entity(name = "stock")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Stock {
    @Id
    private String id;

    private int steak;
    private int bacon;
    private int eggScramble;
    private int bread;
    private int salad;
    private int coffee;
    private int wine;
    private int champagne;
}
