package uoscs.rescue.foodDeliveryWebService.data.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import uoscs.rescue.foodDeliveryWebService.data.enums.DinnerStyle;
import uoscs.rescue.foodDeliveryWebService.data.enums.DinnerType;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDto {
    @Null(message = "주문의 id값은 지정 불가")
    private Long id;

    private LocalDateTime orderTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime reservationTime;

    @NotBlank(message = "주문하는 회원 명시 필수")
    private String orderedMemberId;

    @Positive(message = "가격은 양수이어야 합니다.")
    private Integer price;

    @NotBlank(message = "주소는 필수 기입해주세요.")
    private String address;

    @NotNull
    @AssertFalse(message = "주문 수락은 서비스에서 결정합니다.")
    private boolean accepted;

    @NotNull(message = "DinnerType 선택필수")
    private DinnerType dinnerType;
    @NotNull(message = "DinnerStyle 선택필수")
    private DinnerStyle dinnerStyle;

    @PositiveOrZero(message = "구성품은 음수 불가능")
    private int steak;
    //@PositiveOrZero(message = "구성품은 음수 불가능")
    private int bacon;
    //@PositiveOrZero(message = "구성품은 음수 불가능")
    private int eggScramble;
    //@PositiveOrZero(message = "구성품은 음수 불가능")
    private int bread;
    private int baguetteBread;
    //@PositiveOrZero(message = "구성품은 음수 불가능")
    private int salad;
    //@PositiveOrZero(message = "구성품은 음수 불가능")
    private int coffee_cup;
    private int coffee_port;
    //@PositiveOrZero(message = "구성품은 음수 불가능")
    private int wine;
    //@PositiveOrZero(message = "구성품은 음수 불가능")
    private int champagne;
}
