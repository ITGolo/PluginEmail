package pl.itgolo.plugin.email;

import pl.itgolo.plugin.email.Exceptions.*;
import pl.itgolo.plugin.email.Services.Extractor;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Hashtable;
import java.util.Objects;

/**
 * Created by ITGolo on 09.12.2016.
 */
public class Validator {

    /* email pattern */
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Validate email
     *
     * @param email email
     * @throws EmptyEmailException     email is empty
     * @throws NullEmailException      email is null
     * @throws IncorrectEmailException email is incorrect or not found exist domain for email
     */
    public void isEmail(String email) throws NullEmailException, EmptyEmailException, IncorrectEmailException {
        if (Objects.isNull(email)) {
            throw new NullEmailException("Email receiver is null");
        } else if (email.isEmpty()) {
            throw new EmptyEmailException("Email receiver is empty.");
        } else if (email.matches(EMAIL_PATTERN) == false) {
            throw new IncorrectEmailException("Email is incorrect.");
        } else {
            String domainFromEmail = Extractor.getDomain(email);
            try {
                isDomain(domainFromEmail);
            } catch (IncorrectDomainException e) {
                throw new IncorrectEmailException(String.format("Not fount domain: '%1$s' for email: '%2$s'", domainFromEmail, email));
            }
        }
    }

    /**
     * Validate internet
     *
     * @param testSite test site
     * @throws InternetConnectionException no connection with internet
     */
    public void isInternet(String testSite) throws InternetConnectionException {
        Socket socket = new Socket();
        try {
            InetSocketAddress address = new InetSocketAddress(new URL(testSite).getHost(), 80);
            socket.connect(address, 3000);
        } catch (IOException e) {
            throw new InternetConnectionException(String.format("No connection with internet. Attempted connection with %1$s.", testSite), e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                // exception for close socket is not require
            }
        }
    }

    /**
     * Validate smtp
     *
     * @param host host smtp
     * @throws SmtpEmailException failed connect to host SMTP
     */
    public void isSmtp(String host) throws SmtpEmailException {
        try {
            isDomain(host);
        } catch (IncorrectDomainException e) {
            throw new SmtpEmailException(String.format("Failed connect to host SMTP: %1$s.", host), e);
        }
    }

    /**
     * Validate argument
     *
     * @param argument
     * @param nameArgument name argument for exception
     * @throws NullArgumentException argument is null
     */
    public void isArgument(Object argument, String nameArgument) throws NullArgumentException {
        if (Objects.isNull(argument)) {
            throw new NullArgumentException(String.format("Argument '%1$s' is null.", nameArgument));
        }
    }

    /**
     * Validate is exist domain
     * @param domain domain
     * @throws IncorrectDomainException not found exist domain
     */
    public void isDomain(String domain) throws IncorrectDomainException {
        try {
            Hashtable env = new Hashtable();
            env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
            DirContext initialDirContext = new InitialDirContext(env);
            Attributes attributes = initialDirContext.getAttributes(domain, new String[]{"MX"});
            Attribute attribute = attributes.get("MX");
            if ((attribute == null) || (attribute.size() == 0)) {
                attributes = initialDirContext.getAttributes(domain, new String[]{"A"});
                attribute = attributes.get("A");
                if (attribute == null)
                    throw new IncorrectDomainException(String.format("Not found exist domain '%1$s'.", domain));
            }
        } catch (NamingException e) {
            throw new IncorrectDomainException(String.format("Not found exist domain '%1$s'.", domain), e);
        }
    }
}
