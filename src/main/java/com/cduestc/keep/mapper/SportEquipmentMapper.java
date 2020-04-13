package com.cduestc.keep.mapper;

import com.cduestc.keep.model.SportEquipment;
import com.cduestc.keep.model.SportEquipmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SportEquipmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    long countByExample(SportEquipmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    int deleteByExample(SportEquipmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    int deleteByPrimaryKey(Long equipmentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    int insert(SportEquipment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    int insertSelective(SportEquipment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    List<SportEquipment> selectByExample(SportEquipmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    SportEquipment selectByPrimaryKey(Long equipmentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    int updateByExampleSelective(@Param("record") SportEquipment record, @Param("example") SportEquipmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    int updateByExample(@Param("record") SportEquipment record, @Param("example") SportEquipmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    int updateByPrimaryKeySelective(SportEquipment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sports_equipment
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    int updateByPrimaryKey(SportEquipment record);
}