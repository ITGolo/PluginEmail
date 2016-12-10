package pl.itgolo.plugin.email.Exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Karol Golec
 * Date: 11.11.2016
 * Time: 20:43
 */
public class PropertyException extends Exception {

    /**
     * Constructor
     */
    public PropertyException() {

    }

    /**
     * Constructor
     * @param message message exception
     */
    public PropertyException(String message) {
        super (message);
    }

    /**
     * Constructor
     * @param cause cause exception
     */
    public PropertyException(Throwable cause) {
        super (cause);
    }

    /**
     * Constructor
     * @param message message exception
     * @param cause cause exception
     */
    public PropertyException(String message, Throwable cause) {
        super (message, cause);
    }
}