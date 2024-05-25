package gym.backend.models.DTO.Admin.Order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateOrderSpeedyApiReqDTO {
    public String userName;
    public String password;
    public String language = "EN";
    public Service service = new Service();
    public Content content = new Content();
    public Payment payment = new Payment();
    public Sender sender = new Sender();
    public Recipient recipient = new Recipient();
    public String ref1 = "ORDER 123456";

    @Getter
    @Setter
    @ToString
    public static class Service {
        public int serviceId = 505;
        public AdditionalServices additionalServices = new AdditionalServices();
        public boolean saturdayDelivery = true;
        public boolean autoAdjustPickupDate = true;

        @Getter
        @Setter
        @ToString
        public static class AdditionalServices {
            public Cod cod = new Cod();
            public DeclaredValue declaredValue = new DeclaredValue();
            public Obpd obpd = new Obpd();

            @Getter
            @Setter
            @ToString
            public static class Cod {
                public double amount = 0;
                public String processingType = "CASH";
            }

            @Getter
            @Setter
            @ToString
            public static class DeclaredValue {
                public double amount;
                public boolean fragile = true;
                public boolean ignoreIfNotApplicable = true;
            }

            @Getter
            @Setter
            @ToString
            public static class Obpd {
                public String option = "OPEN";
                public int returnShipmentServiceId = 505;
                public String returnShipmentPayer = "SENDER";
            }
        }
    }

    @Getter
    @Setter
    @ToString
    public static class Content {
        public int parcelsCount = 1;
        public double totalWeight;
        public String contents = "FOOD SUPPLEMENTS";
        public String packageType = "BOX";
    }

    @Getter
    @Setter
    @ToString
    public static class Payment {
        public String courierServicePayer = "RECIPIENT";
        public String declaredValuePayer = "RECIPIENT";
    }

    @Getter
    @Setter
    @ToString
    public static class Sender {
        public Phone phone1 = new Phone();
        public String contactName = "Stanimir Sergev";
        public String email = "stanimirsergev159@gmail.com";
    }

    @Getter
    @Setter
    @ToString
    public static class Recipient {
        public Phone phone1 = new Phone();
        public String clientName;
        public String email;
        public boolean privatePerson = true;
        public Long pickupOfficeId;
    }

    @Getter
    @Setter
    @ToString
    public static class Phone {
        public String number;
    }
}
