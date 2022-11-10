package uoscs.rescue.foodDeliveryWebService.data.form;

import lombok.*;
import uoscs.rescue.foodDeliveryWebService.data.enums.Authority;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SessionForm {
    private String id;
    private Authority authority;
}
