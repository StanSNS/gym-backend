package gym.backend.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import static gym.backend.consts.EmailConst.*;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    @Value("${email.origin}")
    private String EMAIL_ORIGIN;

    public void sendTest() throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(EMAIL_ORIGIN);
        helper.setTo("stanimirsergevsns@gmail.com");
        helper.setSubject("Thats a test");
        helper.setText(TEST_TEMPLATE_HEAD + TEST_TEMPLATE_BODY, true);
        javaMailSender.send(message);
    }
}
