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
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36");
        headers.set("Referer", "https://distro.silabg.com/bg/list");

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("smail", "stanimirsergev159@gmail.com");
        requestBody.add("spass", "bymejuh");
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

    public ResponseEntity<String> getAllProductsData() {
        String productsURL = "https://distro.silabg.com/api/v1/product?api_token=" + SILA_BG_API_TOKEN;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(productsURL, HttpMethod.POST, requestEntity, String.class);
    }
}
