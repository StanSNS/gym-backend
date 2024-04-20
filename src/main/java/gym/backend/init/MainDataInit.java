package gym.backend.init;

import gym.backend.init.DeliverySpeedy.FillSpeedyOffices;
import gym.backend.init.Products.*;
import gym.backend.repository.BrandEntityRepository;
import gym.backend.repository.CitySpeedyEntityRepository;
import gym.backend.repository.ProductEntityRepository;
import gym.backend.repository.TasteEntityRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class MainDataInit {

    private final BrandAndTasteInit simpleDataInit;
    private final ProductDataInit productDataInit;
    private final ProductDetailsDataInit productDetailsDataInit;
    private final ProductDataFromSheetInit productDataFromSheetInit;
    private final ProductDataFromWebSite productDataFromWebSite;
    private final BrandEntityRepository brandEntityRepository;
    private final ProductEntityRepository productEntityRepository;
    private final TasteEntityRepository tasteEntityRepository;
    private final CitySpeedyEntityRepository citySpeedyEntityRepository;
    private final TasteColorsInit tasteColorsInit;
    private final FillSpeedyOffices fillSpeedyOffices;

    @PostConstruct
    public void dataInit() throws IOException {
        boolean isDBHasData = brandEntityRepository.count() == 0
                && productEntityRepository.count() == 0
                && tasteEntityRepository.count() == 0
                && citySpeedyEntityRepository.count() == 0;

        if (isDBHasData) {
            tasteColorsInit.startInit(); //DONE

            simpleDataInit.startInit(); //DONE

            productDataInit.startInit(); //DONE

            productDetailsDataInit.startInit(); //DONE

            productDataFromSheetInit.startInit(); //DONE

            fillSpeedyOffices.startInit(); //DONE

            productDataFromWebSite.startInit();
        }

    }
}





