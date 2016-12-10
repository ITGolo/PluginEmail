package pl.itgolo.plugin.email.Exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Karol Golec
 * Date: 11.11.2016
 * Time: 20:43
 */
public class SmtpEmailException extends Exception {

    /**
     * Constructor
     */
    public SmtpEmailException() {

    }

    /**
     * Constructor
     * @param message message exception
     */
    public SmtpEmailException(String message) {
        super (message);
    }

    /**
     * Constructor
     * @param cause cause exception
     */
    public SmtpEmailException(Throwable cause) {
        super (cause);
    }

    /**
     * Constructor
     * @param message message exception
     * @param cause cause exception
     */
    public SmtpEmailException(String message, Throwable cause) {
        super (message, cause);
    }
}