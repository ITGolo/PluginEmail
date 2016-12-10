package pl.itgolo.plugin.email.Exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Karol Golec
 * Date: 11.11.2016
 * Time: 20:43
 */
public class IncorrectEmailException extends Exception {

    /**
     * Constructor
     */
    public IncorrectEmailException() {

    }

    /**
     * Constructor
     * @param message message exception
     */
    public IncorrectEmailException(String message) {
        super (message);
    }

    /**
     * Constructor
     * @param cause cause exception
     */
    public IncorrectEmailException(Throwable cause) {
        super (cause);
    }

    /**
     * Constructor
     * @param message message exception
     * @param cause cause exception
     */
    public IncorrectEmailException(String message, Throwable cause) {
        super (message, cause);
    }
}