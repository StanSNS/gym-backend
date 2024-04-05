package gym.backend.service;

import gym.backend.models.DTO.TasteDTO;
import gym.backend.repository.TasteEntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AdminService {


    private final TasteEntityRepository tasteEntityRepository;
    private final ModelMapper modelMapper;

    public List<TasteDTO> getAllTastes() {
        return tasteEntityRepository.findAll().stream().map(tasteEntity -> modelMapper.map(tasteEntity, TasteDTO.class)).collect(Collectors.toList());
    }

}
