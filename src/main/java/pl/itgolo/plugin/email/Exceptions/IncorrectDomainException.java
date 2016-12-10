package pl.itgolo.plugin.email.Exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Karol Golec
 * Date: 11.11.2016
 * Time: 20:43
 */
public class IncorrectDomainException extends Exception {

    /**
     * Constructor
     */
    public IncorrectDomainException() {

    }

    /**
     * Constructor
     * @param message message exception
     */
    public IncorrectDomainException(String message) {
        super (message);
    }

    /**
     * Constructor
     * @param cause cause exception
     */
    public IncorrectDomainException(Throwable cause) {
        super (cause);
    }

    /**
     * Constructor
     * @param message message exception
     * @param cause cause exception
     */
    public IncorrectDomainException(String message, Throwable cause) {
        super (message, cause);
    }
}