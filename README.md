# OnlineBankApplication
A Full-Stack Online Banking Application

How to run Application:
Create database called bank
Run the BankSQL.sql files to create the tables
Make sure to put your username and password for your database in the application.properties file
Run the BankApplication.java file as a Java Application or Spring Boot app

User Stories:
1. Create a html Log In page
2. Create a html Create Account page
3. Create a html View Profile page
4. Create a html Transaction page
5. Create a html Past Transactions page
6. Create Css page and add inline css to pages as needed
7. Add javascript to Create Account page for password
8. Add javascript to Profile page to make it so User can only change one property at a time
9. Add javascript to transaction page to ensure user inputs valid amounts
10. Convert Html pages to .jsp pages
11. Create SQL Tables(Entities) for bank application
12. Create Spring Boot Bank Application
13. Create DTO classes that match up to the SQL tables
14. Create the DAO interfaces for the Entities
15. Create Transaction, Account and User Services
16. Create a controller for viewing the pages
17. Create a controller to add functionality to the pages
18. Connect to database through application.properties file and have spring boot read .jsp files
19. Create a method for each .jsp page in the ViewController page
20. Add methods to UserController that add functionality to the pages and add required html to .jsp pages
21. Create testing methods for each dao method used
22. Add exception handling
23. Add BCrypt to password and update login validation
24. Information displayed on the pages is taken from the database
25. Information entered into the pages is stored in the database

Technical Challenges
Problem: Designing the pages, deciding how each page should look                            
Solution: Checked out some Banks websites and based mine off theirs

Problem: Deciding what entities are needed for the bank application                                     
Solution: Looked up what information was displayed on a bank application and what information what required to create a bank application
Then put them in groups and created tables based off those groups

Problem: Getting the update function to work on the Profile page                                              
Solution: Used @ModelAttribute for updating and then checked which properties weren't null and then updated that property

