package com.bin_bx.mybatis.mapper;

import com.bin_bx.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description: //TODO
 * @ClassName: ParameterMapper
 * @Author: bxie
 * @Date: 2022/2/27 18:18
 * @Version:
 */
public interface ParameterMapper {

    /**
     * 查询所有的员工的信息
     * @return
     */
    List<User> getAllUser();

    /**
     * 根据用户名查询用户信息
     */
    User getUserByUsername(String username);

    /**
     * 验证登录
     */
    User checkLogin(String username, String password);

    /**
     * 验证登录（参数为map）
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 添加用户信息
     */
    int insertUser(User user);

    /**
     * 验证登录（使用@Param）
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);


}
