package gym.backend.controller.User;

import gym.backend.init.Products.ProductDataFromSheetInit;
import gym.backend.init.initService.RequestService;
import gym.backend.models.DTO.AboutDataDto;
import gym.backend.service.AboutDataService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static gym.backend.consts.Urls.UserControllerUrlPaths.ABOUT_DATA;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "${user.frontend.base.url}")
@RequestMapping
public class AboutDataController {

    private final AboutDataService aboutDataService;
    private final ProductDataFromSheetInit productDataFromSheetInit;
    private final RequestService requestService;

    @GetMapping(ABOUT_DATA)
    public ResponseEntity<AboutDataDto> getAllAboutData() {
        return new ResponseEntity<>(aboutDataService.getAboutData(), HttpStatus.OK);
    }

    @GetMapping("test")
    public ResponseEntity<String> test() throws IOException {
        XSSFSheet sheet = requestService.getDistroSheet();
        if (sheet == null) {
            return new ResponseEntity<>("Sheet is empty", HttpStatus.OK);
        }

        XSSFRow row = sheet.getRow(sheet.getFirstRowNum() + 1);
        if (row == null) {
            return new ResponseEntity<>("Row is empty", HttpStatus.OK);
        }

        return new ResponseEntity<>("All passed ?", HttpStatus.OK);
    }
}
