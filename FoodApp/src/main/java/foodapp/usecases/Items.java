package foodapp.usecases;

import foodapp.entities.Item;
import foodapp.persistence.ItemsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Items {

    @Inject
    private ItemsDAO itemsDAO;

    @Getter @Setter
    private Item itemToCreate = new Item();

    @Getter
    private List<Item> allItems;

    @PostConstruct
    public void init() { loadAllItems(); }

    @Transactional
    public void createItem(){
        this.itemsDAO.persist(itemToCreate);
    }

    private void loadAllItems(){ this.allItems = itemsDAO.loadAll(); }
}
