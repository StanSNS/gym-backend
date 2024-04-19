package gym.backend.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class AppConfig {

    @Value("${email.host}")
    private String EMAIL_HOST;

    @Value("${email.port}")
    private Integer EMAIL_PORT;

    @Value("${email.origin}")
    private String EMAIL_ORIGIN;

    @Value("${email.password}")
    private String EMAIL_PASSWORD;

    @Value("${email.props.one.key}")
    private String EMAIL_PROPS_KEY_ONE;

    @Value("${email.props.one.value}")
    private String EMAIL_PROPS_VALUE_ONE;

    @Value("${email.props.two.key}")
    private String EMAIL_PROPS_KEY_TWO;

    @Value("${email.props.two.value}")
    private String EMAIL_PROPS_VALUE_TWO;

    @Value("${email.props.three.key}")
    private String EMAIL_PROPS_KEY_THREE;

    @Value("${email.props.three.value}")
    private String EMAIL_PROPS_VALUE_THREE;

    @Bean
    public Gson gson() {
        return new GsonBuilder().create();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(EMAIL_HOST);
        javaMailSender.setPort(EMAIL_PORT);
        javaMailSender.setUsername(EMAIL_ORIGIN);
        javaMailSender.setPassword(EMAIL_PASSWORD);
        Properties props = javaMailSender.getJavaMailProperties();
        props.put(EMAIL_PROPS_KEY_ONE, EMAIL_PROPS_VALUE_ONE);
        props.put(EMAIL_PROPS_KEY_TWO, EMAIL_PROPS_VALUE_TWO);
        props.put(EMAIL_PROPS_KEY_THREE, EMAIL_PROPS_VALUE_THREE);
        return javaMailSender;
    }
}
