package utilities;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class ResetAccount {
	public ResetAccount()
	{
		
	}
	public static String generateOTP() {
        Random random = new Random();
        int part1 = 100 + random.nextInt(900); // 3 chữ số đầu
        int part2 = 100 + random.nextInt(900); // 3 chữ số sau
        return String.format("%03d-%03d", part1, part2);
    }

	public static boolean sendEmail(String recipient, String otp) {
        final String EMAIL_USERNAME = System.getenv("EMAIL_USERNAME"); 
        final String EMAIL_PASSWORD = System.getenv("EMAIL_PASSWORD");

        String subject = "Xác nhận OTP";
        String body = "Mã OTP của bạn là: " + otp + "\nThời gian tồn tại của mã là 5 phút";

        // Email server configuration
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Create session with authentication
        Session session = Session.getInstance(properties, new jakarta.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
            }
        });

        try {
            // Create email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);

            // Send email
            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
