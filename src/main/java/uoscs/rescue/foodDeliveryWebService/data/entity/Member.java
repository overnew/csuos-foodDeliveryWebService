package uoscs.rescue.foodDeliveryWebService.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Entity(name = "membered")
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    private String memberid;

    //@Column(nullable = false)
    private String password;

    private String name;
    private String address;

    private boolean personalInfoAgreement;
/*
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    @ToString.Exclude*/
    //private List<Order> orderList;

    @OneToOne
    @JoinColumn(name = "orderpureid")
    private Order myorder;
/*
    public void addOrder(Order order){
        if(orderList==null)
            orderList = new ArrayList<>();
        orderList.add(order);
    }*/
}
