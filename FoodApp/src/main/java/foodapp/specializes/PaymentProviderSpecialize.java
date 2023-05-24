package foodapp.specializes;

import foodapp.alternatives.PaymentProviderAlternative;
import foodapp.services.PaymentProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import java.util.Random;

@Specializes
@ApplicationScoped
public class PaymentProviderSpecialize extends PaymentProvider {

    public String payForOrder(String parameterString) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            return "Failed";
        }
        int paymentProviderId = new Random().nextInt(5000);
        return "Finished " + parameterString + " CRYPTO, PaymentId: " + paymentProviderId;
    }
}
