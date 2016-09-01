<%--
  Created by IntelliJ IDEA.
  Model.User: marce
  Date: 1/9/2016
  Time: 9:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <% response.sendRedirect("homepage.html"); %>
  <p>
    Welkom <%= session.getAttribute("username") %>
  </p>
  <a href="login.html">Login Test</a>
  <a href="addroom.html">addroom Test</a>
  <a href="fouteinlog.html">fouteinlog Test</a>
  <a href="huurder.html">huurder Test</a>
  <a href="registreer.html">registreer Test</a>
  <form method="post" action="/index">
  <input type="submit">
    </form>
  </body>
</html>
