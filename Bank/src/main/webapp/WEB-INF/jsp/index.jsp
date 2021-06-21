<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import = " java.util.* " %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bank.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Bank</title>
    </head>
    <body>
        <div class="jumbotron text-left" style="background-color: green; height: 80px; padding-top: 10px; padding-left: 20px;">
            <h1 style="color: white;"><i class="fa fa-black-tie" aria-hidden="true";></i>My Bank
        </div>
        <h2 style="text-align: center; padding-bottom: 15px;">Welcome to Online Banking</h2>
        <div class="container">
            <form action="valid" method="GET">
                <div class="form-group">
                    <label>User name:</label>
                    <input type="text" name="username" class="form-control validation" placeholder="Enter Username" required>
                    <label>Password:</label>
                    <input type="password" name="password" class="form-control validation" placeholder="Enter password" required>
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">LOG IN</button>
                    </div>
                </div>
            </form>
            <a href="CreateAccount" style="color: green; font-size: 18px; margin-left: 75px;">Create Account</a>
        </div>
        <div style="color: red; text-align: center">${valid}</div>
    </body>
</html>