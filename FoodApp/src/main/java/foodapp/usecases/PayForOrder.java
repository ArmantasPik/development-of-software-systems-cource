package foodapp.usecases;

import foodapp.entities.ShopOrder;
import foodapp.interceptors.LoggedInvocation;
import foodapp.persistence.ShopOrdersDAO;
import foodapp.services.PaymentProvider;
import foodapp.services.PaymentProviderInterface;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class PayForOrder implements Serializable {

    @Inject
    private PaymentProviderInterface paymentProvider;

    @Inject
    private ShopOrdersDAO shopOrdersDAO;

    private ShopOrder shopOrder;

    private CompletableFuture<String> paymentProviderTask = null;

    @LoggedInvocation
    public String payForNewOrder() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Long shopOrderId = Long.parseLong(requestParameters.get("shopOrderId"));
        this.shopOrder = shopOrdersDAO.findOne(shopOrderId);
        paymentProviderTask = CompletableFuture.supplyAsync(() -> paymentProvider.payForOrder(""));
        return "/shopOrderDetails.xhtml?faces-redirect=true&shopOrderId=" + shopOrderId;
    }

    public boolean isPaymentStarted() { return paymentProviderTask != null; }

    public boolean isPaymentRunning() {
        return paymentProviderTask != null && !paymentProviderTask.isDone();
    }

    @Transactional
    public String getPaymentProviderStatus() throws ExecutionException, InterruptedException {
        if (paymentProviderTask == null) {
            return null;
        } else if (isPaymentRunning()) {
            return "Payment in progress";
        }

        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String responseString = null;
        Long parsedRequestShopOrderId = Long.parseLong(requestParameters.get("shopOrderId"));

        if (parsedRequestShopOrderId.equals(shopOrder.getId())) {
            responseString = "Payment has " + paymentProviderTask.get() + ". ShopOrderId: " + shopOrder.getId();

            this.shopOrder.setStatus("Finished");
            shopOrdersDAO.update(this.shopOrder);

            paymentProviderTask = null;
            this.shopOrder = null;
        }

        return responseString;
    }
}
