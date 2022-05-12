package coherent.practica.candyshop.exception;

public class CategoryAlreadyAddedException extends AlreadyAddedExceptionBase {

    public CategoryAlreadyAddedException(String name) {
        super("Category", name);
    }
}
