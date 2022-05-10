package coherent.practica.candyshop.model;

import coherent.practica.candyshop.exception.AlreadyAddedExceptionBase;
import coherent.practica.candyshop.exception.InvalidLoginDetailsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvalidLoginDetailsExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(InvalidLoginDetailsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String ReservationAlreadyAddedHandler(InvalidLoginDetailsException ex) {
        return ex.getMessage();
    }

}