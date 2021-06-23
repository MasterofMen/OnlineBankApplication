<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bank.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <Title>Account Activity</Title>
    </head>
    <body>
        <div class="jumbotron text-left" style="background-color: green; height: 80px; padding-top: 10px; padding-left: 20px;">
            <h1 style="color: white;"><i class="fa fa-black-tie" aria-hidden="true";></i>My Bank
                <div class="dropdown">
                    <button class="dropbtn">    
                    <i class="fa fa-user" id="profile" aria-hidden="true"></i></button>
                    <div class="dropdown-content">  
                        <a href="/Bank/profile/${user.username}">Profile</a>
                        <a href="/Bank/login">Log Out</a>
                    </div>
                </div>
            </h1>
        </div>
        <h2 style="text-align: center; padding-bottom: 15px;">Past Transactions</h2>
        <div class="container" style="width: 80%; border-radius: 0%;  height: 100%;">
            <div class="row" style="text-align: center; border: 1px solid grey;">
                <div class="col">
                    <p>Date</p>
                </div>
                <div class="col">
                    <p>Type</p>
                </div>
                <div class="col">
                    <p>Description</p>
                </div>
                <div class="col">
                    <p>Amount</p>
                </div>
                <div class="col">
                    <p>Balance</p>
                </div>
            </div>
            <c:forEach items="${trans}" var="tran">
            <div class="row" style="text-align: center; border: 1px solid grey;">
                <div class="col">
                    <p>${format.format(tran.transDate)}</p>
                </div>
                <div class="col">
                    <p>${tran.type}</p>
                </div>
                <div class="col">
                    <p>${tran.description}</p>
                </div>
                <div class="col">
                    <p>${tran.amount}</p>
                </div>
                <div class="col">
                    <p>$${tran.balance}</p>
                </div>
            </div>
            </c:forEach>
        </div>
        <div class="text-center">
            <a href="/Bank/ViewAccount/${user.username}">
                <button type="button" class="btn btn-primary" style="margin-top: 5px;">Go Back</button>
            </a>
        </div>
    </body>
 </html>