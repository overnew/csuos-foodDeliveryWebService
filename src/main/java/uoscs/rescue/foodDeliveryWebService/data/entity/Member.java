package uoscs.rescue.foodDeliveryWebService.data.entity;

import lombok.*;
import uoscs.rescue.foodDeliveryWebService.data.enums.Authority;
import uoscs.rescue.foodDeliveryWebService.data.enums.Grade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@Entity(name = "membered")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
    @Id
    private String id;

    //@Column(nullable = false)
    private String password;

    private String name;
    private String address;

    private boolean personalInfoAgreement;

    private String creditCard;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderedMember", fetch = FetchType.EAGER)
    //@JoinColumn(name = "order_id")
    @ToString.Exclude
    private List<Order> orderList;

    private Grade grade;

    private Authority authority;

/*
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orders_id")
    private Order myorder; */

}
