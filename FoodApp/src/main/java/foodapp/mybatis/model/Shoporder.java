package foodapp.mybatis.model;

import java.util.List;

public class Shoporder {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SHOPORDER.ID
     *
     * @mbg.generated Tue Apr 11 23:51:28 EEST 2023
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SHOPORDER.STATUS
     *
     * @mbg.generated Tue Apr 11 23:51:28 EEST 2023
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SHOPORDER.CUSTOMER_ID
     *
     * @mbg.generated Tue Apr 11 23:51:28 EEST 2023
     */
    private Long customerId;

    private Customer customer;

    public Customer getCustomer() { return customer; };

    public void setCustomer(Customer customer) { this.customer = customer; }

    private List<Item> items;

    public List<Item> getItems() { return items; };

    public void setItems(List<Item> items) { this.items = items; }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SHOPORDER.ID
     *
     * @return the value of PUBLIC.SHOPORDER.ID
     *
     * @mbg.generated Tue Apr 11 23:51:28 EEST 2023
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SHOPORDER.ID
     *
     * @param id the value for PUBLIC.SHOPORDER.ID
     *
     * @mbg.generated Tue Apr 11 23:51:28 EEST 2023
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SHOPORDER.STATUS
     *
     * @return the value of PUBLIC.SHOPORDER.STATUS
     *
     * @mbg.generated Tue Apr 11 23:51:28 EEST 2023
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SHOPORDER.STATUS
     *
     * @param status the value for PUBLIC.SHOPORDER.STATUS
     *
     * @mbg.generated Tue Apr 11 23:51:28 EEST 2023
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SHOPORDER.CUSTOMER_ID
     *
     * @return the value of PUBLIC.SHOPORDER.CUSTOMER_ID
     *
     * @mbg.generated Tue Apr 11 23:51:28 EEST 2023
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SHOPORDER.CUSTOMER_ID
     *
     * @param customerId the value for PUBLIC.SHOPORDER.CUSTOMER_ID
     *
     * @mbg.generated Tue Apr 11 23:51:28 EEST 2023
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}