package uoscs.rescue.foodDeliveryWebService.data.dto;

import lombok.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDto {
    private String id;

    private LocalDateTime orderTime;

    private String orderedMemberId;

    private Integer price;

    private String address;

    private boolean accepted;
}
