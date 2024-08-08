User Documentation
Explanation of the Application
This application is for SpinTop Records, which is a Java console-based E-Commerce platform.  This program simulates an online marketplace where users can register as buyers, sellers, or admins. Buyers can browse and search for vinyl records, sellers can list and manage their vinyl records, and admins can manage users and oversee the entire platform. The application uses a PostgreSQL database to store and manage user and product information securely.

Explanation of all the Classes and their Working
1.  User 
- Description: This is the base class for all types of users (buyers, sellers, and admins).
- Attributes:  username, password, email, role 
- Methods:
  -  register (): Registers a new user.
  -  login (): Verify a user based on username and password.

2.  Buyer (inherits from User)
- Description: Is a buyer.
- Methods:
  -  browseProducts (): Allows buyers to browse the database.
  -  searchProduct (): Allows buyers to search in the database.
   - viewProductDetails (): Allows sellers to view their listed products.

3.  Seller (inherits from User)
- Description: Is a seller.
- Attributes:  products
- Methods:
  -  addProduct (): Allows sellers to add a new product.
  -  updateProduct (): Allows sellers to update an existing product.
  -  deleteProduct (): Allows sellers to delete a product.
  -  listProducts (): Allows sellers to view their listed products.

 4.  Admin (inherits from User)
- Description: Is an admin.
- Methods:
  -  viewAllUsers (): Allows admins to view all registered users.
  -  deleteUser (): Allows admins to delete a user.
  -  viewAllProducts (): Allows admins to view all products in the system.



5.  UserDAO 
- Description: Data Access Object used to handle CRUD operations for users.
- Methods:
  -  registerUser (): Inserts a new user into the database.
  - authenticateUser (): Verifies the user from the database.
  -  getAllUsers (): Retrieves all users from the database
  -  deleteUser (): Deletes a user from the database.

6.  UserService 
- Description: Provides services for user registration and authentication.
- Methods:
  -  registerUser (): Handles user registration.
  -  authenticateUser (): Handles user authentication.
  -  getAllUsers (): Retrieves all users from the database
  -  deleteUser(): Deletes a user from the database.

7.  Product 
- Description: Represents a product in the database.
- Attributes:  product, name, price, quantity, sellerId 
- Methods:
  -  updateDetails (): Updates product information.

8.  ProductDAO 
- Description: Data Access Object used to handle CRUD operations for users.
- Methods:
  -  createProduct (): Inserts a new product into the database.
  - getProduct (): Gets a product from the database.
  -  getProductBySeller (): Gets a product by the sellerId.
  -  getAllProducts (): Gets all products.
  -  updateProduct (): Updates an existing product in the database.
  -  deleteProduct (): Deletes a product from the database.

9.  ProductService 
- Description: Provides services for product management.
- Methods:
  -  addProduct (): Adds a new product.
  -  viewProduct ():  Views product information 
  -  listSellerProducts (): Lists products by seller.
  -  listAllProducts (): Lists all products.
  -  modifyProduct (): Updates an existing product.
  -  deleteProduct (): Deleting a product.

10.  Database Connection 
- Description: Connects the database to the program.
- Methods:
  -  getConnection (): Get connection.
11.  BCrpyt 
- Description: Checks and changes the password.
- Methods:
  -  hashpassword (): Changes the password.
  - checkpassword (): Checks the user password.





Steps to Start the Application
Click to the Repository:  You can find the repository on GitHub.com.
Copy the Repository URL: Look for the "Clone" button on the repository page. Click on it to reveal the repository's URL. 
Clone the Repository: Use the git clone command followed by the URL you copied earlier. 
Set Up the Database: Run the provided SQL scripts in the “database” folder to create and populate the necessary tables.
Compile the Project:
In VSC, we built the project to compile the source code. 
Run the Application: Locate the main class (e.g. Main.java) and run the main class to start the application. 
Interact with the Application: The application will start in the console. Follow the on-screen prompts to register, log in, and perform various actions based on your role (buyer, seller, or admin).



Deployment Documentation

Installation Manual
This document provides a step-by-step guide to install, configure, and run the Java Console-Based E-Commerce Platform.

Prerequisites

Before you begin, ensure you have the following installed on your machine:

Java Development Kit (JDK): You can download it from:
 		[Oracle JDK Downloads (https://www.oracle.com/java/technologies/javase-downloads.html).

 PostgreSQL Database: Ensure you have PostgreSQL installed and running. You can download it from:
 		[PostgreSQL Downloads] (https://www.postgresql.org/download/).

Git: Ensure you have Git installed for version control.  You can download it from:
 		[Git Downloads] (https://git-scm.com/downloads).

IDE: Any preferred Java IDE (our preference is VS Code)

Step-by-Step Installation Guide

Clone the Repository
Open your terminal or command prompt.
Clone the repository using Git:
git clone <https://github.com/kellystoyles68/JavaFinalSprint.git>

Navigate to the project directory:
cd <project_directory>

Set Up the PostgreSQL Database
- Create a Database:
   	- Open the PostgreSQL command-line interface (psql) or use a GUI tool like pgAdmin.
   	- Create a new database:
CREATE DATABASE ecommerce_db;

       4. Run SQL Scripts:
   	- In the project directory, locate the  `database`  folder containing SQL scripts.
   	- Execute the provided SQL scripts to create and populate the necessary tables:
psql -U <your_username> -d ecommerce_db -f database/schema.sql
psql -U <your_username> -d ecommerce_db -f database/data.sql

      5. Configure Database Connection
- Open the project in your preferred Java IDE.
- Locate the database configuration file 
 

-Update the database URL, username, and password to match your PostgreSQL setup. 
db.url=jdbc:postgresql://localhost:5432/ecommerce_db
db.username=your_username
db.password=your_password

Build the Project -In your IDE, build the project to compile the source code. This step may vary depending on your IDE:
-IntelliJ IDEA: Use the "Build" menu and select "Build Project".
- Eclipse: Use the "Project" menu and select "Build All".
- VS Code: Use the terminal to run:
javac -d bin src/**/*.java

Run the Application
-In your IDE, locate the main class (e.g.,  `Main.java` ).
-Run the main class to start the application. This step may vary depending on your IDE:
IntelliJ IDEA: Right-click the main class and select "Run".
Eclipse Right-click the main class and select "Run As" > "Java Application".
VS Code: Use the terminal to run:  java -cp bin Main

Interact with the Application
-The application will start in the console.
-Follow the on-screen prompts to register, log in, and perform various actions based on your role (buyer, seller, or admin).


Troubleshooting

        1.Database Connection Issues:
  - Ensure your PostgreSQL server is running.
  - Verify the database URL, username, and password in the configuration file.

        2.Compilation Errors:
  - Ensure all dependencies are correctly set up in your IDE.
  - Check for any missing or incorrect import statements.

       3.Runtime Errors:
  - Review the console output for error messages.
  - Ensure all required tables and data are present in the database.

Additional Notes

- Make sure to periodically pull updates from the repository to stay up-to-date with any changes or bug fixes.
- If you encounter any issues that you cannot resolve, refer to the project documentation.

By following these steps, you should be able to successfully install, configure, and run our Java Console-Based E-Commerce Platform.


Development Documentation

This document explains how to work on the project, including details about the code, how to build it, and set up your computer for development.

Table of Contents
1. Javadocs
2. Source Code Directory Structure
3. Build Process
4. Compiler Time Dependencies
5. Development Standards
6. Database Setup for Development
7. Retrieving Source Code from the Repository

1. Javadocs

Javadocs are automatically generated documentation from the source code comments. They provide detailed descriptions of classes, methods, and fields.

To generate Javadocs:
javadoc -d docs $(find src -name "*.java")
The generated documentation will be located in the “docs” directory.

2. Source Code Directory Structure

The source code is organized in the following structure:
project-root/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── project/
│   │   │               ├── MainClass.java
│   │   │               └── utils/
│   │   │                   └── Helper.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── project/
│                       ├── MainClassTest.java
│                       └── utils/
│                           └── HelperTest.java
│
├── build/
│
├── docs/
│
├── lib/
└── README.md

3. Build Process
Prerequisites
- Java Development Kit (JDK) 8 or higher
- Apache Maven 3.6.0 or higher

Steps to Build
1. Open the project root directory:
cd project-root
2. Compile the project:
mvn clean compile
3. To package the project:
mvn package
The compiled and packaged files will be in the “target” directory.
4. Dependencies Needed to Compile
The project uses certain tools to work correctly. These are listed in a file called `pom.xml`.
5. Rules for Writing Code
When writing code, follow these rules:
- Style: Use the Google Java Style Guide.
- Version Control: Use Git and follow the Git Flow method.
- Testing: Always test your code with JUnit.
- Documentation: Explain all public parts of your code using Javadocs.
6. Setting Up the Database
Before you start, make sure you have a database like MySQL or PostgreSQL Steps to Set Up
1. Create a new database:
CREATE DATABASE project_db;
2. Set up the database structure:
mysql -u username -p project_db < schema.sql
3. Update the  `application.properties`  file with your database configuration:
properties
    spring.datasource.url=jdbc:mysql://localhost:3306/project_db
    spring.datasource.username=db_username
 	   spring.datasource.password=db_password
7. Getting the Code from GitHub
To get the code for your project, follow these steps:
1. Open your terminal and type:
git clone https://github.com/yourusername/yourproject.git
This will copy the project from GitHub to your computer.
2. Go into the project folder
cd yourproject
3. To get any new changes others have made, type:
	Git pull origin main


By following this guide, you can set up your computer for development, understand how the code is organized, build the project, and follow the rules for writing good code.
