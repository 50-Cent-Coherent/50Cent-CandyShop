package coherent.practica.candyshop.exception;

public class UserAlreadyAddedException extends AlreadyAddedExceptionBase {
    public UserAlreadyAddedException(String name) {
        super("User ", name);
    }
}
