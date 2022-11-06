package uoscs.rescue.foodDeliveryWebService.data.entity;

import lombok.*;

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
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    //@Column(nullable = false)
    private LocalDateTime orderTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "membered_id")
    //@ToString.Exclude
    //@OneToOne(mappedBy = "myorder")
    @ToString.Exclude
    private Member orderedMember;

    //@Column(nullable = false)
    private Integer price;

    //@Column(nullable = false)
    private String address;

    //@Column(nullable = false)
    private boolean accepted;
}
