package coherent.practica.candyshop.exception;

public class CandyNotFoundException extends NotFoundExceptionBase{

    public CandyNotFoundException(String name) {
        super("Candy", name);
    }
}
