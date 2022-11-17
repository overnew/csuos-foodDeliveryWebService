package uoscs.rescue.foodDeliveryWebService.exception;

public class StockValueException extends RuntimeException{
    public StockValueException(String message) {
        super(message);
    }

    public StockValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
