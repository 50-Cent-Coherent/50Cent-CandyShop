package coherent.practica.candyshop.exception;

public class InvalidLoginDetailsException extends RuntimeException {
    public InvalidLoginDetailsException(String name) {
        super("An error occured when trying to login "+ name);
    }
}
