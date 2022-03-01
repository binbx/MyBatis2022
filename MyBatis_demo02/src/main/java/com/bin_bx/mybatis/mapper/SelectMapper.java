package com.bin_bx.mybatis.mapper;

import com.bin_bx.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description: MyBatis的各种查询功能：1.查询一个实体类对象  2.查询一个list集合
 * @ClassName: SelectMapper
 * @Author: bxie
 * @Date: 2022/2/28 15:21
 * @Version:
 */
public interface SelectMapper {

    /**
     * 根据id查询用户信息
     */
    User getUserById(@Param("id") Integer id);
    //List<User> getUserById(@Param("id") Integer id); //也可以用集合来查

    /**
     * 查询所有的用户信息
     */
    List<User> getAllUser();

    /**
     * 查询用户信息的总记录数
     */
    Integer getCount();

    /**
     * 根据id查询用户信息为一个map集合
     */
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询所有用户信息为map集合
     */
    //List<Map<String, Object>> getAllUserToMap();
    @MapKey("id")
    Map<String, Object> getAllUserToMap();
}
