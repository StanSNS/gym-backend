package gym.backend.init;

import gym.backend.models.entity.AboutDataEntity;
import gym.backend.repository.AboutDataEntityRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AboutDataInit {

    private final AboutDataEntityRepository aboutDataEntityRepository;

    @PostConstruct
    public void initBasicAboutData() {
        if (aboutDataEntityRepository.count() == 0) {
            AboutDataEntity aboutDataEntity = new AboutDataEntity();
            aboutDataEntity.setSoldProducts(0);
            aboutDataEntity.setDeliveredProducts(0);
            aboutDataEntity.setSatisfiedClients(0);
            aboutDataEntity.setSavedMoney(0.00);

            aboutDataEntityRepository.save(aboutDataEntity);
        }

    }
}
