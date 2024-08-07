package gym.backend.controller.Admin;

import gym.backend.init.DeliverySpeedy.FillSpeedyOffices;
import gym.backend.init.Products.*;
import gym.backend.models.DTO.AboutDataDto;
import gym.backend.models.DTO.Admin.Auth.JwtAuthResponseDTO;
import gym.backend.models.DTO.Admin.Auth.LoginDTO;
import gym.backend.models.DTO.Admin.Order.AdminOrderDTO;
import gym.backend.models.DTO.Admin.Order.CreateOrderInSpeedyDTO;
import gym.backend.models.DTO.Admin.Order.CreateOrderSpeedyApiReqDTO;
import gym.backend.models.DTO.Admin.Product.CheckProductAvailableDTO;
import gym.backend.service.AboutDataService;
import gym.backend.service.AdminService;
import gym.backend.service.ProductsService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static gym.backend.consts.Urls.AdminControllerUrlPaths.*;
import static gym.backend.consts.Urls.UserControllerUrlPaths.ABOUT_DATA;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "${admin.frontend.base.url}")
@RequestMapping
public class AdminController {

    private final AdminService adminService;
    private final TasteColorsInit tasteColorsInit;
    private final BrandAndTasteInit simpleDataInit;
    private final ProductDataInit productDataInit;
    private final ProductDetailsDataInit productDetailsDataInit;
    private final ProductDataFromSheetInit productDataFromSheetInit;
    private final ProductDataFromWebSite productDataFromWebSite;
    private final FillSpeedyOffices fillSpeedyOffices;
    private final AboutDataService aboutDataService;

    @GetMapping(BASE_ADMIN + ABOUT_DATA)
    public ResponseEntity<AboutDataDto> getAllAboutData() {
        return new ResponseEntity<>(aboutDataService.getAboutData(), HttpStatus.OK);
    }

    @PutMapping(BASE_ADMIN + ABOUT_DATA)
    public ResponseEntity<String> changeAboutData(@RequestBody AboutDataDto aboutDataDto) {
        aboutDataService.modifyAboutData(aboutDataDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(BASE_ADMIN + MODIFY_IS_USER_CALLED)
    public ResponseEntity<String> modifyIsUserCalled(@RequestParam Long randomNumber, Boolean isUserCalled) {
        adminService.changeIsUserLogged(randomNumber, isUserCalled);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(BASE_ADMIN + VALIDATE_ALL_PRODUCTS_AVAILABILITY)
    public ResponseEntity<List<String>> validateAllProductsAvailability(@RequestBody List<CheckProductAvailableDTO> checkProductAvailableDTOList) {
        List<String> stringsResponse = adminService.checkIfProductsAreAvailable(checkProductAvailableDTOList);
        if (stringsResponse.get(0).equals("All passed")) {
            return new ResponseEntity<>(stringsResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(stringsResponse, HttpStatus.ACCEPTED);
    }

    @PostMapping(AUTH_LOGIN)
    public ResponseEntity<JwtAuthResponseDTO> authenticateUser(@RequestBody LoginDTO loginDTO) {
        return new ResponseEntity<>(adminService.login(loginDTO), HttpStatus.OK);
    }

    @PostMapping(CREATE_ORDER_IN_SPEEDY)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CreateOrderSpeedyApiReqDTO> createOrderInSpeedy(@RequestBody CreateOrderInSpeedyDTO createOrderInSpeedyDTO) throws MessagingException {
        adminService.createSpeedyOrderAPI(createOrderInSpeedyDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(BASE_ADMIN)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<AdminOrderDTO>> getAllAdminData() {
        return new ResponseEntity<>(adminService.getAllOrdersForAdminPage(), HttpStatus.OK);
    }

    @PutMapping(BASE_ADMIN)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> modifyOrderStatus(@RequestParam String status, @RequestParam Long randomNumber) throws MessagingException {
        adminService.modifyOrderStatus(status, randomNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(TASTE_COLOR_EXECUTE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> tasteColorExecute() throws IOException {
        tasteColorsInit.startInit();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(TASTE_DATA_EXECUTE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> brandTasteExecute() {
        simpleDataInit.startInit();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(PRODUCT_DATA_EXECUTE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> productDataExecute() {
        productDataInit.startInit();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(PRODUCT_DATA_DETAILS_EXECUTE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> productDataDetailsExecute() {
        productDetailsDataInit.startInit();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(PRODUCT_DATA_DETAILS_SHEET_EXECUTE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> productDataDetailsSheetExecute() throws IOException {
        productDataFromSheetInit.startInit();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(PRODUCT_DATA_DETAILS_WEB_EXECUTE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> productDataDetailsWebExecute() {
        productDataFromWebSite.startInit();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(SPEEDY_OFFICES_EXECUTE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> speedyOfficesDataExecute() {
        fillSpeedyOffices.startInit();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(ALL_EXECUTE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> allExecute() throws IOException {
        tasteColorsInit.startInit();
        simpleDataInit.startInit();
        productDataInit.startInit();
        productDetailsDataInit.startInit();
        productDataFromSheetInit.startInit();
        productDataFromWebSite.startInit();
        fillSpeedyOffices.startInit();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
