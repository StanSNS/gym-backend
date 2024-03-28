package gym.backend.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    @Bean
    public Gson gson() {
        return new GsonBuilder().create();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
