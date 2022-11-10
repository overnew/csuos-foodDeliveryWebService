package uoscs.rescue.foodDeliveryWebService.data.enums;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Authority {
    ADMIN(0), GENERAL(1);
    int value;
}
