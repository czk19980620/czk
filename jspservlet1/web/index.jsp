<%--
  Created by IntelliJ IDEA.
  User: ChenZhiKang
  Date: 2018/8/14
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>文件提交</title>
  </head>
  <body>
  <div style="width: 200px; margin: 200px auto 0px;">
    <form method="post" action="Servlet1" enctype="multipart/form-data">
      <input type="file" name="file1" /><br /><br />
      <input type="submit" value="提交" />
      <input type="reset" value="重置" />
      <input type="hidden" name="method" value="uploadFiles">
    </form>
  </div>

  </body>
</html>
