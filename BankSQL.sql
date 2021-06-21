 
 CREATE TABLE USER(
 	id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 	first_name VARCHAR(20) NOT NULL,
 	last_name VARCHAR(20) NOT NULL,
 	email VARCHAR(20) NOT NULL,
 	sso VARCHAR(20) NOT NULL,
 	username VARCHAR(20) NOT NULL,
 	PASSWORD VARCHAR(20) NOT NULL
 );
 CREATE TABLE ACCOUNT(
 	account_id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 	account_type VARCHAR(20) NOT NULL,
 	card_number varchar(20) NOT NULL,
 	total INT(20) NOT NULL,
 	user_id INT(20) NOT NULL,
 	FOREIGN KEY(user_id) references USER(id)
 );
 CREATE TABLE TRANSACTION(
 	transaction_id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	amount INT(20),
	trans_date DATE,
	TYPE VARCHAR(20),
	balance INT(20),
	description VARCHAR(20),
	account_id INT(20),
	FOREIGN KEY(account_id) references ACCOUNT(account_id)
 );