package gym.backend.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class MainProductDataInit {

    private final ProductDataByBrandID tasteAndSizeInit;
    private final BrandInit brandInit;
    private final ProductDataFromSheet productDataRegularPrice;
    private final ProductDataFromWebSite productDataFromWebSite;

    @PostConstruct
    public void dataInit() throws IOException, InvalidFormatException {

        brandInit.saveBrands();

        tasteAndSizeInit.saveProductDataByBrandID();

        productDataRegularPrice.checkIfProductIsPresent();
        productDataRegularPrice.modifyExistingProducts();

        productDataFromWebSite.addEnemyPrices();

        System.out.println("Initialization has completed successfully!");
    }


}





