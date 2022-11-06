package uoscs.rescue.foodDeliveryWebService.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@Entity(name = "membered")
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    private String id;

    //@Column(nullable = false)
    private String password;

    private String name;
    private String address;

    private boolean personalInfoAgreement;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderedMember", fetch = FetchType.EAGER)
    //@JoinColumn(name = "order_id")
    @ToString.Exclude
    private List<Order> orderList;

/*
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orders_id")
    private Order myorder; */

}
