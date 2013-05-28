package br.com.kwikemart.utils;

import static java.lang.Boolean.TRUE;
import static javax.mail.internet.InternetAddress.parse;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.caelum.vraptor.ioc.Component;
import br.com.kwikemart.properties.FileProperties;

@Component
public class SendMail {

    private final static String SMTP_AUTH_PROPERTY = "mail.smtp.auth";
    private final static String TLS_ENABLE_PROPERTY = "mail.smtp.starttls.enable";
    private final static String SMTP_HOST_PROPERTY = "mail.smtp.host";
    private final static String SMTP_PORT_PROPERTY = "mail.smtp.port";
    private static String CONTENT_TYPE = "text/html; charset=utf-8";
    private static FileProperties fileProperties = new FileProperties(FileProperties.Type.EMAIL);

    
	public boolean sendEmail(final String html, final String mailTO) {
        final String defaultSubject = fileProperties.getString("default.subject");
        return send(html, defaultSubject, mailTO);
    }

    public boolean send(final String html, final String subject, String mailTO) {
        boolean sucess = true;

		final String username = fileProperties.getString("username");
		final String password = fileProperties.getString("password");
		final String smtpAddress = fileProperties.getString("smtp.address");
		final String smtpPort = fileProperties.getString("smtp.port");
		final String tlsEnabled = fileProperties.getString("tls.enabled");

        Properties props = getProperties(smtpAddress, smtpPort, tlsEnabled);
        Session session = getSession(username, password, props);

        try {
            Message message = getMessage(html, subject, mailTO, username, session);
            Transport.send(message);

        } catch (Exception e) {
            sucess = false;
            throw new RuntimeException(e);
        }
        return sucess;
    }
    
    private static Message getMessage(
            final String html,
            final String subject,
            String mailTO,
            final String username,
            Session session) throws MessagingException, AddressException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, parse(mailTO));
        message.setSubject(subject);
        message.setContent(html, CONTENT_TYPE);
        return message;
    }

    private static Session getSession(final String username, final String password, Properties props) {
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        return session;
    }

    private static Properties getProperties(final String smtpAddress, final String smtpPort, final String tlsEnabled) {
        Properties props = new Properties();
        props.put(SMTP_AUTH_PROPERTY, TRUE);
        props.put(TLS_ENABLE_PROPERTY, tlsEnabled);
        props.put(SMTP_HOST_PROPERTY, smtpAddress);
        props.put(SMTP_PORT_PROPERTY, smtpPort);
        return props;
    }
}