package foodapp.usecases;

import foodapp.entities.Item;
import foodapp.entities.ShopOrder;
import foodapp.persistence.ItemsDAO;
import foodapp.persistence.ShopOrdersDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Model
public class ItemsForShopOrder implements Serializable {

    @Inject
    private ItemsDAO itemsDAO;

    @Inject
    private ShopOrdersDAO shopOrdersDAO;

    @Getter @Setter
    private ShopOrder shopOrder;

    @Getter @Setter
    private Item itemToAdd = new Item();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long shopOrderId = Long.parseLong(requestParameters.get("shopOrderId"));
        this.shopOrder = shopOrdersDAO.findOne(shopOrderId);
    }

    @Transactional
    public void addItemToShopOrder() {
        itemToAdd = itemsDAO.findOne(itemToAdd.getId());
        List<ShopOrder> shopOrders = itemToAdd.getShopOrders();
        shopOrders.add(this.shopOrder);

        itemToAdd.setShopOrders(shopOrders);
        itemsDAO.persist(itemToAdd);
    }
}
