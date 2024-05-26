package gym.backend.models.DTO.Admin.Order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateOrderSpeedyApiReqDTO {
    private String userName;
    private String password;
    private String language = "EN";
    private Service service = new Service();
    private Content content = new Content();
    private Payment payment = new Payment();
    private Sender sender = new Sender();
    private Recipient recipient = new Recipient();
    private String ref1 = "ORDER";

    @Getter
    @Setter
    @ToString
    public static class Service {
        private int serviceId = 505;
        private AdditionalServices additionalServices = new AdditionalServices();
        private boolean saturdayDelivery = true;
        private boolean autoAdjustPickupDate = true;

        @Getter
        @Setter
        @ToString
        public static class AdditionalServices {
            private Cod cod = new Cod();
            private DeclaredValue declaredValue = new DeclaredValue();
            private Obpd obpd = new Obpd();

            @Getter
            @Setter
            @ToString
            public static class Cod {
                private double amount = 0;
                private String processingType = "CASH";
            }

            @Getter
            @Setter
            @ToString
            public static class DeclaredValue {
                private double amount;
                private boolean fragile = true;
                private boolean ignoreIfNotApplicable = true;
            }

            @Getter
            @Setter
            @ToString
            public static class Obpd {
                private String option = "OPEN";
                private int returnShipmentServiceId = 505;
                private String returnShipmentPayer = "SENDER";
            }
        }
    }

    @Getter
    @Setter
    @ToString
    public static class Content {
        private int parcelsCount = 1;
        private double totalWeight;
        private String contents = "FOOD SUPPLEMENTS";
        @JsonProperty("package")
        private String packageType = "Box";
    }

    @Getter
    @Setter
    @ToString
    public static class Payment {
        private String courierServicePayer = "RECIPIENT";
        private String declaredValuePayer = "RECIPIENT";
    }

    @Getter
    @Setter
    @ToString
    public static class Sender {
        private Phone phone1 = new Phone();
        private String contactName = "IVAN PETROV";
        private String email = "ivan@petrov.bg";
    }

    @Getter
    @Setter
    @ToString
    public static class Recipient {
        private Phone phone1 = new Phone();
        private String clientName;
        private String email;
        private boolean privatePerson = true;
        private Long pickupOfficeId;
    }

    @Getter
    @Setter
    @ToString
    public static class Phone {
        private String number;
    }
}
