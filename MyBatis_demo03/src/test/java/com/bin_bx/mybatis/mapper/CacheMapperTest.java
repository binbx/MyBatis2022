package com.bin_bx.mybatis.mapper;

import com.bin_bx.mybatis.pojo.Emp;
import com.bin_bx.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Date:2021/11/30
 * Author: bxie
 * Description:
 * mybaits中一级缓存是默认开启的，作用域很小，是同一个sqlSession
 *
 */
public class CacheMapperTest {

    /**
     * 测试一级缓存
     * 查询与添加
     */
    @Test
    public void testOneCache(){
        SqlSession sqlSession1 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpByEid(1);
        System.out.println(emp1);

        //mapper1.insertEmp(new Emp(null,"abc",23,"男","123@qq.com",null));

        sqlSession1.clearCache(); //清空一级缓存（clearCache只对一级缓存有效）
        Emp emp2 = mapper1.getEmpByEid(1);
        System.out.println(emp2);


        /*SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpByEid(1);
        System.out.println(emp2);*/
    }


    /**
     * 测试二级缓存
     */
    @Test
    public void testTwoCache(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper1.getEmpByEid(1));
            sqlSession1.close();

            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpByEid(1));
            sqlSession2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
