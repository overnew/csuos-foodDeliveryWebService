package uoscs.rescue.foodDeliveryWebService.data.form;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ResponseForm {
    private boolean success;
    private List<String> messages;
}
