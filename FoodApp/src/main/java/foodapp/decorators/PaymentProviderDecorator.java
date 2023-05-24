package foodapp.decorators;

import foodapp.services.PaymentProviderInterface;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import java.util.Random;

@Decorator
@Priority(Interceptor.Priority.APPLICATION)
public abstract class PaymentProviderDecorator implements PaymentProviderInterface {

    @Inject
    @Delegate
    @Any
    private PaymentProviderInterface paymentProvider;

    @Override
    public String payForOrder(String parameterString) {
        String response = paymentProvider.payForOrder("PRIORITY");

        return response;
    }
}
