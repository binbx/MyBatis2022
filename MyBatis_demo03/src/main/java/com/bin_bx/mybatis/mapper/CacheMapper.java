package com.bin_bx.mybatis.mapper;

import com.bin_bx.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * Author:bxie
 * Description: myBatis缓存
 * 缓存只对查询有效
 */
public interface CacheMapper {

    /**
     * 通过id查询
     * @param eid
     * @return
     */
    Emp getEmpByEid(@Param("eid") Integer eid);

    /**
     * 插入一条数据
     * @param emp
     */
    void insertEmp(Emp emp);

}
