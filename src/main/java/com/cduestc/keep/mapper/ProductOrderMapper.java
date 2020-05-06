package com.cduestc.keep.mapper;

import com.cduestc.keep.model.ProductOrder;
import com.cduestc.keep.model.ProductOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_order
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    long countByExample(ProductOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_order
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int deleteByExample(ProductOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_order
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_order
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int insert(ProductOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_order
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int insertSelective(ProductOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_order
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    List<ProductOrder> selectByExample(ProductOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_order
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    ProductOrder selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_order
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByExampleSelective(@Param("record") ProductOrder record, @Param("example") ProductOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_order
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByExample(@Param("record") ProductOrder record, @Param("example") ProductOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_order
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByPrimaryKeySelective(ProductOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_order
     *
     * @mbg.generated Tue May 05 16:16:31 CST 2020
     */
    int updateByPrimaryKey(ProductOrder record);
}