package pl.itgolo.plugin.email.Exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Karol Golec
 * Date: 11.11.2016
 * Time: 20:43
 */
public class MessageException extends Exception {

    /**
     * Constructor
     */
    public MessageException() {

    }

    /**
     * Constructor
     * @param message message exception
     */
    public MessageException(String message) {
        super (message);
    }

    /**
     * Constructor
     * @param cause cause exception
     */
    public MessageException(Throwable cause) {
        super (cause);
    }

    /**
     * Constructor
     * @param message message exception
     * @param cause cause exception
     */
    public MessageException(String message, Throwable cause) {
        super (message, cause);
    }
}