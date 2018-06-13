<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018-3-17
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>文件上传</title>
  </head>
  <body>
      <form action="${pageContext.request.contextPath}/fileUpload" enctype="multipart/form-data" method="post">
        用户名:<input type="text" name = "username">
        用户头像：<input type="file" name="filename">
        <input type="submit" value="提交"/>
      </form>
  </body>
</html>
