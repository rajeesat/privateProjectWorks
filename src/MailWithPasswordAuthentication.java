import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.util.Properties;

public class MailWithPasswordAuthentication {
    public static void main(String[] args) throws MessagingException {
        new MailWithPasswordAuthentication().run();
    }

    private void run() throws MessagingException {
        Message message = new MimeMessage(getSession());

        message.addRecipient(RecipientType.TO, new InternetAddress("m.j.mohamedrifkhan@gmail.com"));
        message.addFrom(new InternetAddress[] { new InternetAddress("srajeenthini@gmail.com") });

        message.setSubject("the subject");
        message.setContent("the body", "text/plain");

        Transport.send(message);
    }

    private Session getSession() {
        Authenticator authenticator = new Authenticator();

//        Properties properties = new Properties();
//        properties.setProperty("mail.smtp.submitter", authenticator.getPasswordAuthentication().getUserName());
//        properties.setProperty("mail.smtp.auth", "true");
//
//        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
//        properties.setProperty("mail.smtp.port", "25");


        Properties props = new Properties ();
        props.setProperty ("mail.transport.protocol", "smtp");
        props.setProperty ("mail.host", "smtp.gmail.com");
        props.setProperty ("mail.user", "srajeenthini@gmail.com");
        props.setProperty ("mail.password", "9sanja90");

        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");

        return Session.getInstance(props, authenticator);
    }

    private class Authenticator extends javax.mail.Authenticator {
        private PasswordAuthentication authentication;

        public Authenticator() {
            String username = "srajeenthini@gmail.com";
            String password = "9sanja90";
            authentication = new PasswordAuthentication(username, password);
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return authentication;
        }
    }
}
