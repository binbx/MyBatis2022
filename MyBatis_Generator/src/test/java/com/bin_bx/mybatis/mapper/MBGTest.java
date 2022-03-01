package com.bin_bx.mybatis.mapper;

import com.bin_bx.mybatis.pojo.Emp;
import com.bin_bx.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description: 测试mybatis_generator代码生成器逆向工程
 * @ClassName: MBGTest
 * @Author: bxie
 * @Date: 2022/3/1 16:47
 * @Version:
 */
public class MBGTest {

    @Test
    public void testMBG(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

            //查询所以数据
            /*List<Emp> list = mapper.selectByExample(null);
            list.forEach(System.out::println);*/

            //根据条件查询
            /*EmpExample example = new EmpExample();
            //创建条件对象，通过andXXX方法为SQL添加查询添加，每个条件之间是and关系
            example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
            //将之前添加的条件通过or拼接其他条件
            example.or().andDidIsNotNull(); //并且 Did 不为空
            List<Emp> list = mapper.selectByExample(example);
            list.forEach(System.out::println);*/

            //根据主键进行修改
            mapper.updateByPrimaryKeySelective(new Emp(9,"admin",22,null,"456@qq.com",3));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
