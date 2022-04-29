package coherent.practica.candyshop.exception;

public class CategoryNotFoundException extends NotFoundExceptionBase{
    public CategoryNotFoundException(String name) {
        super("Category ", name);
    }

}
