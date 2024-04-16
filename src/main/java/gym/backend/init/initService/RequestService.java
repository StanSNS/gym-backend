package gym.backend.init.initService;

import lombok.RequiredArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class RequestService {

    @Value("${sila.bg}")
    private String SILA_BG_API_TOKEN;

    @Value("${sila.bg.auth.email}")
    private String SILA_BG_AUTH_EMAIL;

    @Value("${sila.bg.auth.password}")
    private String SILA_BG_AUTH_PASSWORD;


    public ResponseEntity<String> getProductDataByBrandID(String brandID) {
        String productsURL = "https://distro.silabg.com/api/v1/brandfeed?api_token=" + SILA_BG_API_TOKEN;
        String jsonData = "{\"brand_id\": \"" + brandID + "\"}";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> requestEntity = new HttpEntity<>(jsonData, headers);

        return restTemplate.exchange(productsURL, HttpMethod.POST, requestEntity, String.class);
    }

    public ResponseEntity<String> getHTMLDocumentByModelID(String modelID) {
        String brandURL = "https://www.silabg.com/bg/detail/id/" + modelID;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(brandURL, HttpMethod.GET, requestEntity, String.class);
    }

    public XSSFSheet getDistroSheet() throws IOException {
        String url = "https://distro.silabg.com/bg/excel";

        HttpHeaders headers = new HttpHeaders();

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("smail", SILA_BG_AUTH_EMAIL);
        requestBody.add("spass", SILA_BG_AUTH_PASSWORD);
        requestBody.add("remember", "on");
        requestBody.add("_qf__loginForm", "");
        requestBody.add("submit", "");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.POST, entity, byte[].class);
        HttpStatusCode statusCode = response.getStatusCode();

        if (statusCode == HttpStatus.OK) {
            byte[] body = response.getBody();
            if (body != null) {
                InputStream inputStream = new ByteArrayInputStream(body);
                XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
                return workbook.getSheetAt(0);
            }
        } else {
            System.out.println("Failed to download file. Status code: " + statusCode);
        }
        return null;
    }

    public String getAllOfficesSpeedyBG() {
        String url = "https://api.speedy.bg/v1/location/office/";
        String requestBody = "{\n" +
                "    \"userName\": 1995900,\n" +
                "    \"password\": 6625235775,\n" +
                "    \"language\": \"BG\",\n" +
                "    \"countryId\": 100\n" +
                "}";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class).getBody();
    }

    public String getAllOfficesSpeedyEN() {
        String url = "https://api.speedy.bg/v1/location/office/";
        String requestBody = "{\n" +
                "    \"userName\": 1995900,\n" +
                "    \"password\": 6625235775,\n" +
                "    \"language\": \"EN\",\n" +
                "    \"countryId\": 100\n" +
                "}";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class).getBody();
    }

    public ResponseEntity<String> getAllProductsData() {
        String productsURL = "https://distro.silabg.com/api/v1/product?api_token=" + SILA_BG_API_TOKEN;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(productsURL, HttpMethod.POST, requestEntity, String.class);
    }
}
