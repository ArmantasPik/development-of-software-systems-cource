package foodapp.services;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class PaymentProvider implements PaymentProviderInterface, Serializable {

    public String payForOrder(String parameterString) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            return "Failed";
        }
        int paymentProviderId = new Random().nextInt(5000);
        return "Finished REGULAR, PaymentId: " + paymentProviderId;
    }
}
