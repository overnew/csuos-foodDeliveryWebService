package uoscs.rescue.foodDeliveryWebService.data.entity;

import lombok.*;
import uoscs.rescue.foodDeliveryWebService.data.enums.DinnerStyle;
import uoscs.rescue.foodDeliveryWebService.data.enums.DinnerType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@Entity(name = "orders")
//@Table(name = "order_pure")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(nullable = false)
    private LocalDateTime orderTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "membered_id")
    //@OneToOne(mappedBy = "myorder")
    @ToString.Exclude
    private Member orderedMember;

    //@Column(nullable = false)
    private Integer price;

    //@Column(nullable = false)
    private String address;

    //@Column(nullable = false)
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
