package gym.backend.controller;

import gym.backend.models.DTO.HomePageResponseDataDTO;
import gym.backend.models.DTO.SingleProductDataDTO;
import gym.backend.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "${my.url}")
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping
    public ResponseEntity<HomePageResponseDataDTO> getAllSellableProducts() {
        return ResponseEntity.ok(productsService.getFrontPageData());
    }

    @GetMapping("/product")
    public ResponseEntity<SingleProductDataDTO> getCurrentProduct(@RequestParam String modelId) {
        return new ResponseEntity<>(productsService.getSingleProduct(modelId), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/product")
    public ResponseEntity<String> checkIfProductIsAvailable(@RequestParam String brandId, @RequestParam String modelId, @RequestParam String tasteId) {
        boolean isProductAvailable = productsService.checkIfProductIsAvailable(brandId, modelId, tasteId);

        if (isProductAvailable) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
