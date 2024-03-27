package gym.backend.init;

import gym.backend.models.entity.ProductEntity;
import gym.backend.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class ProductDataFromSheet {

    private final ProductEntityRepository productEntityRepository;

    public void checkIfProductIsPresent() throws IOException {
        String filePath = "C:\\Users\\stanimir.sergev\\Downloads\\distro_sila_2024_03_26_11_43_03.xlsx";

        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Set<String> secondColumnValuesList = new HashSet<>();

        System.out.println("Start checking for products availability...");
        for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            if (row != null) {
                String secondColumnValue = String.valueOf((int) Double.parseDouble(row.getCell(1).toString()));
                if (!productEntityRepository.existsByModelId(secondColumnValue)) {
                    System.out.println("Product with model ID is missing: " + row.getCell(1));
                }
                secondColumnValuesList.add(secondColumnValue);
            }
        }

        for (ProductEntity productEntity : productEntityRepository.findAll()) {
            if (!secondColumnValuesList.contains(productEntity.getModelId())) {
                System.out.println("This Product with model ID does not exist in the DB: " + productEntity.getModelId());
            }
        }
        System.out.println("Check finished! " + secondColumnValuesList.size());

        fis.close();
        workbook.close();
    }

    public void modifyExistingProducts() throws IOException {
//        String filePath = "C:\\Users\\stanimir.sergev\\Downloads\\distro_sila_2024_03_26_11_43_03.xlsx";

//        FileInputStream fis = new FileInputStream(filePath);
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);


        XSSFSheet sheet = getDistroSheet();

        if (sheet != null) {
            System.out.println("Start modifying products inside the DB...");
            for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);
                if (row != null) {

//                    FIXME
                    System.out.println(row.getCell(0));
                    System.out.println(row.getCell(1));
                    System.out.println(row.getCell(2));
                    System.out.println(row.getCell(3));
                    System.out.println(row.getCell(4));
                    System.out.println(row.getCell(5));
                    System.out.println(row.getCell(6));
                    System.out.println(row.getCell(7));


//                    System.out.println();
//                    String modelIDInsideSheet = String.valueOf((int) Double.parseDouble(row.getCell(1).toString()));
//                    double regularPrice = Double.parseDouble(row.getCell(4).toString().split(" ")[0]);
//                    double discountedPrice = Double.parseDouble(row.getCell(6).toString().split(" ")[0]);
//                    String barcode = row.getCell(7).toString();
//                    boolean isAvailable = row.getCell(8).toString().equals("Да");
//
//                    if (productEntityRepository.existsByModelId(modelIDInsideSheet)) {
//                        ProductEntity productEntity = productEntityRepository.findProductEntityByModelId(modelIDInsideSheet);
//                        productEntity.setRegularPrice(regularPrice);
//                        productEntity.setDiscountedPrice(discountedPrice);
//                        productEntity.setBarcode(barcode);
//                        productEntity.setIsAvailable(isAvailable);
//
//                        productEntityRepository.save(productEntity);
//                    }
                }
            }
        }


        System.out.println("Modifying completed!");
    }


    private XSSFSheet getDistroSheet() throws IOException {
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

}
