package com.demo.utils;

import com.demo.dao.DepartmentDao;
import com.demo.entites.Department;
import com.demo.entites.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Erichou on 9/30/16.
 */
@Component
public class EmployeeConverter implements Converter<String, Employee> {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public Employee convert(String source) {
        if(source != null){
            String [] vars = source.split("-");
            if(vars != null && vars.length == 4){
                String lastName = vars[0];
                String email = vars[1];
                Integer gender = Integer.parseInt(vars[2]);

                Department department = departmentDao.getDepartment(Integer.parseInt(vars[3]));

                Employee employee = new Employee(null, lastName, email, gender ,department);
                return employee;
            }
        }

        return null;
    }
}
