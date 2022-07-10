package tinnova.carsCrud.model.exceptions;


/**
 * A custom exception class to be used to show to the user of the request a more friendly error message
 *
 * @author Rafael Furtado
 */
public class InternalServerErrorException extends Exception {

    public InternalServerErrorException(String message) {
        super(message);

    }

}
