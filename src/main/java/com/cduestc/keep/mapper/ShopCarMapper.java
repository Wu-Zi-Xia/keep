package com.cduestc.keep.mapper;

import com.cduestc.keep.model.ShopCar;
import com.cduestc.keep.model.ShopCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopCarMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_car
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    long countByExample(ShopCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_car
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    int deleteByExample(ShopCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_car
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    int deleteByPrimaryKey(Long shopCarid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_car
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    int insert(ShopCar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_car
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    int insertSelective(ShopCar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_car
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    List<ShopCar> selectByExample(ShopCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_car
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    ShopCar selectByPrimaryKey(Long shopCarid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_car
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    int updateByExampleSelective(@Param("record") ShopCar record, @Param("example") ShopCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_car
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    int updateByExample(@Param("record") ShopCar record, @Param("example") ShopCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_car
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    int updateByPrimaryKeySelective(ShopCar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_car
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    int updateByPrimaryKey(ShopCar record);
}