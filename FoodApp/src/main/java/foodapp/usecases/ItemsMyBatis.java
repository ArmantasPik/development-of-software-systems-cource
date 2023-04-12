package foodapp.usecases;

import foodapp.mybatis.dao.ItemMapper;
import foodapp.mybatis.model.Item;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ItemsMyBatis {
    @Inject
    private ItemMapper itemMapper;

    @Getter @Setter
    private Item itemToCreate = new Item();

    @Getter
    private List<Item> allItems;

    @PostConstruct
    public void init() { loadAllItems(); }

    @Transactional
    public void createItem(){
        this.itemMapper.insert(itemToCreate);
    }

    private void loadAllItems(){ this.allItems = itemMapper.selectAll(); }
}
