<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bank.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <Title>Your Account</Title>
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
        <h2 style="text-align: center; padding-bottom: 15px;">Welcome to Your Page</h2>
        <div class="container" style="width: 80%; border-radius: 0%; border: 2px solid grey; height: 100%;">
            <div class="row" style="text-align: center; border-bottom: 2px solid grey;">
                <div class="col">
                    <p>Deposits</p>
                </div>
                <div class="col">
                    <p>Available Balance</p>
                </div>
                <div class="col">
                    <p>Total Transactions</p>
                </div>
            </div>
            <a href="/Bank/pastTrans/${account.accountId}" style="text-decoration: none; color:black;"><div class="row" id="account">
                <div class="col">
                    <p>Bank Convenience ${account.accountType} ></p>
                </div>
                <div class="col">
                    <p>$${account.total}</p>
                </div>
                <div class="col">
                    <p>$${tran}</p>
                </div>
            </div></a>
            <div class="row" style="text-align: center; background-color: rgb(199, 196, 196);">
                <div class="col">
                    <p>Total</p>
                </div>
                <div class="col">
                    <p>$${account.total}</p>
                </div>
                <div class="col"><p></p></div>
            </div>
        </div>
        <div class="text-center">
            <a href="/Bank/transaction/${account.accountId}">
                <button type="button" class="btn btn-primary" style="margin-top: 5px;">Deposit/Withdrawal</button>
            </a>
        </div>
    </body>
</html>