package gym.backend.controller;

import gym.backend.models.entity.ProductEntity;
import gym.backend.repository.ProductEntityRepository;
import gym.backend.service.GenerateProductsInTXTService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductsController {

    private final ProductEntityRepository productEntityRepository;
    private final GenerateProductsInTXTService generateProductsInTXTService;

    @GetMapping
    public ResponseEntity<StringBuilder> getAllSellableItemsAsPrint() {
        return ResponseEntity.ok(new StringBuilder(generateProductsInTXTService.generateProductsAsString()));
    }


}
