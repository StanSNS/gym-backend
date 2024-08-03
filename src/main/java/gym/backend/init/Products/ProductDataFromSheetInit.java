package gym.backend.init.Products;

import gym.backend.exception.InitDataException;
import gym.backend.init.initService.RequestService;
import gym.backend.models.entity.ProductEntity;
import gym.backend.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class ProductDataFromSheetInit {

    private final RequestService requestService;
    private final ProductEntityRepository productEntityRepository;

    @CacheEvict(value = "allSellableProducts", allEntries = true)
    public void startInit() throws IOException {
        XSSFSheet sheet = requestService.getDistroSheet();
        if (sheet != null) {
            ArrayList<ProductEntity> productEntityArrayList = new ArrayList<>();

            for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);
                if (row != null) {
                    String modelID = String.valueOf((int) Double.parseDouble(row.getCell(0).toString()));
                    double regularPrice = Double.parseDouble(row.getCell(3).toString().split(" ")[0]);
                    double discountedPrice = Double.parseDouble(row.getCell(5).toString().split(" ")[0]);
                    boolean isAvailable = row.getCell(7).toString().equals("Да");

                    ProductEntity productEntityByModelId = productEntityRepository.findProductEntityByModelId(modelID);
                    if (productEntityByModelId != null) {
                        productEntityByModelId.setRegularPrice(regularPrice);
                        productEntityByModelId.setDiscountedPrice(discountedPrice);
                        productEntityByModelId.setIsAvailable(isAvailable);
                        productEntityArrayList.add(productEntityByModelId);
                    }
                }
            }
            productEntityRepository.saveAll(productEntityArrayList);
        } else {
            throw new InitDataException("product-data-details-sheet-execute");
        }

    }
}
