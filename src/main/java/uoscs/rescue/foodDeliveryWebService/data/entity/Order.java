package uoscs.rescue.foodDeliveryWebService.data.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@Entity(name = "order_pure")
//@Table(name = "order_pure")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderpureid;

    //@Column(nullable = false)
    private LocalDateTime orderTime;


/*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    @ToString.Exclude*/

    @OneToOne(mappedBy = "myorder", fetch = FetchType.EAGER)
    @ToString.Exclude
    private Member orderedMember;

    //@Column(nullable = false)
    private Integer price;

    //@Column(nullable = false)
    private String address;

    //@Column(nullable = false)
    private boolean accepted;
}
