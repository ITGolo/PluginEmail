package pl.itgolo.plugin.email;

import org.junit.Test;
import pl.itgolo.plugin.email.Exceptions.*;

/**
 * Created by ITGolo on 09.12.2016.
 */
public class TestEmail {

    @Test
    public void test_set_receiver() throws EmptyEmailException, NullEmailException, IncorrectEmailException {
        Email email = new Email();
        email.setReceiver("email@email.com");
    }

    @Test(expected = EmptyEmailException.class)
    public void test_validate_set_email() throws EmptyEmailException, NullEmailException, IncorrectEmailException {
        Email email = new Email();
        email.setReceiver("");
    }

    @Test(expected = NullEmailException.class)
    public void test_validate_null() throws EmptyEmailException, NullEmailException, IncorrectEmailException {
        Email email = new Email();
        email.setReceiver(null);
    }

    @Test(expected = IncorrectEmailException.class)
    public void test_validate_email() throws EmptyEmailException, NullEmailException, IncorrectEmailException {
        Email email = new Email();
        email.setReceiver("email#email.com");
    }

    @Test
    public void test_validate_correct_email() throws EmptyEmailException, NullEmailException, IncorrectEmailException {
        Email email = new Email();
        email.setReceiver("email@email.com");
    }

    @Test(expected = NullArgumentException.class)
    public void test_send_email_null_receiver() throws InternetConnectionException, PropertyException, NullArgumentException, SmtpEmailException, IncorrectEmailException, MessageException {
        Email email = new Email();
        email.send();
    }

    @Test
    public void test_send_email() throws PropertyException, EmptyEmailException, IncorrectEmailException, NullEmailException, InternetConnectionException, NullArgumentException, SmtpEmailException, MessageException {
        Email email = new Email();
        email.setReceiver(Env.getProperty("EMAIL"));
        email.setUserName(Env.getProperty("SMTP_USERNAME"));
        email.setPassword(Env.getProperty("SMTP_PASSWORD"));
        email.setHost(Env.getProperty("SMTP_HOST"));
        email.setFrom(Env.getProperty("EMAIL"));
        email.setPort("465");
        email.setDebug(true);
        email.setSubject("Subject ąćńśł");
        email.setText("Text ąćńśł");
        email.send();
    }

    @Test
    public void test_send_email_html() throws PropertyException, EmptyEmailException, IncorrectEmailException, NullEmailException, InternetConnectionException, NullArgumentException, SmtpEmailException, MessageException {
        Email email = new Email();
        email.setReceiver(Env.getProperty("EMAIL"));
        email.setUserName(Env.getProperty("SMTP_USERNAME"));
        email.setPassword(Env.getProperty("SMTP_PASSWORD"));
        email.setHost(Env.getProperty("SMTP_HOST"));
        email.setFrom(Env.getProperty("EMAIL"));
        email.setPort(Env.getProperty("SMTP_PORT"));
        email.setDebug(true);
        email.setHtml("<html><head></head><body><strong>Message</strong> html</body></html>");
        email.setSubject("Subject ąćńśł");
        email.setText("Message html");
        email.send();
    }

    @Test(expected = SmtpEmailException.class)
    public void test_incorrect_authorization_email() throws PropertyException, EmptyEmailException, IncorrectEmailException, NullEmailException, InternetConnectionException, NullArgumentException, SmtpEmailException, MessageException {
        Email email = new Email();
        email.setReceiver(Env.getProperty("EMAIL"));
        email.setUserName("incorrect_username");
        email.setPassword(Env.getProperty("SMTP_PASSWORD"));
        email.setHost(Env.getProperty("SMTP_HOST"));
        email.setFrom(Env.getProperty("EMAIL"));
        email.setPort(Env.getProperty("SMTP_PORT"));
        email.setDebug(true);
        email.send();
    }
}
