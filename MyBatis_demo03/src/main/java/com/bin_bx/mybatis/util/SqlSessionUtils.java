package com.bin_bx.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: //TODO
 * @ClassName: SqlSessionUtils
 * @Author: bxie
 * @Date: 2022/2/28 17:53
 * @Version:
 */
public class SqlSessionUtils {

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        try {
            //读取MyBatis的核心配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //创建SqlSessionFactoryBuilder对象
            //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
            //SqlSession sqlSession = sqlSessionFactory.openSession();
            //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
