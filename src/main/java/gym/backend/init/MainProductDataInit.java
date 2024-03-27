package gym.backend.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainProductDataInit {

    private final ProductDataByBrandID tasteAndSizeInit;
    private final BrandInit brandInit;

    @PostConstruct
    public void dataInit() {

        brandInit.saveBrands();

        tasteAndSizeInit.saveProductDataByBrandID();


    }


}





