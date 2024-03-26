package gym.backend.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainProductDataInit {

    private final TasteAndSizeInit tasteInit;
    private final BrandInit brandInit;

    @PostConstruct
    public void dataInit() {

        brandInit.saveBrands();

        tasteInit.saveBothData();


    }


}





