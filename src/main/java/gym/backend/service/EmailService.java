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
        StringBuilder stringBuilder = new StringBuilder();


        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(EMAIL_ORIGIN);
        helper.setTo("stanimirsergev159@gmail.com");
        helper.setSubject("Thats a test");


        helper.setText(stringBuilder
                .append(RECEIVE_ORDER_HTML_START)
                .append(RECEIVE_ORDER_HTML_IMAGE)
                .append(RECEIVE_ORDER_HTML_INTRO)
                .append(RECEIVE_ORDER_HTML_DIVIDER)
                .append(RECEIVE_ORDER_HTML_RANDOM_ORDER_NUMBER)
                .append(RECEIVE_ORDER_HTML_SPACER)
                .append(RECEIVE_ORDER_HTML_ALL_INFO)
                .append(RECEIVE_ORDER_HTML_SPACER)
                .append(RECEIVE_ORDER_HTML_PRODUCT)
                .append(RECEIVE_ORDER_HTML_DIVIDER)
                .append(RECEIVE_ORDER_HTML_DISCLAIMER_INFO)
                .append(RECEIVE_ORDER_HTML_SPACER)
                .append(RECEIVE_ORDER_HTML_FOOTER)
                .append(RECEIVE_ORDER_HTML_END).toString(), true);
        javaMailSender.send(message);
    }
}
