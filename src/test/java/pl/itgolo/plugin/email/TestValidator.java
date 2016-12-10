package pl.itgolo.plugin.email;

import org.junit.Test;
import pl.itgolo.plugin.email.Exceptions.*;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by ITGolo on 10.12.2016.
 */
public class TestValidator {

    @Test(expected = InternetConnectionException.class)
    public void test_not_connected_internet() throws InternetConnectionException, UnknownHostException {
        Validator validator = new Validator();
        validator.isInternet("http://noexistsite_google.pl");
    }

    @Test
    public void test_connection_internet() throws InternetConnectionException, UnknownHostException {
        Validator validator = new Validator();
        validator.isInternet("http://google.pl");
    }

    @Test
    public void test_connection_smtp() throws IOException, PropertyException, SmtpEmailException {
        Validator validator = new Validator();
        validator.isSmtp(Env.getProperty("SMTP_HOST"));
    }


    @Test(expected = SmtpEmailException.class)
    public void test_connection_incorrect_smtp() throws SmtpEmailException {
        Validator validator = new Validator();
        validator.isSmtp("no_exist_smtp.net");
    }

    @Test(expected = IncorrectEmailException.class)
    public void test_no_exist_email() throws EmptyEmailException, IncorrectEmailException, NullEmailException {
        Validator validator = new Validator();
        validator.isEmail("email@no_exist_domain");
    }

    @Test
    public void test_exist_email() throws PropertyException, EmptyEmailException, IncorrectEmailException, NullEmailException {
        Validator validator = new Validator();
        validator.isEmail(Env.getProperty("EMAIL"));
    }

    @Test(expected = NullArgumentException.class)
    public void test_validate_null_receiver() throws NullArgumentException {
        Validator validator = new Validator();
        validator.isArgument(null, "receiver");
    }

    @Test
    public void test_validate_receiver() throws PropertyException, NullArgumentException {
        Validator validator = new Validator();
        validator.isArgument(Env.getProperty("EMAIL"), "receiver");
    }

}
