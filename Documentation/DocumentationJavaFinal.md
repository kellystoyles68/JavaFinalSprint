

# Java Console-Based E-Commerce Platform Documentation

## Table of Contents
1. [User Documentation](#user-documentation)
    - Explanation of the Application
    - Explanation of all the Classes and their Working use
    - Steps to Start the Application
2. [Development Documentation](#development-documentation)
    - Source Code Directory Structure Description
3. [Deployment Documentation](#deployment-documentation)
    - Installation Manual
    - Step-by-Step Installation Guide

---

## User Documentation

### Explanation of the Application
This application is for general E-commerce use in a Java console-based platform. This program simulates an online marketplace where users can register as buyers, sellers, or admins. Buyers can browse and search products, sellers can list and manage products, and admins can manage users and oversee the entire platform. The application uses a PostgreSQL database to store and manage user and product information securely.

### Explanation of all the Classes and their Working use

1. **User**
    - **Description**: This is the base class for all types of users (buyers, sellers, and admins).
    - **Attributes**: `id`, `username`, `password`, `email`, `role`
    - **Methods**:
        - `getId()`: Gets the user ID.
        - `setId(int id)`: Sets the user ID.
        - `getUsername()`: Gets the username.
        - `setUsername(String username)`: Sets the username.
        - `getPassword()`: Gets the password.
        - `setPassword(String password)`: Sets the password.
        - `getEmail()`: Gets the email.
        - `setEmail(String email)`: Sets the email.
        - `getRole()`: Gets the role.
        - `setRole(String role)`: Sets the role.

2. **Buyer (inherits from User)**
    - **Description**: Represents a buyer user.
    - **Uses**:
        - Buyers can browse the database to see all available products.
        - Buyers can search in the database to find products of a specific name.
        - Buyers can view product details (id, name, price, quantity, and seller id).

3. **Seller (inherits from User)**
    - **Description**: Represents a seller user.
    - **Methods**:
        - Sellers Can add a new product with the values of (Name, Price, Quantity, and their seller id is added to the product).
        - Sellers can update an existing product and change the follwoing values (Name, Price, Quantity).
        - Sellers can delete a product.
        - Sellers can view their listed products.

4. **Admin (inherits from User)**
    - **Description**: Represents an admin user.
    - **Methods**:
        - Admins can view all registered users.
        - Admins can delete a user via the user id.
        - Admins can view all products in the system.

5. **UserDAO**
    - **Description**: Data Access Object used to handle CRUD operations for users.
    - **Methods**:
        - `addUser(User user)`: Inserts a new user into the database.
        - `getUserById(int id)`: Retrieves a user by their ID from the database.
        - `getUserByUsername(String username)`: Retrieves a user by their username from the database.
        - `getAllUsers()`: Retrieves all users from the database.
        - `updateUser(User user)`: Updates an existing user in the database.
        - `deleteUser(int id)`: Deletes a user from the database.

6. **UserService**
    - **Description**: Provides services for user registration and authentication.
    - **Methods**:
        - `registerUser(String username, String password, String email, String role)`: Handles user registration.
        - `loginUser(String username, String password)`: Handles user authentication.
        - `getUserById(int id)`: Retrieves a user by their ID.
        - `getAllUsers()`: Retrieves all users from the database.
        - `updateUser(User user)`: Updates an existing user.
        - `deleteUser(int id)`: Deletes a user from the database.

7. **Product**
    - **Description**: Represents a product in the database.
    - **Attributes**: `id`, `name`, `price`, `quantity`, `sellerId`, `sellerName`
    - **Methods**:
        - `getId()`: Gets the product ID.
        - `setId(int id)`: Sets the product ID.
        - `getName()`: Gets the product name.
        - `setName(String name)`: Sets the product name.
        - `getPrice()`: Gets the product price.
        - `setPrice(double price)`: Sets the product price.
        - `getQuantity()`: Gets the product quantity.
        - `setQuantity(int quantity)`: Sets the product quantity.
        - `getSellerId()`: Gets the seller ID.
        - `setSellerId(int sellerId)`: Sets the seller ID.
        - `getSellerName()`: Gets the seller name.
        - `setSellerName(String sellerName)`: Sets the seller name.

8. **ProductDAO**
    - **Description**: Data Access Object used to handle CRUD operations for products.
    - **Methods**:
        - `addProduct(Product product)`: Inserts a new product into the database.
        - `getProductById(int id)`: Retrieves a product by its ID from the database.
        - `getProductsByName(String name)`: Retrieves products by their name.
        - `getAllProducts()`: Retrieves all products from the database.
        - `getAllProductsWithSellerInfo()`: Retrieves all products with their seller information.
        - `updateProduct(Product product)`: Updates an existing product in the database.
        - `deleteProduct(int id)`: Deletes a product from the database.

9. **ProductService**
    - **Description**: Provides services for product management.
    - **Methods**:
        - `addProduct(String name, double price, int quantity, int sellerId)`: Adds a new product.
        - `getProductById(int id)`: Retrieves a product by its ID.
        - `getProductsByName(String name)`: Retrieves products by their name.
        - `getAllProducts()`: Retrieves all products from the database.
        - `getAllProductsWithSellerInfo()`: Retrieves all products with seller information.
        - `updateProduct(Product product)`: Updates an existing product.
        - `deleteProduct(int id)`: Deletes a product.

### Steps to Start the Application

1. **Clone the Repository**
    - Find the repository on GitHub.com. (https://github.com/kellystoyles68/JavaFinalSprint)
    - Copy the repository URL.
    - Use the `git clone` command followed by the URL you copied earlier.

2. **Set Up the Database**
    - Run the provided SQL scripts in the `database` folder to create and populate the necessary tables.

3. **Compile the Project**
    - In your IDE, build the project to compile the source code.

4. **Set up Enviroment Variables**
    - Depending on your OS/Terminal it will be different but add the respoctive commands to yuor terminal in the project root directory

    - Powershell (Windows): 
        - $env:DB_URL="jdbc:postgresql://localhost:5432/yourdbname"
        - $env:DB_USER="yourdbuser"
        - $env:DB_PASSWORD="yourdbpassword"

    - Command Prompt (Windows):
        - set DB_URL=jdbc:postgresql://localhost:5432/yourdbname
        - set DB_USER=yourdbuser
        - set DB_PASSWORD=yourdbpassword

    - Linux/MacOS:
        - export DB_URL="jdbc:postgresql://localhost:5432/yourdbname"
        - export DB_USER="yourdbuser"
        - export DB_PASSWORD="yourdbpassword"

5. **Compile & Run**
    - **Paste the following two commands in the same terminal as you enviroment variables**
    - javac -d Class-Run -cp "libs/jbcrypt-0.4.jar;libs/postgresql-42.7.3.jar" *.java
    - java -cp "Class-Run;libs/jbcrypt-0.4.jar;libs/postgresql-42.7.3.jar" Main

---

## Development Documentation

### Source Code Directory Structure
The source code is organized in the following structure:

```
JAVAFINALSPRINT/
│
├── User.java
├── Buyer.java
├── Seller.java
├── Admin.java
├── UserDAO.java
├── UserService.java
├── Product.java
├── ProductDAO.java
├── ProductService.java
├── Main.java
├── Class-Run/
│   └── FolderKeep.txt
├── database/
│   ├── create_table.sql
│   └── Cascade_Delete.sql
├── documentation/
│   ├── CLASS SYSTEMS DIAGRAM.pdf
│   ├── DocumentationJavaFinal.md
│   └── Development_Running.txt
├── libs/
│   ├── jbcrypt-0.4.jar
│   └── postgresql-42.7.3.jar
├── .gitignore
└── README.md
```

## Deployment Documentation

### Installation Manual
This document provides a step-by-step guide to install, configure, and run the Java Console-Based E-Commerce Platform.

### Prerequisites
Before you begin, ensure you have the following installed on your machine:
- Java Development Kit (JDK)
- PostgreSQL Database
- Git
- Any preferred Java IDE (our preference is VS Code)

### Step-by-Step Installation Guide
1. **Clone the Repository**
    - Open your terminal or command prompt.
    - Clone the repository using Git:
      ```sh
      git clone <https://github.com/kellystoyles68/JavaFinalSprint.git>
      ```

2. **Navigate to the project directory:**
    ```sh
    cd <JAVAFINALSPRINT>
    ```

3. **Set Up the PostgreSQL Database**
    - **Create a Database:**
        - Open the PostgreSQL command-line interface (psql) or use a GUI tool like pgAdmin.
        - Create a new database:
        CREATE TABLE Users (
            id SERIAL PRIMARY KEY,
            username VARCHAR(50) UNIQUE NOT NULL,
            password VARCHAR(255) NOT NULL,
            email VARCHAR(100) NOT NULL,
            role VARCHAR(20) NOT NULL
        );
        
        CREATE TABLE Products (
            id SERIAL PRIMARY KEY,
            name VARCHAR(100) NOT NULL,
            price DECIMAL(10, 2) NOT NULL,
            quantity INT NOT NULL,
            seller_id INT REFERENCES Users(id)
        );

4. **Set Up Enviroment Varriables**
    - Depending on your OS/Terminal it will be different but add the respoctive commands to yuor terminal in the project root directory

    - Powershell (Windows): 
        - $env:DB_URL="jdbc:postgresql://localhost:5432/yourdbname"
        - $env:DB_USER="yourdbuser"
        - $env:DB_PASSWORD="yourdbpassword"

    - Command Prompt (Windows):
        - set DB_URL=jdbc:postgresql://localhost:5432/yourdbname
        - set DB_USER=yourdbuser
        - set DB_PASSWORD=yourdbpassword

    - Linux/MacOS:
        - export DB_URL="jdbc:postgresql://localhost:5432/yourdbname"
        - export DB_USER="yourdbuser"
        - export DB_PASSWORD="yourdbpassword"

5. **Build the Project**
    - javac -d Class-Run -cp "libs/jbcrypt-0.4.jar;libs/postgresql-42.7.3.jar" *.java
    

6. **Run the Application**
    - java -cp "Class-Run;libs/jbcrypt-0.4.jar;libs/postgresql-42.7.3.jar" Main