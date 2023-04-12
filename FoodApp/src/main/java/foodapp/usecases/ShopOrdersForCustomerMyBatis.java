package foodapp.usecases;

import foodapp.mybatis.model.Customer;
import foodapp.mybatis.model.Shoporder;
import foodapp.mybatis.dao.CustomerMapper;
import foodapp.mybatis.dao.ShoporderMapper;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class ShopOrdersForCustomerMyBatis {
    @Inject
    private CustomerMapper customerMapper;

    @Inject
    private ShoporderMapper shoporderMapper;

    @Getter @Setter
    private Customer customer;

    @Getter @Setter
    private Shoporder shopOrderToCreate = new Shoporder();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long customerId = Long.parseLong(requestParameters.get("customerId"));
        this.customer = customerMapper.selectByPrimaryKey(customerId);
    }

    @Transactional
    public void createShopOrder() {
        shopOrderToCreate.setCustomerId(this.customer.getId());
        shoporderMapper.insert(shopOrderToCreate);
    }
}
