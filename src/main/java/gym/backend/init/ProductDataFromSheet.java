package gym.backend.init;

import gym.backend.models.entity.ProductEntity;
import gym.backend.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class ProductDataFromSheet {

    private final ProductEntityRepository productEntityRepository;

    public void checkIfProductIsPresent() throws IOException {
        String filePath = "C:\\Users\\stanimir.sergev\\Downloads\\distro_sila_2024_03_26_11_43_03.xlsx";

        FileInputStream fis = new FileInputStream(new File(filePath));
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
        String filePath = "C:\\Users\\stanimir.sergev\\Downloads\\distro_sila_2024_03_26_11_43_03.xlsx";

        FileInputStream fis = new FileInputStream(new File(filePath));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        System.out.println("Start modifying products inside the DB...");
        for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            if (row != null) {

                String modelIDInsideSheet = String.valueOf((int) Double.parseDouble(row.getCell(1).toString()));
                double regularPrice = Double.parseDouble(row.getCell(4).toString().split(" ")[0]);
                double discountedPrice = Double.parseDouble(row.getCell(6).toString().split(" ")[0]);
                String barcode = row.getCell(7).toString();
                boolean isAvailable = row.getCell(8).toString().equals("Да");

                if (productEntityRepository.existsByModelId(modelIDInsideSheet)) {
                    ProductEntity productEntity = productEntityRepository.findProductEntityByModelId(modelIDInsideSheet);
                    productEntity.setRegularPrice(regularPrice);
                    productEntity.setDiscountedPrice(discountedPrice);
                    productEntity.setBarcode(barcode);
                    productEntity.setIsAvailable(isAvailable);

                    productEntityRepository.save(productEntity);
                }
            }
        }

        System.out.println("Modifying completed!");

        fis.close();
        workbook.close();
    }

}
