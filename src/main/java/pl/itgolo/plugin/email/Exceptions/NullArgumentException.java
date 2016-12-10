package pl.itgolo.plugin.email.Exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Karol Golec
 * Date: 11.11.2016
 * Time: 20:43
 */
public class NullArgumentException extends Exception {

    /**
     * Constructor
     */
    public NullArgumentException() {

    }

    /**
     * Constructor
     * @param message message exception
     */
    public NullArgumentException(String message) {
        super (message);
    }

    /**
     * Constructor
     * @param cause cause exception
     */
    public NullArgumentException(Throwable cause) {
        super (cause);
    }

    /**
     * Constructor
     * @param message message exception
     * @param cause cause exception
     */
    public NullArgumentException(String message, Throwable cause) {
        super (message, cause);
    }
}