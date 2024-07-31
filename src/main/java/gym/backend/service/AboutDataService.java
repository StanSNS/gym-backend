package gym.backend.service;

import gym.backend.exception.ResourceNotFoundException;
import gym.backend.models.DTO.AboutDataDto;
import gym.backend.models.entity.AboutDataEntity;
import gym.backend.repository.AboutDataEntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AboutDataService {

    private final AboutDataEntityRepository aboutDataEntityRepository;
    private final ModelMapper modelMapper;

    public AboutDataDto getAboutData() {
        Optional<AboutDataEntity> firstByOrderByIdAsc = aboutDataEntityRepository.findFirstByOrderByIdAsc();
        if (firstByOrderByIdAsc.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return modelMapper.map(firstByOrderByIdAsc.get(), AboutDataDto.class);
    }

    public void modifyAboutData(AboutDataDto aboutDataDto) {
        Optional<AboutDataEntity> firstByOrderByIdAsc = aboutDataEntityRepository.findFirstByOrderByIdAsc();
        if (firstByOrderByIdAsc.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        AboutDataEntity aboutDataEntity = firstByOrderByIdAsc.get();
        aboutDataEntity.setDeliveredProducts(aboutDataDto.getDeliveredProducts());
        aboutDataEntity.setSavedMoney(aboutDataDto.getSavedMoney());
        aboutDataEntity.setSoldProducts(aboutDataDto.getSoldProducts());
        aboutDataEntity.setSatisfiedClients(aboutDataDto.getSatisfiedClients());
        aboutDataEntityRepository.save(aboutDataEntity);
    }
}
