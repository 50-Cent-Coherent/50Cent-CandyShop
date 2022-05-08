package coherent.practica.candyshop.exception;

public class UserNotFoundException extends NotFoundExceptionBase{
    public UserNotFoundException(String name) {
        super("User ", name);
    }

}
