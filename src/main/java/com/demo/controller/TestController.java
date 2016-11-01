package com.demo.controller;

import com.demo.dao.EmployeeDao;
import com.demo.entites.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Erichou on 10/10/16.
 */
@Controller
public class TestController {

    @Autowired
    public EmployeeDao employeeDao;

    @RequestMapping(value = "/springdemo/testConverter")
    public String testConversionService(@RequestParam(value = "employee") Employee employee){
        System.out.println("employee"+ employee);
        employeeDao.save(employee);
        return "redirect:/springdemo/emps";
    }

    @ResponseBody
    @RequestMapping(value = "/springdemo/testJson")
    public Collection <Employee> testJson(){
        return employeeDao.getAll();
    }

    @ResponseBody
    @RequestMapping(value = "/springdemo/testHttpMessageConveter")
    public String testHttpMessageConveter(@RequestBody String body){
        System.out.println(body);
        return "Hello!" + new Date();
    }


//    file download
    @RequestMapping(value = "springdemo/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws Exception{
        byte[] body = null;
        ServletContext servletContext = session.getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream("/files/test.txt");
        body = new byte[inputStream.available()];
        inputStream.read(body);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; fileName = text.txt");

        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return responseEntity;
    }

//    file upload
    @RequestMapping(value = "/springdemo/testFileUpload")
    public String testFileUpload(@RequestParam("desc") String desc,
                                 @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("desc:" + desc);
        System.out.print("file:" + file.getOriginalFilename() +"--" + file.getInputStream());
        return "success";
    }

    /**
     * 1.在@@ExceptionHandler 方法的入参中可以加入Exception类型的参数,该参数即发生对应的异常对象
     * 2.方法的入参中不能传入Map,若想把异常信息传到页面上,需要谁用ModerAndView作为返回值;
     * 3.方法标记的优先级问题
     * 4.在当前Handle中找不到 @ExceptionHandler标记的方法,则将在@@ControllerAdvice标记的类中查找@ExceptionHandler标记的方法
     * 进而处理异常,可以作为单独一个处理异常的类,可以处理全局异常.
     * */
//    @ExceptionHandler({ArithmeticException.class})
//    public ModelAndView handleArithmeticException(Exception ex){
//        System.out.println("Exception:" + ex);
//        ModelAndView mv = new ModelAndView("error");
//        mv.addObject("exception",ex);
//        return mv;
//    }

    @RequestMapping(value = "/springdemo/testExceptionHandlerExceptionResolver")
    public String testExceptionHandler(@RequestParam("i") int i){
        System.out.println("the result:" + (10 / i));
        return "success";
    }
}
