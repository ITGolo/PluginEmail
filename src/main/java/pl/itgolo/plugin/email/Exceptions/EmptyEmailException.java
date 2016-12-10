package pl.itgolo.plugin.email.Exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Karol Golec
 * Date: 11.11.2016
 * Time: 20:43
 */
public class EmptyEmailException extends Exception {

    /**
     * Constructor
     */
    public EmptyEmailException() {

    }

    /**
     * Constructor
     * @param message message exception
     */
    public EmptyEmailException(String message) {
        super (message);
    }

    /**
     * Constructor
     * @param cause cause exception
     */
    public EmptyEmailException(Throwable cause) {
        super (cause);
    }

    /**
     * Constructor
     * @param message message exception
     * @param cause cause exception
     */
    public EmptyEmailException(String message, Throwable cause) {
        super (message, cause);
    }
}