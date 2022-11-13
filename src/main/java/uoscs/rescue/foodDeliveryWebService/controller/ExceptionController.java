package uoscs.rescue.foodDeliveryWebService.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uoscs.rescue.foodDeliveryWebService.data.form.ResponseForm;
import uoscs.rescue.foodDeliveryWebService.exception.NoSuchMemberException;
import uoscs.rescue.foodDeliveryWebService.exception.NoSuchOrderException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseForm> handleValidMemberException(MethodArgumentNotValidException exception){
        List<String> errorMessages = new ArrayList<>();

        exception.getBindingResult().getAllErrors().stream()
                        .forEach( (message) -> errorMessages.add(message.getDefaultMessage()));


        ResponseForm response = ResponseForm.builder()
                .success(false)
                .messages(errorMessages)
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoSuchMemberException.class)
    public ResponseEntity<ResponseForm> handleNoSuchMemberException(NoSuchMemberException exception){
        List<String> errorMessages = new ArrayList<>();
        errorMessages.add(exception.getMessage());

        ResponseForm response = ResponseForm.builder()
                .success(false)
                .messages(errorMessages)
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoSuchOrderException.class)
    public ResponseEntity<ResponseForm> handleNoSuchOrderException(NoSuchOrderException exception){
        List<String> errorMessages = new ArrayList<>();
        errorMessages.add(exception.getMessage());

        ResponseForm response = ResponseForm.builder()
                .success(false)
                .messages(errorMessages)
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
