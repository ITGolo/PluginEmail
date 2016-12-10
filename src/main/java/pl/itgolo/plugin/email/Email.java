package pl.itgolo.plugin.email;

import pl.itgolo.plugin.email.Exceptions.*;

import javax.mail.*;
import java.util.Properties;

/**
 * Created by ITGolo on 09.12.2016.
 */
public class Email {

    /* @var debug */
    private Boolean debug = false;

    /* @var auth */
    private Boolean auth = true;

    /* @var start TLS */
    private Boolean startTls = true;

    /* @var validator */
    private Validator validator;

    /* @var from */
    private String from;

    /* @var receiver */
    private String receiver;

    /* @var userName */
    private String userName;

    /* @var password */
    private String password;

    /* @var host SMTP */
    private String host;

    /* @var port */
    private String port;

    /* @var subject */
    private String subject = "";

    /* @var text */
    private String text = "";

    /* @var html */
    private String html;

    /**
     * Constructor
     */
    public Email() {
        this.validator = new Validator();
    }

    /**
     * Set debug
     * @param debug debug
     */
    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

    /**
     * Set auth SMTP
     * @param auth auth SMTP
     */
    public void setAuth(Boolean auth) {
        this.auth = auth;
    }

    /**
     * Start TLS
     * @param startTls start TLS
     */
    public void setStartTls(Boolean startTls) {
        this.startTls = startTls;
    }

    /**
     * Set from
     * @param from from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Set receiver
     * @param receiver email receiver
     * @throws EmptyEmailException email receiver is empty
     * @throws NullEmailException email receiver is null
     * @throws IncorrectEmailException email is incorrect
     */
    public void setReceiver(String receiver) throws EmptyEmailException, NullEmailException, IncorrectEmailException {
        this.validator.isEmail(receiver);
        this.receiver = receiver;
    }

    /**
     * Set user name
     * @param userName user name to SMTP
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Set password
     * @param password password to SMTP
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Set host
     * @param host host SMTP
     *@throws SmtpEmailException failed connect to host SMTP
     */
    public void setHost(String host) throws SmtpEmailException {
        this.validator.isSmtp(host);
        this.host = host;
    }

    /**
     * Set port
     * @param port port
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * Set subject
     * @param subject subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Set text
     * @param text text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Set html
     * @param html html
     */
    public void setHtml(String html) {
        this.html = html;
    }

    /**
     * Send email
     *
     * @throws InternetConnectionException no connection with internet
     * @throws NullArgumentException argument is null
     * @throws SmtpEmailException no such provider SMTP
     * @throws IncorrectEmailException incorrect email from
     * @throws MessageException        failed set from in message
     */
    public void send() throws InternetConnectionException, NullArgumentException, SmtpEmailException, IncorrectEmailException, MessageException {
        this.validator.isInternet("http://google.pl");
        this.validator.isArgument(this.from, "From");
        this.validator.isArgument(this.receiver, "Receiver");
        this.validator.isArgument(this.userName, "UserName");
        this.validator.isArgument(this.password, "Password");
        this.validator.isArgument(this.host, "Host");
        this.validator.isArgument(this.port, "Port");
        this.validator.isArgument(this.subject, "Subject");
        this.validator.isArgument(this.text, "Text");
        this.validator.isArgument(this.debug, "Debug");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", this.auth.toString());
        properties.put("mail.smtp.starttls.enable", this.startTls.toString());
        properties.put("mail.smtp.host", this.host);
        properties.put("mail.smtp.port", this.port);
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });
        session.setDebug(this.debug);
        try {
            MessageCreator messageCreator = new MessageCreator(session, this.from, this.receiver, this.subject, this.text, this.html);
            Message message = messageCreator.getMessage();
            Transport.send(message, message.getAllRecipients());
        } catch (MessagingException e) {
            throw new SmtpEmailException(String.format("Failed transport message. Host: '%1$s', from: '%2$s', receiver: '%3$s', subject:'%4$s'", this.host, this.from, this.receiver, this.subject), e);
        }

    }
}
