<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bank.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <Title>Your Profile</Title>
    </head>
    <body>
        <div class="container" style="margin-top: 5%; width: 50%; height: 400px;">
            <div class="text-center">
            <form action="change/${User.id}" method="POST">
                <i class="fa fa-user fa-5x" aria-hidden="true" style="margin-top: -15%;"></i>
                <div class="row" style="margin-top: 4%;">
                    <div class="col"><h3>Name</h3></div>
                    <div class="col" id="name"><h5>${User.firstName} ${User.lastName}</h5></div>
                    <div class="col" id="nameButton"><i onclick="changeName()" class="fa fa-pencil-square-o" aria-hidden="true"></i></div>
                </div>
                <div class="row">
                    <div class="col"><h3>Email Address</h3></div>
                    <div class="col" id="email"><h5>${User.email}</h5></div>
                    <div class="col" id="emailButton"><i onclick="changeEmail()" class="fa fa-pencil-square-o" aria-hidden="true"></i></div>
                </div>
                <div class="row">
                    <div class="col"><h3>User name</h3></div>
                    <div class="col" id="username"><h5>${User.username}</h5></div>
                    <div class="col" id="userButton"><i onclick="changeUser()" class="fa fa-pencil-square-o" aria-hidden="true"></i></div>
                </div>
                <div class="row">
                    <div class="col"><h3>Password</h3></div>
                    <div class="col" id="password"><h5>********</h5></div>
                    <div class="col" id="passButton"><i onclick="changePass()" class="fa fa-pencil-square-o" aria-hidden="true"></i></div>
                </div>
                <div class="row">
                    <div class="col"><h3>SSN</h3></div>
                    <div class="col"><h5>***-**-${User.sso.substring(5,9)}</h5></div>
                    <div class="col"></div>
                </div>
                <a href="/Bank/ViewAccount/${User.username}"><button type="button" class="btn btn-primary">Your Page</button></a>
                <a href="/Bank/login"><button type="button" class="btn btn-primary">Log Out</button></a>
            </form>
            </div>
        </div>
    </body>
    <script type="text/javascript">
    var change = false;
    function changeName(){
    	console.log("Change Name");
    	if(!change){
    		change = true;
	    	document.getElementById("name").innerHTML = "<div class='col'><input type='text' name='firstName' value='${User.firstName} ${User.lastName}'></div><div class='col'></div>";
	    	document.getElementById("nameButton").innerHTML = "<div class='col'><input type='button' onclick='cancelName()' value='Cancel'><input type='submit' value='Submit'></div>";
    	}
    }
    function cancelName(){
    	console.log('Cancel Change');
    	document.getElementById("name").innerHTML = "<h5>${User.firstName} ${User.lastName}</h5>";
    	document.getElementById("nameButton").innerHTML = "<i onclick='changeName()' class='fa fa-pencil-square-o' aria-hidden='true'></i>";
    	change = false;
    }
    function changeEmail(){
    	console.log("Change Email");
    	if(!change){
    		change = true;
	    	document.getElementById("email").innerHTML = "<div class='col'><input type='text' name='email' value='${User.email}'></div><div class='col'></div>";
	    	document.getElementById("emailButton").innerHTML = "<div class='col'><input type='button' onclick='cancelEmail()' value='Cancel'><input type='submit' value='Submit'></div>";
    	}
    }
    function cancelEmail(){
    	console.log('Cancel Change');
    	document.getElementById("email").innerHTML = "<h5>${User.email}</h5>";
    	document.getElementById("emailButton").innerHTML = "<i onclick='changeEmail()' class='fa fa-pencil-square-o' aria-hidden='true'></i>";
    	change = false;
    }
    function changeUser(){
    	console.log("Change Username");
    	if(!change){
    		change = true;
	    	document.getElementById("username").innerHTML = "<div class='col'><input type='text' name='username' value='${User.username}'></div><div class='col'></div>";
	    	document.getElementById("userButton").innerHTML = "<div class='col'><input type='button' onclick='cancelUser()' value='Cancel'><input type='submit' value='Submit'></div>";
    	}
    }
    function cancelUser(){
    	console.log('Cancel Change');
    	document.getElementById("username").innerHTML = "<h5>${User.username}</h5>";
    	document.getElementById("userButton").innerHTML = "<i onclick='changeUser()' class='fa fa-pencil-square-o' aria-hidden='true'></i>";
    	change = false;
    }
    function changePass(){
    	console.log("Change Password");
    	if(!change){
    		change = true;
	    	document.getElementById("password").innerHTML = "<div class='col'><input type='text' name='password' value='Enter new password'></div><div class='col'></div>";
	    	document.getElementById("passButton").innerHTML = "<div class='col'><input type='button' onclick='cancelPass()' value='Cancel'><input type='button' value='Submit'></div>"
    	}
    }
    function cancelPass(){
    	console.log('Cancel Change');
    	document.getElementById("password").innerHTML = "<h5>********</h5>";
    	document.getElementById("passButton").innerHTML = "<i onclick='changePass()' class='fa fa-pencil-square-o' aria-hidden='true'></i>"
    	change = false;
    }
    </script>
</html>