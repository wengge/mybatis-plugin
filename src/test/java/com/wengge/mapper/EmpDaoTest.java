package com.wengge.mapper;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wengge.po.EmpEntity;
import com.wengge.po.EmpPO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

public class EmpDaoTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void selectBySexAndSalaryAndName() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDao empDao = sqlSession.getMapper(EmpDao.class);
        EmpPO empPO = empDao.selectBySexAndSalaryAndName(0, new BigDecimal("500"), "张三");
        System.out.println(empPO);
    }


    @Test
    public void selectById() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDao empDao = sqlSession.getMapper(EmpDao.class);
        EmpPO empPO = empDao.selectById(1);
        System.out.println(empPO);
    }


    @Test
    public void selectAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDao empDao = sqlSession.getMapper(EmpDao.class);
        List<EmpPO> empPOList = empDao.selectAll();
        for (EmpPO empPO : empPOList) {
            System.out.println(empPO);
        }
    }
    @Test
    public void testPageHelper() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDao empDao = sqlSession.getMapper(EmpDao.class);
        //设置分页参数
        PageHelper.startPage(1, 2);
        List<EmpPO> empPOList = empDao.selectAll();
        //注意千万只能执行一次
//        empPOList= empDao.selectAll();
        for (EmpPO empPO : empPOList) {
            System.out.println(empPO);
        }
        //其他分页的相关数据
        PageInfo<EmpPO> pageInfo = new PageInfo<EmpPO>(empPOList);
        System.out.println("总条数:" + pageInfo.getTotal());
        System.out.println("总页数:" + pageInfo.getPages());
        System.out.println("当前页:" + pageInfo.getPageNum());
        System.out.println("每页显万长度:" + pageInfo.getPageSize());
        System.out.println("是否第一页:" + pageInfo.isIsFirstPage());
        System.out.println("是否最后一页:" + pageInfo.isIsLastPage());
    }

    @Test
    public void testAuto() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        EmpEntity entity = new EmpEntity();
        entity.setId(4);

        // (1) mapper 基础接口

        // select 接口
        // 根据实体中的属性进行查询，只能有—个返回值
        EmpEntity entity1 = empMapper.selectOne(entity);
        // 查询全部结果
//        List<EmpEntity> empEntityList = empMapper.select(null);
//        // 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
//        empMapper.selectByPrimaryKey(1);
//        // 根据实体中的属性查询总数，查询条件使用等号
//        empMapper.selectCount(entity);

//        // insert 接口
//        // 保存一个实体，null 值也会保存，不会使用数据库默认值
//        int insert = empMapper.insert(entity);
//        // 保存实体，null的属性不会保存，会使用数据库默认值
//        int i = empMapper.insertSelective(entity);
//
//        // update 接口
//        // 根据主键更新实体全部字段，null 值会被更新
//        int i1 = empMapper.updateByPrimaryKey(entity);
//
//        // delete 接口
//        // 根据实体属性作为条件进行删除，查询条件使用等号
//        int delete = empMapper.delete(entity);
//        // 根据主键字段进行删除，方法参数必须包含完整的主键属性
//        empMapper.deleteByPrimaryKey(1);

        // (2) example 方法

//        Example example = new Example(EmpEntity.class);
//        example.createCriteria().andEqualTo("id", 1);
//        example.createCriteria().andLike("name", "张三");
//        //自定义查询
//        List<EmpEntity> empEntityList1 = empMapper.selectByExample(example);
    }
}

