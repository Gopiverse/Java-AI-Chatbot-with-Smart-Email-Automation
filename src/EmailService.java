import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class EmailService {

    public static void sendEmail(
            String senderEmail,
            String appPassword,
            String receiverEmail,
            String subject,
            String body) {

        try {

            // 1. SMTP configuration
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            // 2. Create session
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(senderEmail, appPassword);
                }
            });

            // 3. Create email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(receiverEmail)
            );

            message.setSubject(subject);
            message.setText(body);

            // 4. Send email
            Transport.send(message);

            System.out.println("\n Email sent successfully!");

        } catch (Exception e) {
            System.out.println("\n Failed to send email: " + e.getMessage());
        }
    }
}