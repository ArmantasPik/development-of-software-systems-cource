package foodapp.usecases;

import foodapp.entities.Customer;
import foodapp.entities.ShopOrder;
import foodapp.persistence.CustomersDAO;
import foodapp.persistence.ShopOrdersDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class ShopOrdersForCustomer implements Serializable {

    @Inject
    private CustomersDAO customersDAO;

    @Inject
    private ShopOrdersDAO shopOrdersDAO;

    @Getter @Setter
    private Customer customer;

    @Getter @Setter
    private ShopOrder shopOrderToCreate = new ShopOrder();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long customerId = Long.parseLong(requestParameters.get("customerId"));
        this.customer = customersDAO.findOne(customerId);
    }

    @Transactional
    public void createShopOrder() {
        shopOrderToCreate.setCustomer(this.customer);
        shopOrdersDAO.persist(shopOrderToCreate);
    }
}
