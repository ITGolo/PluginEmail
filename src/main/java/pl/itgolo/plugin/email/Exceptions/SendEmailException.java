package pl.itgolo.plugin.email.Exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Karol Golec
 * Date: 11.11.2016
 * Time: 20:43
 */
public class SendEmailException extends Exception {

    /**
     * Constructor
     */
    public SendEmailException() {

    }

    /**
     * Constructor
     * @param message message exception
     */
    public SendEmailException(String message) {
        super (message);
    }

    /**
     * Constructor
     * @param cause cause exception
     */
    public SendEmailException(Throwable cause) {
        super (cause);
    }

    /**
     * Constructor
     * @param message message exception
     * @param cause cause exception
     */
    public SendEmailException(String message, Throwable cause) {
        super (message, cause);
    }
}