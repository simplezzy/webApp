<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Erichou
  Date: 9/28/16
  Time: 08:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>input page</title>
</head>
<body>

    <%--define Converter from String to Employee--%>
    <%--GG-gg@atguigu.com-0-105--%>
    <c:if test="${employee.id == null}">
        <br/> <br/>
    <form action="/springdemo/testConverter" method="POST">
        Employee Add: <input type="text" name="employee"/>
                      <input type="submit" value="Submit"/>
    </form>
        <br/> <br/>
    </c:if>


    <form:form action="/springdemo/emp" method="post" modelAttribute="employee">

        <c:if test="${employee.id == null}">
            LastName: <form:input path="lastName"/>
            <form:errors path="lastName"></form:errors>
        </c:if>

        <c:if test="${employee.id != null}">
            <form:hidden path="id"></form:hidden>
            <input type="hidden" name="_method" value="PUT">
        </c:if>

        <br/>
        Email:<form:input path="email"/>
        <form:errors path="email"></form:errors>
        <br/>
        <%
            Map<String,String> genders = new HashMap();
            genders.put("1","Male");
            genders.put("0","Femaile");

            request.setAttribute("genders",genders);
        %>
        Gender:<br/>
        <form:radiobuttons path="gender" items="${genders}" delimiter="<br>"/>

        <br/>
        Department: <form:select path="department.id"
                                 items="${departments}" itemLabel="departmentName" itemValue="id"></form:select>
        <br/>
        Birth:<form:input path="birth"/>
        <form:errors path="birth"></form:errors>
        <br/>
        Salary:<form:input path="salary"/>

        <br/>
        <c:if test="${employee.id == null}">
            <input type="submit" value="add"/>
        </c:if>
        <c:if test="${employee.id != null}">
            <input type="submit" value="update">
        </c:if>
    </form:form>

</body>
</html>
