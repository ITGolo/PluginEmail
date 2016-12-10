package pl.itgolo.plugin.email.Exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Karol Golec
 * Date: 11.11.2016
 * Time: 20:43
 */
public class NullEmailException extends Exception {

    /**
     * Constructor
     */
    public NullEmailException() {

    }

    /**
     * Constructor
     * @param message message exception
     */
    public NullEmailException(String message) {
        super (message);
    }

    /**
     * Constructor
     * @param cause cause exception
     */
    public NullEmailException(Throwable cause) {
        super (cause);
    }

    /**
     * Constructor
     * @param message message exception
     * @param cause cause exception
     */
    public NullEmailException(String message, Throwable cause) {
        super (message, cause);
    }
}