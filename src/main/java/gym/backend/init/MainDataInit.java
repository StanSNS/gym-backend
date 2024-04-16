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

    private final SimpleDataInit simpleDataInit;
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
            System.out.println("DB is empty - start initialization.");

            tasteColorsInit.startInit();

            simpleDataInit.startInit();

            productDataInit.simpleProductInit();

            productDetailsDataInit.detailsProductInit();

            productDataFromSheetInit.startInit();

            productDataFromWebSite.addEnemyPricesAndRating();

            fillSpeedyOffices.fillAddressesAndTowns();

            System.out.println("Initialization has completed successfully.");
        } else {
            System.out.println("Skipping initialization - DB is already full.");
            System.out.println("Total Brand entities: " + brandEntityRepository.count());
            System.out.println("Total Product entities: " + productEntityRepository.count());
            System.out.println("Total Taste entities: " + tasteEntityRepository.count());
            System.out.println("Total Speedy offices: " + citySpeedyEntityRepository.count());
        }

    }
}





