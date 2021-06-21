<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bank.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <Title>Create Account</Title>
    </head>
    <body>
        <div class="jumbotron text-left" style="background-color: green; height: 80px; padding-top: 10px; padding-left: 20px;">
            <h1 style="color: white;"><i class="fa fa-black-tie" aria-hidden="true";></i>My Bank</h1>
        </div>
        <div class="container" style="width: 60%; height: 60%;">
            <h2 style="text-align: center;">Create Account</h2>
            <div class="login" style="height: 80%;">
                <form action="create" method="POST">
                    <div class="form-group">
                        <div class="row">
                            <div class="col">
                                <label>First Name</label>
                                <input type="text" class="form-control validation" placeholder="Enter first name" name="firstname" minlength=4 required>
                            </div>
                            <div class="col">
                                <label>Last Name</label>
                                <input type="text" class="form-control validation" placeholder="Enter last name" name="lastname" minlength=4 required>
                            </div>
                        </div>
                        <label>Email Address</label>
                        <input type="email" class="form-control validation" placeholder="Enter email" name="email" required>

                        <h2 style="text-align: center;">Personal Account Information</h2>
                        <label>Account type</label>
                        <select name="type" style="padding: 5px; font-size: 15px;">
                            <option value="Checking">Checking</option>
                            <option value="Savings">Savings</option>
                        </select>
                        <br>
                        <label>ATM card or debit card number</label>
                        <input type="text" class="form-control validation" placeholder="Enter card number" name="cardNumber" minlength=16 required>
                        
                        <label>Social Security number</label>
                        <input type="text" class="form-control validation" placeholder="Enter SSN" name="SSN" minlength=9 required>

                        <h2 style="text-align: center;">User Name and Password</h2>
                        <div class="row">
                            <div class="col">
                                <label>Create your user name</label>
                                <input type="text" id="origUser" class="form-control validation" placeholder="Enter user name" name="username" minlength=4 required>
                            </div>
                            <div class="col">
                                <label>Re-enter User Name</label>
                                <input type="text" id="copyUser" class="form-control validation" onkeyup="sameUsername(this.value)" placeholder="Re-enter user name" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <label>Create password</label>
                                <input type="password" id="passwordStrength" class="form-control validation" onkeyup="checkPassword(this.value)" placeholder="Enter password" name="password" required>
                            	<p style="font-size: 10px; text-align: center">Must have capital letter, lowercase, symbol and number</p>
                            </div>
                            <div class="col">
                                <label>Re-enter password</label>
                                <input type="password" id="copyPass" class="form-control validation" onkeyup="samePassword(this.value)" placeholder="Re-enter password" required>
                            </div>
                        </div>
                        <div class="text-center">
                            <a href="login">
                                <button type="button" name="Cancel" class="btn btn-primary">Cancel</button>
                            </a>
                            <button type="submit" id="button" name="Login" class="btn btn-primary">Create Account</button>
                            <div style="color:red; text-align:center">${exists}</div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
    <script type="text/javascript">
        function checkPassword(password){
            var button = document.getElementById("button");
            var strength = document.getElementById("passwordStrength");
            var regex = new Array();
            regex.push("[A-Z]");
            regex.push("[a-z]"); 
            regex.push("[0-9]"); 
            regex.push("[$@$!%*#?&]");
    
            var passed = 0;
            //validate for regulat expression
            for(var i = 0; i<regex.length; i++){
                if(new RegExp(regex[i]).test(password)){
                    passed++;
                }
            }
            if(passed >= 4){
                strength.style.borderBottomColor = "green";
                button.disabled = false;
            }else{
                button.disabled = true;
                strength.style.borderBottomColor = "red";
            }
        }
        function sameUsername(username){
            var name = document.getElementById("origUser");
            var copy = document.getElementById("copyUser");
            if(name.value != username){
                copy.style.borderBottomColor = "red";
                button.disabled = true;
            }else{
                button.disabled = false;
                copy.style.borderBottomColor = "green";
            }
        }
        function samePassword(password){
            var pass = document.getElementById("passwordStrength").value;
            var copyPass = document.getElementById("copyPass");
            console.log(pass);
            if(password != pass){
                copyPass.style.borderBottomColor = "red";
                button.disabled = true;
            }else{
                button.disabled = false;
                copyPass.style.borderBottomColor = "green";
            }
        }
        </script>
</html>