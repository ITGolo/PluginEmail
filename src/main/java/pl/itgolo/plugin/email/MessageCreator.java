package pl.itgolo.plugin.email;

import pl.itgolo.plugin.email.Exceptions.IncorrectEmailException;
import pl.itgolo.plugin.email.Exceptions.MessageException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by ITGolo on 10.12.2016.
 */
public class MessageCreator {

    /* @var message */
    private Message message;

    /* @var session */
    private Session session;

    /* @var from */
    private String from;

    /* @var receiver */
    private String receiver;

    /* @var subject */
    private String subject;

    /* @var text */
    private String text;

    /* @var html */
    private String html;

    /**
     * Constructor
     *
     * @param session  session
     * @param from     from
     * @param receiver receiver
     * @param subject subject
     * @param text text
     * @param html html
     */
    public MessageCreator(Session session, String from, String receiver, String subject, String text, String html) {
        this.session = session;
        this.from = from;
        this.receiver = receiver;
        this.subject = subject;
        this.text = text;
        this.html = html;
    }

    /**
     * Get message
     *
     * @return text message
     * @throws IncorrectEmailException incorrect email from
     * @throws MessageException        failed set from in message
     */
    public Message getMessage() throws IncorrectEmailException, MessageException {
        this.message = new MimeMessage(this.session);
        try {
            this.message.setFrom(new InternetAddress(this.from));
            this.message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.receiver));
            this.message.setSubject(this.subject);
            this.message.setText(this.text);
            this.message.setSentDate(new Date(System.currentTimeMillis()));
            Multipart multipart = new MimeMultipart("alternative");
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(this.text, "text/plain");
            multipart.addBodyPart(textPart);
            if (Objects.nonNull(this.html)){
                MimeBodyPart htmlPart = new MimeBodyPart();
                htmlPart.setContent(this.html, "text/html");
                multipart.addBodyPart(htmlPart);
            }
            this.message.setContent(multipart);
        } catch (AddressException e) {
            throw new IncorrectEmailException(String.format("Incorrect email from: '%1$s'.", this.from), e);
        } catch (MessagingException e) {
            throw new MessageException(String.format("Failed set from '%1$s' in message.", this.from), e);
        }
        return this.message;
    }
}
