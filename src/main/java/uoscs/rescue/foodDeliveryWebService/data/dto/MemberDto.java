package uoscs.rescue.foodDeliveryWebService.data.dto;

import lombok.*;
import uoscs.rescue.foodDeliveryWebService.data.enums.Authority;
import uoscs.rescue.foodDeliveryWebService.data.enums.Grade;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDto {
    private String id;

    //@Column(nullable = false)
    private String password;

    private String name;
    private String address;

    private boolean personalInfoAgreement;

    private List<OrderDto> orderDtoList;

    private Grade grade;
    private Authority authority;
}
