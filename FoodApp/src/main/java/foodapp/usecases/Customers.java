package foodapp.usecases;

import foodapp.entities.Customer;
import foodapp.persistence.CustomersDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Customers {

    @Inject
    private CustomersDAO customersDAO;

    @Getter @Setter
    private Customer customerToCreate = new Customer();

    @Getter
    private List<Customer> allCustomers;

    @PostConstruct
    public void init() { loadAllCustomers(); }

    @Transactional
    public void createCustomer(){
        this.customersDAO.persist(customerToCreate);
    }

    private void loadAllCustomers(){ this.allCustomers = customersDAO.loadAll(); }
}
