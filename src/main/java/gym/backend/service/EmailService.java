package gym.backend.service;

import gym.backend.exception.ResourceNotFoundException;
import gym.backend.models.DTO.Order.RetrieveOrderDTO;
import gym.backend.models.entity.OrderEntity;
import gym.backend.models.entity.OrderProductEntity;
import gym.backend.models.entity.ProductEntity;
import gym.backend.models.entity.TasteEntity;
import gym.backend.models.enums.OrderStatus;
import gym.backend.repository.ProductEntityRepository;
import gym.backend.repository.TasteEntityRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static gym.backend.consts.Email.EmailTitleConst.*;
import static gym.backend.consts.Email.Order.EmailTemplateConst.*;
import static gym.backend.consts.Email.Order.EmailTemplateKeys.*;
import static gym.backend.consts.Email.Order.EmailTemplateValues.*;
import static gym.backend.consts.Email.RetrieveOrdersByEmail.RetrieveOrdersHTMLConst.*;
import static gym.backend.consts.Email.RetrieveOrdersByEmail.RetrieveOrdersKeyConst.*;
import static gym.backend.consts.Email.RetrieveOrdersByEmail.RetrieveOrdersValueConst.*;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final ProductEntityRepository productEntityRepository;
    private final TasteEntityRepository tasteEntityRepository;

    @Value("${email.origin}")
    private String EMAIL_ORIGIN;

    public void generateHTMLContentAndSendEmail(OrderEntity orderEntity) throws MessagingException {
        StringBuilder sb = new StringBuilder();

        sb.append(ORDER_HTML_START);

        OrderStatus orderStatus = orderEntity.getOrderStatus();
        String orderTitle = "";

        if (orderStatus.equals(OrderStatus.PENDING)) {
            createHTMLBody(orderEntity, sb, PENDING_IMAGE_URL, PENDING_INTRO_TEXT, PENDING_DISCLAIMER_ONE_TEXT, PENDING_DISCLAIMER_TWO_TEXT);
            orderTitle = String.format(PENDING_TITLE, orderEntity.getRandomNumber());
        } else if (orderStatus.equals(OrderStatus.APPROVED)) {
            createHTMLBody(orderEntity, sb, APPROVED_IMAGE_URL, APPROVED_INTRO_TEXT, APPROVED_DISCLAIMER_ONE_TEXT, APPROVED_DISCLAIMER_TWO_TEXT);
            orderTitle = String.format(APPROVED_TITLE, orderEntity.getRandomNumber());
        } else if (orderStatus.equals(OrderStatus.IN_DELIVERY)) {
            createHTMLBody(orderEntity, sb, DELIVERY_IMAGE_URL, DELIVERY_INTRO_TEXT, DELIVERY_DISCLAIMER_ONE_TEXT, DELIVERY_DISCLAIMER_TWO_TEXT);
            orderTitle = String.format(IN_DELIVERY_TITLE, orderEntity.getRandomNumber());
        } else if (orderStatus.equals(OrderStatus.COMPLETED)) {
            createHTMLBody(orderEntity, sb, COMPLETED_IMAGE_URL, COMPLETED_INTRO_TEXT, COMPLETED_DISCLAIMER_ONE_TEXT, COMPLETED_DISCLAIMER_TWO_TEXT);
            orderTitle = String.format(COMPLETED_TITLE, orderEntity.getRandomNumber());
        } else if (orderStatus.equals(OrderStatus.CANCELED)) {
            createHTMLBody(orderEntity, sb, CANCELED_IMAGE_URL, CANCELED_INTRO_TEXT, CANCELED_DISCLAIMER_ONE_TEXT, CANCELED_DISCLAIMER_TWO_TEXT);
            orderTitle = String.format(CANCELED_TITLE, orderEntity.getRandomNumber());
        } else if (orderStatus.equals(OrderStatus.RETURNED)) {
            createHTMLBody(orderEntity, sb, RETURNED_IMAGE_URL, RETURNED_INTRO_TEXT, RETURNED_DISCLAIMER_ONE_TEXT, RETURNED_DISCLAIMER_TWO_TEXT);
            orderTitle = String.format(RETURNED_TITLE, orderEntity.getRandomNumber());
        }

        sb.append(ORDER_HTML_FOOTER);
        sb.append(ORDER_HTML_END);

        sendEmail(orderEntity.getEmail(), sb.toString(), orderTitle);
    }

    private void createHTMLBody(OrderEntity orderEntity, StringBuilder sb, String canceledImageUrl, String canceledIntroText, String canceledDisclaimerOneText, String canceledDisclaimerTwoText) {
        sb.append(ORDER_HTML_IMAGE.replaceFirst(ORDER_IMAGE_KEY, canceledImageUrl));
        sb.append(ORDER_HTML_INTRO.replaceFirst(ORDER_INTRO_KEY, canceledIntroText));
        sb.append(ORDER_HTML_RANDOM_ORDER_NUMBER.replaceFirst(ORDER_RANDOM_GENERATED_KEY, orderEntity.getRandomNumber().toString()));
        sb.append(ORDER_HTML_SPACER);
        sb.append(fillOrderInfoTemplate(orderEntity));
        sb.append(fillOrderProductTemplate(orderEntity));
        sb.append(ORDER_HTML_DIVIDER);
        sb.append(ORDER_HTML_DISCLAIMER_INFO.replaceFirst(ORDER_DISCLAIMER_ONE_KEY, canceledDisclaimerOneText).replaceFirst(ORDER_DISCLAIMER_TWO_KEY, canceledDisclaimerTwoText));
    }

    private String fillOrderInfoTemplate(OrderEntity orderEntity) {
        String deliveryType = "";
        String addressLineOne = "";

        if (orderEntity.getDelivery().equals("OFFICE")) {
            deliveryType = "До офис";
            addressLineOne = orderEntity.getOfficeAddress();
        }

        return ORDER_HTML_ALL_INFO
                .replaceFirst(FIRST_NAME_KEY, orderEntity.getFirstName())
                .replaceFirst(LAST_NAME_KEY, orderEntity.getLastName())
                .replaceFirst(USER_EMAIL_KEY, orderEntity.getEmail())
                .replaceFirst(PHONE_NUMBER_KEY, orderEntity.getPhone())
                .replaceFirst(COUNTRY_KEY, orderEntity.getCountry())
                .replaceFirst(TOWN_KEY, orderEntity.getTown())
                .replaceFirst(POST_CODE_KEY, orderEntity.getPostCode())
                .replaceFirst(COURIER_KEY, orderEntity.getCourier())
                .replaceFirst(DELIVERY_TYPE_KEY, deliveryType)
                .replaceFirst(ADDRESS_LINE_ONE_KEY, addressLineOne)
                .replaceFirst(TOTAL_PRODUCT_COUNT_KEY, orderEntity.getProductCount().toString())
                .replaceFirst(TOTAL_WEIGHT_KEY, String.format("%.2f", orderEntity.getTotalWeight()))
                .replaceFirst(DELIVERY_PRICE_KEY, String.format("%.2f", orderEntity.getDeliveryPrice()))
                .replaceFirst(TOTAL_AMOUNT_KEY, String.format("%.2f", orderEntity.getTotalAmount()))
                .replaceFirst(TOTAL_SAVED_KEY, String.format("%.2f", orderEntity.getTotalSaving()));
    }

    private String fillOrderProductTemplate(OrderEntity orderEntity) {
        StringBuilder productSB = new StringBuilder();

        for (OrderProductEntity orderProductEntity : orderEntity.getCartItems()) {
            ProductEntity productEntity = productEntityRepository.findProductEntityByModelId(orderProductEntity.getModelId());

            Optional<TasteEntity> tasteEntityBySilaTasteID = tasteEntityRepository.findTasteEntityBySilaTasteID(orderProductEntity.getSelectedTasteSilaId());

            String productTaste = "Няма";
            if (tasteEntityBySilaTasteID.isPresent()) {
                productTaste = tasteEntityBySilaTasteID.get().getName();
            }

            String productImage = productEntity.getImage();
            String productTitle = productEntity.getName() + " - " + productEntity.getBrandEntity().getName();
            String productWeight = productEntity.getWeightKg();
            Integer productQuantity = orderProductEntity.getQuantity();
            Double regularPrice = productEntity.getRegularPrice();
            Double reducedPrice = productEntity.getDiscountedPrice() * 1.4;
            Double savedAmount = regularPrice - reducedPrice;

            productSB.append(ORDER_HTML_PRODUCT
                    .replaceFirst(PRODUCT_IMAGE_KEY, productImage)
                    .replaceFirst(PRODUCT_TITLE_KEY, productTitle)
                    .replaceFirst(PRODUCT_WEIGHT_KEY, productWeight)
                    .replaceFirst(PRODUCT_TASTE_KEY, productTaste)
                    .replaceFirst(PRODUCT_QUANTITY_KEY, productQuantity.toString())
                    .replaceFirst(REGULAR_PRICE_KEY, String.format("%.2f", regularPrice))
                    .replaceFirst(REDUCED_PRICE_KEY, String.format("%.2f", reducedPrice))
                    .replaceFirst(SAVED_AMOUNT_KEY, String.format("%.2f", savedAmount))
            );
        }
        return productSB.toString();
    }

    private void sendEmail(String email, String htmlBody, String emailTitle) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(EMAIL_ORIGIN); //fixme this has to be sent from the company email...
        helper.setTo(email);
        helper.setSubject(emailTitle);
        helper.setText(htmlBody, true);

        javaMailSender.send(message);
    }

    public void generateAllOrdersByEmail(List<RetrieveOrderDTO> ordersByEmail) throws MessagingException {
        StringBuilder sb = new StringBuilder();

        sb.append(ORDER_HTML_START);
        sb.append(ORDER_HTML_SPACER);
        sb.append(RECOVER_ALL_ORDER_HTML_INTRO.replaceFirst(ORDER_INTRO_KEY, RETRIEVE_ORDER_INTRO_TEXT));
        sb.append(ORDER_HTML_SPACER);
        sb.append(generateTableContent(ordersByEmail));
        sb.append(ORDER_HTML_SPACER);
        sb.append(ORDER_HTML_DISCLAIMER_INFO.replaceFirst(ORDER_DISCLAIMER_ONE_KEY, RETRIEVE_ORDER_DISCLAIMER_ONE_TEXT).replaceFirst(ORDER_DISCLAIMER_TWO_KEY, RETRIEVE_ORDER_DISCLAIMER_TWO_TEXT));
        sb.append(ORDER_HTML_FOOTER);
        sb.append(ORDER_HTML_END);

        sendEmail("stanimirsergevsns@gmail.com", sb.toString(), RETRIEVE_ALL_ORDERS_LIST);
    }

    private String generateTableContent(List<RetrieveOrderDTO> ordersByEmail) {
        StringBuilder sb = new StringBuilder();

        sb.append(RECOVER_ALL_ORDER_HTML_TABLE_START);

        for (RetrieveOrderDTO orderDTO : ordersByEmail) {
            String randomOrderNumber = orderDTO.getRandomNumber().toString();
            String orderDate = dateOrderFormat(orderDTO.getDate());
            String totalOrderAmount = String.format("%.2f", orderDTO.getTotalAmount());

            String translatedStatus = "";
            switch (orderDTO.getOrderStatus()) {
                case PENDING -> translatedStatus = "Изчакващ";
                case APPROVED -> translatedStatus = "Одобрен";
                case IN_DELIVERY -> translatedStatus = "Доставя се";
                case COMPLETED -> translatedStatus = "Завършен";
                case CANCELED -> translatedStatus = "Отказан";
                case RETURNED -> translatedStatus = "Върнат";
                default -> throw new ResourceNotFoundException();
            }

            sb.append(RECOVER_ALL_ORDER_HTML_TABLE_CONTENT
                    .replaceFirst(ORDER_TABLE_NUMBER_KEY, randomOrderNumber)
                    .replaceFirst(ORDER_TABLE_DATE_KEY, orderDate)
                    .replaceFirst(ORDER_TABLE_AMOUNT_KEY, totalOrderAmount)
                    .replaceFirst(ORDER_TABLE_STATUS_KEY, translatedStatus)
            );
        }

        sb.append(RECOVER_ALL_ORDER_HTML_TABLE_END);

        return sb.toString();
    }

    private String dateOrderFormat(LocalDateTime orderTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm");
        return orderTime.format(formatter);
    }

    public void sendRequestEmail(String email, String title, String content) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(email);
        helper.setTo(email); //fixme this has to be sent to the company email...
        helper.setSubject(title);
        helper.setText(content);

        javaMailSender.send(message);
    }

}
