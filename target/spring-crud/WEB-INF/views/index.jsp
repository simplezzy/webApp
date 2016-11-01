<%--
  Created by IntelliJ IDEA.
  User: Erichou
  Date: 9/27/16
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Index</title>
    <script type="text/javascript" src="/scripts/jquery-3.1.1.min.js"></script>
    <script>
        $(function () {
            $("#testJson").click(function () {
                alert("Hello!");
                var url = this.href;
                var args = {};
                $.post(url, args, function (data) {
                    for(var i = 0; i < data.length; i++){
                        var id = data[i].id;
                        var lastName = data[i].lastName;

                        alert("id:"+id + "  lastName:" + lastName);
                    }
                });

                return false;
            });
        })
    </script>
</head>
<body>

  <strong>Spring MVC Config Testing!</strong>


  <br/>
  <br/>
  <a href="/springdemo/emps">springdemo list dispaly</a>
  <br/>
  <br/>
  <a href="/springdemo/testJson" id="testJson">springdemo testJson</a>
  <br/>
  <br/>
  <h3>Springdemo httpMessageConverter</h3><br/>
  <form action="/springdemo/testHttpMessageConveter" method="post" enctype="multipart/form-data">
      File:<input type="file" name="file"/>
      Desc:<input type="text" name="desc"/>
      <input type="submit" value="Submit"/>
  </form>
  <br/>
  <a href="/springdemo/testResponseEntity">springdemoResponseEntity</a>
  <br/>
  <form action="/springdemo/testFileUpload" method="post" enctype="multipart/form-data">
      File: <input type="file" name="file"/>
      Desc: <input type="text" name="desc"/>
      <input type="submit" value="upload"/>
  </form>
  <br/>
  <a href="/springdemo/testExceptionHandlerExceptionResolver?i=10">Exception Handler</a>

</body>
</html>
