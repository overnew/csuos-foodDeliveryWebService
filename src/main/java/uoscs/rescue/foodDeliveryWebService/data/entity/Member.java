package uoscs.rescue.foodDeliveryWebService.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@Entity
@Table(name = "member")
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    private String id;

    @Column(nullable = false)
    private String password;

    private String name;
    private String address;

    private boolean personalInfoAgreement;
}
