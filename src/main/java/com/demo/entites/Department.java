package com.demo.entites;

/**
 * Created by Erichou on 9/27/16.
 */
public class Department {

    private Integer id;

    private String departmentName;

    public Department(){ }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(Integer id, String departmentName){
        this.id = id;
        this.departmentName = departmentName;
    }

    @Override
    public String toString(){
        return "Department [id=" + id + ", departmentName=" + departmentName
                + "]";
    }


}
