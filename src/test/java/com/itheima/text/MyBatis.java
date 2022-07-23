package com.itheima.text;

import com.itheima.mapper.BrandMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatis {
@Test
    public void textSelectAll() throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    //获取SQLsession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //获取mapper接口代理对象
   BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
    List<Brand> brands =brandMapper.selectAll();
    System.out.println(brands);
    sqlSession.close();
}
@Test
    public void textSelectById() throws IOException {
    int id = 1;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SQLsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
        Brand brands =brandMapper.selectById(id);
        System.out.println(brands);
        //释放资源
        sqlSession.close();
    }
    @Test
    //多条件查询
    public void textSelectByCondition() throws IOException {
//        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        companyName = "%"+companyName+"%";
//        brandName = "%"+brandName+"%";

        //2封装对象
//        Brand brand= new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
 //3
        Map map =new HashMap();
//        map.put("status",status);
       // map.put("companyName",companyName);
      map.put("brandName",brandName);
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SQLsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
// 1       List<Brand> brands =brandMapper.selectCondition(status,companyName,brandName);
// 2       List<Brand> brands =brandMapper.selectCondition(brand);
        //3
        List<Brand> brands =brandMapper.selectCondition(map);
        System.out.println(brands);
        //释放资源
        sqlSession.close();
    }
    @Test
    public void textSelectSingle() throws IOException {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";
        Brand brand= new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SQLsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(

        );
        //获取mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
        List<Brand> brands = brandMapper.selectSingle(brand);
        System.out.println(brands);
        //释放资源
        sqlSession.close();
    }
    @Test
    public void add() throws IOException {
        int status = 1;
        String companyName = "诺基亚手机";
        String brandName = "谷歌";
        String description ="核不碎";
        int ordered =100;
        Brand brand= new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SQLsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
        brandMapper.add(brand);
        //执行事务
        sqlSession.commit();
        Integer id = brand.getId();
        System.out.println(id);
        //释放资源
        sqlSession.close();
    }
    @Test
    public void updata() throws IOException {
        int status = 0;
        String companyName = "苹果手机";
//        String brandName = "苹果公司";
//        String description ="rabish";
        int ordered =50;
        int id =7;
        Brand brand= new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setDescription(description);
//        brand.setOrdered(ordered);
        brand.setId(id);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SQLsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
        int count =brandMapper.update(brand);
        //执行事务
      sqlSession.commit();
System.out.println(count);
        //释放资源
        sqlSession.close();
    }
    @Test
    public void deleteById() throws IOException {
        int id = 8;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SQLsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
        brandMapper.deleteById(id);

        //释放资源
        sqlSession.close();
    }
    @Test
    public void deleteByIds() throws IOException {
        int [] ids = {9,10,11};
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SQLsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
        brandMapper.deleteByIds(ids);

        //释放资源
        sqlSession.close();
    }

}
