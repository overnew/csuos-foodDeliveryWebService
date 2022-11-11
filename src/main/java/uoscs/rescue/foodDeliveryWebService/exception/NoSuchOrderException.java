package uoscs.rescue.foodDeliveryWebService.exception;

public class NoSuchOrderException extends RuntimeException{
    public NoSuchOrderException() {
    }

    public NoSuchOrderException(String message) {
        super(message);
    }

    public NoSuchOrderException(String message, Throwable cause) {
        super(message, cause);
    }
}
