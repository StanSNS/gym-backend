package gym.backend.init;

import gym.backend.init.DeliverySpeedy.FillSpeedyOffices;
import gym.backend.init.Products.*;
import gym.backend.models.entity.AdminEntity;
import gym.backend.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final AdminEntityRepository adminEntityRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${admin.auth.login.username}")
    private String ADMIN_AUTH_LOGIN_USERNAME;

    @Value("${admin.auth.login.password}")
    private String ADMIN_AUTH_LOGIN_PASSWORD;

    @PostConstruct
    public void dataInit() throws IOException {
        boolean isDBHasData = brandEntityRepository.count() == 0
                && productEntityRepository.count() == 0
                && tasteEntityRepository.count() == 0
                && citySpeedyEntityRepository.count() == 0;

        if (isDBHasData) {
            System.out.println("Start adding fresh data...");

            tasteColorsInit.startInit();

            simpleDataInit.startInit();

            productDataInit.startInit();

            productDetailsDataInit.startInit();

            productDataFromSheetInit.startInit();

            fillSpeedyOffices.startInit();

            productDataFromWebSite.startInit();

            System.out.println("Operation completed.");
        }

        if (adminEntityRepository.count() == 0) {
            AdminEntity adminEntity = new AdminEntity();
            adminEntity.setUsername(ADMIN_AUTH_LOGIN_USERNAME);
            adminEntity.setPassword(passwordEncoder.encode(ADMIN_AUTH_LOGIN_PASSWORD));
            adminEntity.setJwtToken(null);

            adminEntityRepository.save(adminEntity);
            System.out.println("Admin has been created");
        }

    }
}





