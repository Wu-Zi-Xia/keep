package com.cduestc.keep.mapper;

import com.cduestc.keep.model.OrderShipping;
import com.cduestc.keep.model.OrderShippingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderShippingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    long countByExample(OrderShippingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int deleteByExample(OrderShippingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int insert(OrderShipping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int insertSelective(OrderShipping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    List<OrderShipping> selectByExample(OrderShippingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    OrderShipping selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByExampleSelective(@Param("record") OrderShipping record, @Param("example") OrderShippingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByExample(@Param("record") OrderShipping record, @Param("example") OrderShippingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByPrimaryKeySelective(OrderShipping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByPrimaryKey(OrderShipping record);
}