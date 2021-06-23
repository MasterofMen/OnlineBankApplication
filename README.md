# OnlineBankApplication
A Full-Stack Online Banking Application

How to run Application:                                                                       
Create database called bank                                                                             
Run the BankSQL.sql files to create the tables                                                              
Make sure to put your username and password for your database in the application.properties file                                                  
Run the BankApplication.java file as a Java Application or Spring Boot app                                                                                
Username: test
Password: 1!Test

User Stories:
1. A page where the user can log in
2. A page wher the user can create an account
3. A page where the user can view their profile
4. A page where a user can make a transaction
5. A page where the user can see their past transactions
6. Add color to the pages
7. Password must contain Aa!1
8. User can only update one property at a time
9. User must input valid quantities for transaction
10. Data entered by user must be stored and retrieved from a database
11. Ensure user passwords are protected by BCrypt
12. Make sure user information is displayed correctly on the page
13. Make sure new information inputed by the user is stored in the database

Technical Challenges                                                                                                                
Problem: Designing the pages, deciding how each page should look                            
Solution: Checked out some Banks websites and based mine off theirs

Problem: Deciding what entities are needed for the bank application                                     
Solution: Looked up what information was displayed on a bank application and what information what required to create a bank application
Then put them in groups and created tables based off those groups

Problem: Getting the update function to work on the Profile page                                              
Solution: Used @ModelAttribute for updating and then checked which properties weren't null and then updated that property

Problem: Getting the date for past transactions to appear without the time                                                  
Solution: Used SimpleDateFormat to make it appear correctly

