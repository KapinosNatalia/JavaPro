public class ProductInfoAlreadyExistException extends RuntimeException{
    public ProductInfoAlreadyExistException() {
    }

    public ProductInfoAlreadyExistException(String message) {
        super(message);
    }
}
