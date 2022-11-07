package uoscs.rescue.foodDeliveryWebService.exception;

public class NoSuchMemberException extends RuntimeException{
    public NoSuchMemberException() {
    }

    public NoSuchMemberException(String message) {
        super(message);
    }

    public NoSuchMemberException(String message, Throwable cause) {
        super(message, cause);
    }
}
