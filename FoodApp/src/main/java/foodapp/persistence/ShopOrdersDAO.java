package foodapp.persistence;

import foodapp.entities.ShopOrder;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class ShopOrdersDAO {
    @Inject
    private EntityManager em;

    public void persist(ShopOrder shopOrder){
        this.em.persist(shopOrder);
    }

    public ShopOrder findOne(Long id){
        return em.find(ShopOrder.class, id);
    }

    public ShopOrder update(ShopOrder shopOrder){
        return em.merge(shopOrder);
    }
}
