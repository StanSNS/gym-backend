package gym.backend.init;

import gym.backend.repository.BrandEntityRepository;
import gym.backend.repository.ProductEntityRepository;
import gym.backend.repository.SizeEntityRepository;
import gym.backend.repository.TasteEntityRepository;
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
    private final BrandEntityRepository brandEntityRepository;
    private final ProductEntityRepository productEntityRepository;
    private final SizeEntityRepository sizeEntityRepository;
    private final TasteEntityRepository tasteEntityRepository;

    @PostConstruct
    public void dataInit() throws IOException {

        boolean isDBHasData = brandEntityRepository.count() == 0
                && productEntityRepository.count() == 0
                & sizeEntityRepository.count() == 0
                && tasteEntityRepository.count() == 0;

        if (isDBHasData) {
            System.out.println("DB is empty - start initialization.");

            simpleDataInit.startInit();

            productDataInit.simpleProductInit();

            productDetailsDataInit.detailsProductInit();

            productDataFromSheetInit.startInit();

            productDataFromWebSite.addEnemyPricesAndRating();

            System.out.println("Initialization has completed successfully.");
        } else {
            System.out.println("Skipping initialization - DB is already full.");
            System.out.println("Total Brand entities: " + brandEntityRepository.count());
            System.out.println("Total Product entities: " + productEntityRepository.count());
            System.out.println("Total Size entities: " + sizeEntityRepository.count());
            System.out.println("Total Taste entities: " + tasteEntityRepository.count());
        }

    }
}





