package gym.backend.models.DTO.Order.SpeedyApi;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class DeliveryPriceMainReqDTO {
    private String userName;
    private String password;
    private String language = "EN";
    private Recipient recipient = new Recipient();
    private Service service = new Service();
    private Content content = new Content();
    private Payment payment = new Payment();

    @Getter
    @Setter
    @ToString
    public static class Recipient {
        private boolean privatePerson = true;
        private int pickupOfficeId;
    }

    @Getter
    @Setter
    @ToString
    public static class Service {
        private boolean autoAdjustPickupDate = true;
        private List<Integer> serviceIds = new ArrayList<>();
        private AdditionalServices additionalServices = new AdditionalServices();

        public void setServiceIds() {
            this.serviceIds.add(505);
        }

        public List<Integer> getServiceIds() {
            setServiceIds();
            return serviceIds;
        }

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
                private double amount = 0.0;
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
    }

    @Getter
    @Setter
    @ToString
    public static class Payment {
        private String courierServicePayer = "RECIPIENT";
    }

}