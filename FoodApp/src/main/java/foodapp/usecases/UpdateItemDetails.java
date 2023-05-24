package foodapp.usecases;

import foodapp.entities.Item;
import foodapp.interceptors.LoggedInvocation;
import foodapp.persistence.ItemsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateItemDetails implements Serializable {

    private Item item;

    @Inject
    private ItemsDAO itemsDAO;

    @PostConstruct
    private void Init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long itemId = Long.parseLong(requestParameters.get("itemId"));
        this.item = itemsDAO.findOne(itemId);
    }

    @Transactional
    @LoggedInvocation
    public String removeItem() {
        itemsDAO.delete(item.getId());
        return "/items.xhtml?faces-redirect=true";
    }

    @Transactional
    @LoggedInvocation
    public String updateItem() {
        try {
            itemsDAO.update(this.item);
        } catch (OptimisticLockException e) {
            return "itemDetails.xhtml?faces-redirect=true&itemId=" + this.item.getId() + "&error=optimistic-lock-exception";
        }
        return "items.xhtml?faces-redirect=true";
    }
}
