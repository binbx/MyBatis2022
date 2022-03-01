package com.bin_bx.mybatis.mapper;

import com.bin_bx.mybatis.pojo.User;
import com.bin_bx.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * MyBatis的各种查询功能：
 *    1、若查询出的数据只有一条
 *       a>可以通过实体类对象接收
 *       b>可以通过list集合接收
 *       c>可以通过map集合接收
 *       结果：{password=123456, sex=男, id=3, age=23, email=12345@qq.com, username=admin}
 *    2、若查询出的数据有多条
 *       a>可以通过实体类类型的list集合接收
 *       b>可以通过map类型的list集合接收
 *       c>可以在mapper接口的方法上添加@MapKey注解，此时就可以将每条数据转换的map集合作为值，以某个字段的值作为键，放在同一个map集合中
 *       注意：一定不能通过实体类对象接收，此时会抛异常TooManyResultsException
 *
 * MyBatis中设置了默认的类型别名
 *    java.lang.Integer-->int,integer
 *    int-->_int,_integer
 *    Map-->map
 *    String-->string
 */
public class SelectMapperTest {

    /**
     * 根据id查询用户信息
     */
    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User result = mapper.getUserById(1);
        System.out.println(result);
    }

    /**
     * 查询所有的用户信息
     */
    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);
    }

    /**
     * 查询用户信息的总记录数
     */
    @Test
    public void testGetCount() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    /**
     * 根据id查询用户信息为一个map集合
     */
    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(1);
        System.out.println(map);
    }

    /**
     * 查询所有用户信息为map集合
     */
    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());
        /*for (Map<String, Object> stringObjectMap : mapper.getAllUserToMap()) {
            System.out.println(stringObjectMap);
        }*/
    }
}