<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bank.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <Title>Transaction</Title>
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
        <div class="container text-center" style="width: 50%; border: 2px solid grey; height: 0%; margin-top: 5px;">
	        <form action="trans/${account.accountId}" method="GET">
	            <div class="row">
	                <div class="col">
	                    <p id="total">${account.total}</p>
	                </div>
	                <div class="col">
	                    <input style="margin-top: 5px;" class="form-control validation" type="number" placeholder="Amount" name="amount" onkeyup="numValid(this.value)" required>
	                </div>
	                <div class="col">
	                    <input style="margin-top: 5px;" class="form-control validation" type="text" placeholder="Enter description" name="description" required>
	                </div>
	                <div class="col">
	                	<input style="margin-top: 5px;" class="form-control validation" type="text" placeholder="Enter Type" name="type" required>
	                </div>
	            </div>
		        <div class="text-center">
		            <button type="submit" id="deposit" name="deposit" class="btn btn-primary" style="margin-top: 5px; margin-bottom: 5px;">Deposit</button>
		            <button type="submit" id="withdrawal" name="withdrawal" class="btn btn-primary" style="margin-top: 5px; margin-bottom: 5px;">Withdrawal</button>
		        </div>
	        </form>
        </div>
        <div id="error" style="color: red; text-align: center"></div>
        <div class="text-center">
            <a href="/Bank/ViewAccount/${user.username}">
                <button type="button" class="btn btn-primary" style="margin-top: 5px;">Go Back</button>
            </a>
        </div>
    </body>
    <script type="text/javascript">
    var num = document.getElementById("total").innerHTML;
    var deposit = document.getElementById("deposit");
    var withdrawal = document.getElementById("withdrawal");
    num = parseInt(num);
    function numValid(amount){
    	if(amount == 0){
    		document.getElementById("error").innerHTML = "Amount can't be zero";
    		deposit.disabled = true;
    		withdrawal.disabled = true;
    	} else if(amount < 0){
    		document.getElementById("error").innerHTML = "Amount must be greater than zero";
    		deposit.disabled = true;
    		withdrawal.disabled = true;
    	} else if(amount > num){
    		document.getElementById("error").innerHTML = "You can't take more than what you have.";
    		withdrawal.disabled = true;
    		deposit.disabled = false;
    	}else{
    		document.getElementById("error").innerHTML = "";
    		deposit.disabled = false;
    		withdrawal.disabled = false;
    	}
    }
    </script>
</html>