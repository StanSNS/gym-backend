package gym.backend.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class MainProductDataInit {

    private final SimpleDataInit simpleDataInit;
    private final ProductDataInit productDataInit;
    private final ProductDetailsDataInit productDetailsDataInit;
    private final ProductDataFromSheetInit productDataFromSheetInit;
    private final ProductDataFromWebSite productDataFromWebSite;


    @PostConstruct
    public void dataInit() throws IOException {

        simpleDataInit.startInit();

        productDataInit.simpleProductInit();

        productDetailsDataInit.detailsProductInit();

        productDataFromSheetInit.startInit();

        productDataFromWebSite.addEnemyPrices();

        System.out.println("Initialization has completed without errors.");
    }
}





