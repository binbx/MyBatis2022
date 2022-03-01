package com.bin_bx.mybatis.pojo;

import java.util.List;

/**
 * @Description: //TODO
 * @ClassName: Dept
 * @Author: bxie
 * @Date: 2022/2/28 17:47
 * @Version:
 */
public class Dept {

    private Integer did;
    private String deptName;

    private List<Emp> emps; //一对多


    public Dept() {
    }
    public Dept(Integer did, String deptName, List<Emp> emps) {
        this.did = did;
        this.deptName = deptName;
        this.emps = emps;
    }

    public Integer getDid() {
        return did;
    }
    public void setDid(Integer did) {
        this.did = did;
    }
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public List<Emp> getEmps() {
        return emps;
    }
    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                ", emps=" + emps +
                '}';
    }
}
