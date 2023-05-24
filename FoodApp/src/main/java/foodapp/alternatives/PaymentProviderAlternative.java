package foodapp.alternatives;

import foodapp.services.PaymentProviderInterface;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.io.Serializable;
import java.util.Random;

@Alternative
@ApplicationScoped
public class PaymentProviderAlternative implements PaymentProviderInterface, Serializable {

    @Override
    public String payForOrder(String parameterString) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            return "Failed";
        }
        int paymentProviderId = new Random().nextInt(5000);
        return "Finished " + parameterString + " SEPA, PaymentId: " + paymentProviderId;
    }
}
