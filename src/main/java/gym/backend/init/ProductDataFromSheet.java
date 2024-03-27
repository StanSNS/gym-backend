//package gym.backend.init;
//
//import gym.backend.models.entity.ProductEntity;
//import gym.backend.repository.ProductEntityRepository;
//import lombok.RequiredArgsConstructor;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.http.*;
//import org.springframework.stereotype.Component;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//@RequiredArgsConstructor
//public class ProductDataFromSheet {
//
//    private final ProductEntityRepository productEntityRepository;
//
//    public void checkIfProductIsPresent() throws IOException {
////        String filePath = "src/main/resources/dataDocument/distro_sila_2024_03_25_16_42_03.xlsx";
////
////        FileInputStream fis = new FileInputStream(filePath);
////        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//
//
//
////        XSSFSheet sheet = workbook.getSheetAt(0);
//
//
//        XSSFSheet sheet = getDistroSheet();
//
//        Set<String> skuValuesFromSheet = new HashSet<>();
//
//        System.out.println("Start checking for products availability...");
//        for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
//            XSSFRow row = sheet.getRow(i);
//            if (row != null) {
//
//                String skuValueFromSheet = String.valueOf((int) Double.parseDouble(row.getCell(0).toString()));
//
//                if (!productEntityRepository.existsBySku(skuValueFromSheet)) {
//                    System.out.println("Product with model ID is missing: " + skuValueFromSheet);
//                }
//                skuValuesFromSheet.add(skuValueFromSheet);
//            }
//        }
//
//        for (ProductEntity productEntity : productEntityRepository.findAll()) {
//            if (!skuValuesFromSheet.contains(productEntity.getSku())) {
//                System.out.println("This Product with SKU ID does not exist in the DB: " + productEntity.getSku());
//            }
//        }
//        System.out.println("Check finished! " + skuValuesFromSheet.size());
////
////        fis.close();
////        workbook.close();
//    }
//
//    public void modifyExistingProducts() throws IOException {
//        String filePath = "src/main/resources/dataDocument/distro_sila_2024_03_25_16_42_03.xlsx";
//
//        FileInputStream fis = new FileInputStream(filePath);
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
////        XSSFSheet sheet = workbook.getSheetAt(0);
//
//        XSSFSheet sheet = getDistroSheet();
//
//        if (sheet != null) {
//            System.out.println("Start modifying products inside the DB...");
//            for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
//                XSSFRow row = sheet.getRow(i);
//                if (row != null) {
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
//                }
//            }
//        }
//
//        System.out.println("Modifying completed!");
//    }
//
//
//
//
//}
