package foodapp.usecases;

import foodapp.entities.ShopOrder;
import foodapp.mybatis.dao.ItemMapper;
import foodapp.mybatis.dao.ShoporderMapper;
import foodapp.mybatis.model.Item;
import foodapp.mybatis.model.Shoporder;
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
public class ItemsForShopOrderMyBatis implements Serializable {

    @Inject
    private ItemMapper itemMapper;

    @Inject
    private ShoporderMapper shoporderMapper;

    @Getter @Setter
    private Shoporder shopOrder;

    @Getter @Setter
    private Item itemToAdd = new Item();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long shopOrderId = Long.parseLong(requestParameters.get("shopOrderId"));
        this.shopOrder = shoporderMapper.selectByPrimaryKey(shopOrderId);
    }

    @Transactional
    public void addItemToShopOrder() {
        Long itemId = itemToAdd.getId();

        shoporderMapper.addItem(itemId, shopOrder.getId());
    }
}
