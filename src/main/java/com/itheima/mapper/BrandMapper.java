package com.itheima.mapper;

import com.itheima.pojo.Brand;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    //查询所有
    List<Brand> selectAll();
    //查看详情
    Brand selectById(int id);
    //条件查询
    //参数接收
    //1
//    List<Brand> selectCondition(@Param("status")int status,@Param("companyName")String companyName,@Param("brandName")String brandName);
    //2
//    List<Brand> selectCondition(Brand brad);
    //3map集合参数多条件查询
     List<Brand> selectCondition(Map Map);
     //多条件动态查询
    List<Brand> selectSingle(Brand brand);
    void add(Brand brand);
    int update(Brand brand);
    void deleteById(int id);
    void deleteByIds(@Param("ids") int [] ids);

}
