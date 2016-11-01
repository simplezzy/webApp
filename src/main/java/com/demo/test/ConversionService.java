package com.demo.test;

import com.demo.dao.EmployeeDao;
import com.demo.entites.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Erichou on 9/30/16.
 */

@Controller
public class ConversionService {

    @Autowired
    public EmployeeDao employeeDao;

    @RequestMapping(value = "/springdemo/testConverter")
    public String testConversionService(@RequestParam(value = "employee") Employee employee){
        System.out.println("employee"+ employee);
        employeeDao.save(employee);
        return "redirect:/springdemo/emps";
    }

    @RequestMapping(value = "springdemo/index", method = RequestMethod.GET)
    public String springIndex(){
        return "index";
    }
}
