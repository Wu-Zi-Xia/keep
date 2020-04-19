package com.cduestc.keep.mapper;

import com.cduestc.keep.model.ProductSpecs;
import com.cduestc.keep.model.ProductSpecsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductSpecsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_specs
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    long countByExample(ProductSpecsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_specs
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    int deleteByExample(ProductSpecsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_specs
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_specs
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    int insert(ProductSpecs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_specs
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    int insertSelective(ProductSpecs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_specs
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    List<ProductSpecs> selectByExample(ProductSpecsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_specs
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    ProductSpecs selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_specs
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    int updateByExampleSelective(@Param("record") ProductSpecs record, @Param("example") ProductSpecsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_specs
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    int updateByExample(@Param("record") ProductSpecs record, @Param("example") ProductSpecsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_specs
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    int updateByPrimaryKeySelective(ProductSpecs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_specs
     *
     * @mbg.generated Sun Apr 19 02:58:57 CST 2020
     */
    int updateByPrimaryKey(ProductSpecs record);
}