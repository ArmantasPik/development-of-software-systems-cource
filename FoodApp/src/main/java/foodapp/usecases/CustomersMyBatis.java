package foodapp.usecases;

import foodapp.mybatis.dao.CustomerMapper;
import foodapp.mybatis.model.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class CustomersMyBatis {
    @Inject
    private CustomerMapper customerMapper;

    @Getter
    private List<Customer> allCustomers;

    @Getter @Setter
    private Customer customerToCreate = new Customer();

    @PostConstruct
    public void init() { this.loadAllCustomers(); }

    private void loadAllCustomers() { this.allCustomers = customerMapper.selectAll(); }

    @Transactional
    public void createCustomer() {
        customerMapper.insert(customerToCreate);
    }
}
