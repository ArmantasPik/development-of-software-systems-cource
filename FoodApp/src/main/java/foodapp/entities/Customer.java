package foodapp.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Customer.findAll", query = "select c from Customer as c")
})
@Table(name = "CUSTOMER")
@Getter @Setter
public class Customer {

    public Customer() {

    }

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    private String username;

    @Basic(optional = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    private List<ShopOrder> shopOrders;

    @OneToMany(mappedBy = "customer")
    public List<ShopOrder> getShopOrders() {
        return shopOrders;
    }

    public void setShopOrders(List<ShopOrder> shopOrders) {
        this.shopOrders = shopOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(username, customer.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
