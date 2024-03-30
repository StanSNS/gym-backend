package gym.backend.controller;

import gym.backend.models.DTO.HomePageResponseDataDTO;
import gym.backend.models.DTO.SellableProductDTO;
import gym.backend.models.entity.ProductEntity;
import gym.backend.repository.ProductEntityRepository;
import gym.backend.service.GenerateProductsInTXTService;
import gym.backend.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "${my.url}")
public class ProductsController {

private final ProductsService productsService;

    @GetMapping
    public ResponseEntity<HomePageResponseDataDTO> getAllSellableProducts() {
        return ResponseEntity.ok(productsService.getFrontPageData());
    }


}
