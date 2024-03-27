package gym.backend.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class MainProductDataInit {

    private final ProductDataByBrandID tasteAndSizeInit;
    private final BrandInit brandInit;
    private final ProductDataFromSheet productDataRegularPrice;

    @PostConstruct
    public void dataInit() throws IOException {

        brandInit.saveBrands();

        tasteAndSizeInit.saveProductDataByBrandID();

        productDataRegularPrice.checkIfProductIsPresent();
        productDataRegularPrice.modifyExistingProducts();

        System.out.println("Initialization has completed successfully!");
    }


}





