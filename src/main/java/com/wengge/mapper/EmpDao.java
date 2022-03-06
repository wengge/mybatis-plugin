package com.wengge.mapper;

import com.wengge.po.EmpPO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface EmpDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EmpPO record);

    int insertSelective(EmpPO record);

    EmpPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmpPO record);

    int updateByPrimaryKey(EmpPO record);

    EmpPO selectBySexAndSalaryAndName(@Param("sex") Integer sex, @Param("salary") BigDecimal salary, @Param("name") String name);

//    EmpPO selectBySexAndSalaryAndName(Integer sex, BigDecimal salary, String name);

    EmpPO selectById(Integer id);

    List<EmpPO> selectAll();

}