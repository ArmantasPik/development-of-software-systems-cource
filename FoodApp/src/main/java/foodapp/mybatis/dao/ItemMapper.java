package foodapp.mybatis.dao;

import foodapp.mybatis.model.Item;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ITEM
     *
     * @mbg.generated Tue Apr 11 23:51:28 EEST 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ITEM
     *
     * @mbg.generated Tue Apr 11 23:51:28 EEST 2023
     */
    int insert(Item record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ITEM
     *
     * @mbg.generated Tue Apr 11 23:51:28 EEST 2023
     */
    Item selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ITEM
     *
     * @mbg.generated Tue Apr 11 23:51:28 EEST 2023
     */
    List<Item> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ITEM
     *
     * @mbg.generated Tue Apr 11 23:51:28 EEST 2023
     */
    int updateByPrimaryKey(Item record);
}