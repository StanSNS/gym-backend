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


    @PostConstruct
    public void dataInit() throws IOException, InvalidFormatException {

        simpleDataInit.startInit();

        productDataInit.simpleProductInit();

        productDetailsDataInit.detailsProductInit();

    }
}





