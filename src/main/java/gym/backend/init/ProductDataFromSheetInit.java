package gym.backend.init;

import gym.backend.init.initService.RequestService;
import gym.backend.models.entity.ProductEntity;
import gym.backend.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductDataFromSheetInit {

    private final RequestService requestService;
    private final ProductEntityRepository productEntityRepository;

    public void startInit() throws IOException {
        XSSFSheet sheet = requestService.getDistroSheet();

        if (sheet != null) {
            System.out.println("Start modifying products inside the DB...");
            for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);
                if (row != null) {
                    String skuNumber = String.valueOf((int) Double.parseDouble(row.getCell(0).toString()));
                    double regularPrice = Double.parseDouble(row.getCell(3).toString().split(" ")[0]);
                    double discountedPrice = Double.parseDouble(row.getCell(5).toString().split(" ")[0]);
                    String barcode = row.getCell(6).toString();
                    boolean isAvailable = row.getCell(7).toString().equals("Да");

                    Optional<ProductEntity> productEntityBySkuAndBarcodeNull = productEntityRepository.findProductEntityBySkuAndBarcodeNull(skuNumber);
                    if (productEntityBySkuAndBarcodeNull.isPresent()) {
                        if (!barcode.isEmpty()) {
                            ProductEntity productEntity = productEntityBySkuAndBarcodeNull.get();
                            productEntity.setBarcode(barcode);
                            productEntityRepository.save(productEntity);
                        }
                    }

                    Optional<ProductEntity> productEntityBySku = productEntityRepository.findProductEntityBySku(skuNumber);
                    if (productEntityBySku.isPresent()) {
                        ProductEntity productEntity = productEntityBySku.get();
                        productEntity.setRegularPrice(regularPrice);
                        productEntity.setDiscountedPrice(discountedPrice);
                        productEntity.setIsAvailable(isAvailable);
                        productEntityRepository.save(productEntity);
                    }


                }
            }
        }

        System.out.println("Modifying completed!");
    }
}
