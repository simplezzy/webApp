package com.demo.controller;

import com.demo.dao.DepartmentDao;
import com.demo.dao.EmployeeDao;

import com.demo.entites.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by Erichou on 9/27/16.
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;


    @RequestMapping(value = "/springdemo/emps", method = RequestMethod.GET)
    public String list(Map<String,Object> map){
        map.put("employees",employeeDao.getAll());
        return "list";
    }

    @RequestMapping(value = "/springdemo/emp", method = RequestMethod.GET)
    public String input(Map<String,Object> map){
        map.put("departments",departmentDao.getDepartments());
        map.put("employee", new Employee());
        return "input";
    }

    @RequestMapping(value = "/springdemo/emp", method = RequestMethod.POST)
    public String save(@Valid Employee employee, BindingResult results, Map<String, Object> map){
        System.out.println("save:"+ employee);
        if(results.getErrorCount() > 0){
            System.out.println("Wrong!");
            for(FieldError error : results.getFieldErrors()){
                System.out.println(error.getField() + error.getDefaultMessage());
            }
            map.put("departments",departmentDao.getDepartments());
            return "input";
        }
        employeeDao.save(employee);
        return "redirect:/springdemo/emps";
    }

    @RequestMapping(value = "/springdemo/emp/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/springdemo/emps";
    }

    @RequestMapping(value = "/springdemo/emp/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Integer id, Map<String, Object> map){
        map.put("departments", departmentDao.getDepartments());
        map.put("employee", employeeDao.get(id));
        return "input";
    }

    @RequestMapping(value = "springdemo/emp", method = RequestMethod.PUT)
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/springdemo/emps";
    }

    @ModelAttribute
    public void getEmployee(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map){
        if(id != null){
            map.put("employee", employeeDao.get(id));
        }
    }

}
