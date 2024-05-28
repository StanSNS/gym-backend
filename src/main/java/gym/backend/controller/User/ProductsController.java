package gym.backend.controller.User;

import gym.backend.models.DTO.HomePageResponseDataDTO;
import gym.backend.models.DTO.SingleProductDataDTO;
import gym.backend.service.ProductsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static gym.backend.consts.Urls.UserControllerUrlPaths.HOME;
import static gym.backend.consts.Urls.UserControllerUrlPaths.PRODUCT;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "${user.frontend.base.url}")
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping(HOME)
    public ResponseEntity<HomePageResponseDataDTO> getAllSellableProducts() {
        return ResponseEntity.ok(productsService.getFrontPageData());
    }

    @GetMapping(PRODUCT)
    public ResponseEntity<SingleProductDataDTO> getCurrentProduct(@RequestParam String modelId) {
        return new ResponseEntity<>(productsService.getSingleProduct(modelId), HttpStatus.ACCEPTED);
    }

    @PatchMapping(PRODUCT)
    @Valid
    public ResponseEntity<String> checkIfProductIsAvailable(@NotBlank @RequestParam String brandId,
                                                            @NotBlank @RequestParam String modelId,
                                                            @NotBlank @RequestParam String tasteId) {
        if (productsService.checkIfProductIsAvailable(brandId, modelId, tasteId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
