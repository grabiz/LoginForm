<%-- 
    Document   : login
    Created on : Mar 3, 2017, 2:52:12 PM
    Author     : Nguyen Euler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <% if(session !=null) 
        {
            if(session.getAttribute("remember") !=null)
            {
                getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
            }
        } 
        %>
        <form id="form6" action="login" method="post" style="height:447px;width: 528px;">
            <h1 style="padding-left: 200px;padding-top:60px;">Login</h1>
            <input type="text" name="username" placeholder="Username" style="margin-left: 20px;background: transparent;height:30px;width:450px;border: solid 1px rgb(190,193,198);"><p></p>
            <input type="password" name="password" placeholder="Password" style="margin-left: 20px;background: transparent;height:30px;width:450px;border: solid 1px rgb(190,193,198);"><p></p>
            <input type="checkbox"  name="remember"  style="margin-left: 20px;"> Remember me <p></p>
            <input type="submit" value="LOGIN" style="margin-left: 20px;height:40px;background-color: rgb(3,169,245);color:white;width:90px;"><span style="color:rgb(3,169,245);padding-left: 50px;">Forgot Password?</span>
        </form>
    </body>
</html>
