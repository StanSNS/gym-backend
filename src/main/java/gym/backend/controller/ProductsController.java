package gym.backend.controller;

import gym.backend.models.entity.ProductEntity;
import gym.backend.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductsController {

    private final ProductEntityRepository productEntityRepository;

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllSellableItems() {
        return ResponseEntity.ok(productEntityRepository.findAllSellableProducts());
    }

}
