package gym.backend.service;

import gym.backend.models.DTO.CartProductsDTO;
import gym.backend.models.DTO.OrderDTO;
import gym.backend.models.entity.ProductEntity;
import gym.backend.repository.ProductEntityRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

import static gym.backend.consts.EmailConst.*;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final ProductEntityRepository productEntityRepository;

    @Value("${email.origin}")
    private String EMAIL_ORIGIN;

    public void sendReceivedOrder(Long randomOrderNumber, OrderDTO orderDTO) throws MessagingException {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append(RECEIVE_ORDER_HTML_START)
                .append(RECEIVE_ORDER_HTML_IMAGE)
                .append(RECEIVE_ORDER_HTML_INTRO)
                .append(RECEIVE_ORDER_HTML_DIVIDER)
                .append(fillRandomNumberTemplate(randomOrderNumber))
                .append(RECEIVE_ORDER_HTML_SPACER)
                .append(fillOrderInfoTemplate(orderDTO))
                .append(fillOrderProductTemplate(orderDTO.getCartItems()))
                .append(RECEIVE_ORDER_HTML_DIVIDER)
                .append(RECEIVE_ORDER_HTML_DISCLAIMER_INFO)
                .append(RECEIVE_ORDER_HTML_SPACER)
                .append(RECEIVE_ORDER_HTML_FOOTER)
                .append(RECEIVE_ORDER_HTML_END);

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(EMAIL_ORIGIN);
        helper.setTo(orderDTO.getEmail());
        helper.setSubject("Thats a test");
        helper.setText(stringBuilder.toString(), true);

        javaMailSender.send(message);
    }


    private String fillRandomNumberTemplate(Long randomOrderNumber) {
        return RECEIVE_ORDER_HTML_RANDOM_ORDER_NUMBER.replaceFirst("randomGeneratedNumber", randomOrderNumber.toString());
    }

    private String fillOrderInfoTemplate(OrderDTO orderDTO) {
        String deliveryType = "";
        String addressLineOne = "";
        String addressLineTwo = "Няма";

        if (orderDTO.getDelivery().equals("ADDRESS")) {
            deliveryType = "До адрес";
            addressLineOne = orderDTO.getAddress();
            addressLineTwo = orderDTO.getAdditionalAddress();
        } else if (orderDTO.getDelivery().equals("OFFICE")) {
            deliveryType = "До офис";
            addressLineOne = orderDTO.getOfficeAddress();
        }

        return RECEIVE_ORDER_HTML_ALL_INFO
                .replaceFirst("FirstName", orderDTO.getFirstName())
                .replaceFirst("LastName", orderDTO.getLastName())
                .replaceFirst("userEmail", orderDTO.getEmail())
                .replaceFirst("phoneNumber", orderDTO.getPhone())
                .replaceFirst("Country", orderDTO.getCountry())
                .replaceFirst("Town", orderDTO.getTown())
                .replaceFirst("PostCode", orderDTO.getPostCode())
                .replaceFirst("Courier", orderDTO.getCourier())
                .replaceFirst("deliveryType", deliveryType)
                .replaceFirst("addressLineOne", addressLineOne)
                .replaceFirst("addressLineTwo", addressLineTwo)
                .replaceFirst("totalProductCount", orderDTO.getProductCount().toString())
                .replaceFirst("totalWeight", String.format("%.2f", orderDTO.getTotalWeight()))
                .replaceFirst("deliveryPrice", String.format("%.2f", orderDTO.getDeliveryPrice()))
                .replaceFirst("totalAmount", String.format("%.2f", orderDTO.getTotalAmount()))
                .replaceFirst("totalSaved", String.format("%.2f", orderDTO.getTotalSaving()));
    }

    private String fillOrderProductTemplate(List<CartProductsDTO> cartItems) {
        StringBuilder productSB = new StringBuilder();

        for (CartProductsDTO product : cartItems) {
            ProductEntity productEntity = productEntityRepository.findProductEntityByModelId(product.getModelId());

            String productTaste = "Няма";
            if (product.getSelectedTaste() != null) {
                productTaste = product.getSelectedTaste().getName();
            }

            String productImage = productEntity.getImage();
            String productTitle = productEntity.getName() + " - " + productEntity.getBrandEntity().getName();
            String productWeight = product.getWeightKg();
            String productQuantity = product.getQuantity();
            Double regularPrice = productEntity.getRegularPrice();
            Double reducedPrice = productEntity.getDiscountedPrice() * 1.3;
            Double savedAmount = regularPrice - reducedPrice;

            productSB.append(RECEIVE_ORDER_HTML_PRODUCT
                    .replaceFirst("productImage", productImage)
                    .replaceFirst("productTitle", productTitle)
                    .replaceFirst("productWeight", productWeight)
                    .replaceFirst("productTaste", productTaste)
                    .replaceFirst("productQuantity", productQuantity)
                    .replaceFirst("regularPrice", String.format("%.2f", regularPrice))
                    .replaceFirst("reducedPrice", String.format("%.2f", reducedPrice))
                    .replaceFirst("savedAmount", String.format("%.2f", savedAmount))
            );
        }

        return productSB.toString();
    }
}
