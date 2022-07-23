package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
   List<User> selectAll();
   @Select(       " select * from tb_user where id=#{id};")
   User selectById(int id);
   User select(@Param("username")String username, @Param("password")String password);
   /*
  Mybatis封装参数
  1 单个参数
    1.pojo类型：直接使用，属性名和参数占位符一致
    2.Map集合：直接使用，键名 和参数占位符一致
    3.collection ：封装为map集合使用@param注解，替换map集合中默认的agr键名
    map.put("age0"，List集合);
    map.put("collection"，List集合);
    4.List：封装为map集合使用@param注解，替换map集合中默认的agr键名
         map.put("age0"，List集合);
    map.put("collection"，List集合);
    map.put("list"，List集合);
    5.Array 封装为map集合使用@param注解，替换map集合中默认的agr键名
    map。put（“age0，数组”）；
      map。put（“Array，数组”）
      6.其他类型直接使用
  2.多个参数
    map.put("age0"，参数值1);
     map.put("param1"，参数值1);
      map.put("param2"，参数值2);
       map.put("age1"，参数值2);
使用@param（“username”）注解，替换map集合中默认的agr键名
     map.put("username"，参数值1);
     map.put("param1"，参数值1);
     map.put("param2"，参数值2);
     map.put("age1"，参数值2);


    */

}
