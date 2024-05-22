package gym.backend.controller.Admin;

import gym.backend.init.DeliverySpeedy.FillSpeedyOffices;
import gym.backend.init.Products.*;
import gym.backend.models.DTO.Admin.Auth.LoginDTO;
import gym.backend.models.DTO.Admin.Order.AdminOrderDTO;
import gym.backend.service.AdminService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "${my.url}")
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final TasteColorsInit tasteColorsInit;
    private final BrandAndTasteInit simpleDataInit;
    private final ProductDataInit productDataInit;
    private final ProductDetailsDataInit productDetailsDataInit;
    private final ProductDataFromSheetInit productDataFromSheetInit;
    private final ProductDataFromWebSite productDataFromWebSite;
    private final FillSpeedyOffices fillSpeedyOffices;

    @PostMapping("/auth/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDTO loginDTO){
        boolean isUserAuthenticated = adminService.authenticateUser(loginDTO);

        if(isUserAuthenticated){
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping
    public ResponseEntity<List<AdminOrderDTO>> getAllAdminData() {
        return new ResponseEntity<>(adminService.getAllOrdersForAdminPage(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> modifyOrderStatus(@RequestParam String status, @RequestParam Long randomNumber) throws MessagingException {
        adminService.modifyOrderStatus(status, randomNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("taste-color-execute")
    public ResponseEntity<String> tasteColorExecute() throws IOException {
        tasteColorsInit.startInit();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("brand-taste-data-execute")
    public ResponseEntity<String> brandTasteExecute() {
        simpleDataInit.startInit();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("product-data-execute")
    public ResponseEntity<String> productDataExecute() {
        productDataInit.startInit();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("product-data-details-execute")
    public ResponseEntity<String> productDataDetailsExecute() {
        productDetailsDataInit.startInit();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("product-data-details-sheet-execute")
    public ResponseEntity<String> productDataDetailsSheetExecute() throws IOException {
        productDataFromSheetInit.startInit();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("product-data-details-web-execute")
    public ResponseEntity<String> productDataDetailsWebExecute() {
        productDataFromWebSite.startInit();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("speedy-offices-execute")
    public ResponseEntity<String> speedyOfficesDataExecute() {
        fillSpeedyOffices.startInit();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("all-execute")
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
