<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Erichou
  Date: 9/27/16
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>employees list</title>
    <script type="text/javascript" src="/scripts/jquery-3.1.1.min.js"></script>

    <script>
        $(function(){
            $(".delete").click(function(){
                var href = $(this).attr("href");
                $("form").attr("action", href).submit();
                return false;
            });
        })
    </script>
</head>
<body>

    <form action="" method="post">
        <input type="hidden" name="_method" value="DELETE"/>
    </form>

    <c:if test="${empty requestScope.employees}">
        No any emmployee information
    </c:if>

    <c:if test="${!empty requestScope.employees}">
        <table border="1" cellpadding="10" cellspacing="">
            <tr>
                <th>ID</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Department</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <c:forEach items="${requestScope.employees}" var="emp">
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.email}</td>
                    <td>${emp.gender == 0 ? 'Female' : 'Male'}</td>
                    <td>${emp.department.departmentName}</td>
                    <td><a href="emp/${emp.id}">Edit</a></td>
                    <td><a class="delete" href="emp/${emp.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <br/>
    <br/>
    <a href="/springdemo/emp">add new employee</a>

</body>
</html>
