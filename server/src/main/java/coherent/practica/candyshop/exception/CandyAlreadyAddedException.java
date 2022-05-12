package coherent.practica.candyshop.exception;

public class CandyAlreadyAddedException extends AlreadyAddedExceptionBase {
    public CandyAlreadyAddedException(String name) {
        super("Candy", name);
    }
}
