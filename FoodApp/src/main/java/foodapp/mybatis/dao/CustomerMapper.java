package foodapp.mybatis.dao;

import foodapp.mybatis.model.Customer;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CUSTOMER
     *
     * @mbg.generated Tue Apr 11 23:51:28 EEST 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CUSTOMER
     *
     * @mbg.generated Tue Apr 11 23:51:28 EEST 2023
     */
    int insert(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CUSTOMER
     *
     * @mbg.generated Tue Apr 11 23:51:28 EEST 2023
     */
    Customer selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CUSTOMER
     *
     * @mbg.generated Tue Apr 11 23:51:28 EEST 2023
     */
    List<Customer> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CUSTOMER
     *
     * @mbg.generated Tue Apr 11 23:51:28 EEST 2023
     */
    int updateByPrimaryKey(Customer record);
}