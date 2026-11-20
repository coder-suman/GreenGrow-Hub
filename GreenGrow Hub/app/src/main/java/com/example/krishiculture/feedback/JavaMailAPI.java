package com.example.krishiculture.feedback;

import android.os.AsyncTask;
import java.util.Properties;
import javax.mail.*;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailAPI extends AsyncTask<Void, Void, Boolean> {

    private final String emailSender = "manishgiri8101@gmail.com"; // Admin Email
    private final String emailPassword = "ojfn qfyi kkns stif"; // Use App Password
    private final String emailReceiver;
    private final String subject;
    private final String messageBody;

    public JavaMailAPI(String emailReceiver, String subject, String messageBody) {
        this.emailReceiver = emailReceiver;
        this.subject = subject;
        this.messageBody = messageBody;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailSender, emailPassword);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailSender));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailReceiver));
            message.setSubject(subject);
            message.setText(messageBody);

            Transport.send(message);
            return true;  // Email sent successfully
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;  // Email failed
        }
    }
}
