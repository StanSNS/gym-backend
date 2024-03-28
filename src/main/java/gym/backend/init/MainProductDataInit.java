package gym.backend.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class MainProductDataInit {

    private final SimpleDataInit simpleDataInit;
    private final ProductDataInit productDataInit;
    private final ProductDetailsDataInit productDetailsDataInit;
    private final ProductDataFromSheetInit productDataFromSheetInit;


    @PostConstruct
    public void dataInit() throws IOException, InvalidFormatException {

        simpleDataInit.startInit();

        productDataInit.simpleProductInit();

        productDetailsDataInit.detailsProductInit();

        productDataFromSheetInit.startInit();

        System.out.println("Initialization has completed without errors.");
    }
}





