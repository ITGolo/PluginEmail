package pl.itgolo.plugin.email.Exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Karol Golec
 * Date: 11.11.2016
 * Time: 20:43
 */
public class InternetConnectionException extends Exception {

    /**
     * Constructor
     */
    public InternetConnectionException() {

    }

    /**
     * Constructor
     * @param message message exception
     */
    public InternetConnectionException(String message) {
        super (message);
    }

    /**
     * Constructor
     * @param cause cause exception
     */
    public InternetConnectionException(Throwable cause) {
        super (cause);
    }

    /**
     * Constructor
     * @param message message exception
     * @param cause cause exception
     */
    public InternetConnectionException(String message, Throwable cause) {
        super (message, cause);
    }
}