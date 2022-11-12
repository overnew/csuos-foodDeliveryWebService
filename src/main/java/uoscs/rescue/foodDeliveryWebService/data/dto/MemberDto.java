package uoscs.rescue.foodDeliveryWebService.data.dto;

import lombok.*;
import uoscs.rescue.foodDeliveryWebService.data.enums.Authority;
import uoscs.rescue.foodDeliveryWebService.data.enums.Grade;

import javax.validation.constraints.*;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDto {
    @Pattern(regexp="[a-zA-Z1-9]{6,12}", message = "아이디는 영어와 숫자로 포함해서 6~12자리 이내로 입력해주세요.")
    private String id;

    @Pattern(regexp="[a-zA-Z1-9]{6,12}", message = "비밀번호는 영어와 숫자로 포함해서 6~12자리 이내로 입력해주세요.")
    private String password;


    private String name;
    private String address;

    @NotNull
    private boolean personalInfoAgreement;

    @Null
    private List<OrderDto> orderDtoList;

    @Null(message = "단골 여부는 직접 설정할 수 없습니다.")
    private Grade grade;

    @Null(message = "권한은 직접 설정할 수 없습니다.")
    private Authority authority;
}
