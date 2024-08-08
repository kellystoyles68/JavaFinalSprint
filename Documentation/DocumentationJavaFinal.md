# Java Console-Based E-Commerce Platform Documentation

## Table of Contents
1. [User Documentation](#user-documentation)
    - Explanation of the Application
    - Explanation of all the Classes and their Working use
    - Steps to Start the Application
2. [Development Documentation](#development-documentation)
    - Javadocs
    - Source Code Directory Structure Description
    - Build Process
    - Compiler Time Dependencies
    - Development Standards
    - Database Setup for Development
    - Retrieving Source Code from the Repository
3. [Deployment Documentation](#deployment-documentation)
    - Installation Manual
    - Step-by-Step Installation Guide
    - Troubleshooting

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
        - `listProducts()`: Allows sellers to view their listed products.

4. **Admin (inherits from User)**
    - **Description**: Represents an admin user.
    - **Methods**:
        - `viewAllUsers()`: Allows admins to view all registered users.
        - `deleteUser(int id)`: Allows admins to delete a user.
        - `viewAllProducts()`: Allows admins to view all products in the system.

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
    - Find the repository on GitHub.com.
    - Copy the repository URL.
    - Use the `git clone` command followed by the URL you copied earlier.

2. **Set Up the Database**
    - Run the provided SQL scripts in the `database` folder to create and populate the necessary tables.

3. **Compile the Project**
    - In your IDE, build the project to compile the source code.

4. **Run the Application**
    - Locate the main class (e.g., `Main.java`) and run it to start the application.

5. **Interact with the Application**
    - The application will start in the console.
    - Follow the on-screen prompts to register, log in, and perform various actions based on your role (buyer, seller, or admin).

---

## Development Documentation

### Javadocs
Javadocs are automatically generated documentation from the source code comments. They provide detailed descriptions of classes, methods, and fields.

To generate Javadocs:
```sh
javadoc -d docs $(find src -name "*.java")
```
The generated documentation will be located in the `docs` directory.

### Source Code Directory Structure
The source code is organized in the following structure:

```
project-root/
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
├── database/
│   ├── schema.sql
│   └── data.sql
├── libs/
└── README.md
```

### Build Process
#### Prerequisites
- Java Development Kit (JDK) 8 or higher
- PostgreSQL Database
- Git for version control

#### Steps to Build
1. **Open the project root directory:**
    ```sh
    cd project-root
    ```

2. **Compile the project:**
    ```sh
    javac -cp "libs/*" *.java
    ```

### Compiler Time Dependencies
- JDK 8 or higher
- PostgreSQL JDBC Driver
- BCrypt library for password hashing

### Development Standards
- **Style**: Use the Google Java Style Guide.
- **Version Control**: Use Git and follow the Git Flow method.
- **Testing**: Always test your code with JUnit.
- **Documentation**: Explain all public parts of your code using Javadocs.

### Database Setup for Development
#### Prerequisites
- PostgreSQL installed and running

#### Steps to Set Up
1. **Create a new database:**
    ```sql
    CREATE DATABASE ecommerce

_db;
    ```

2. **Run SQL scripts to set up the database structure and initial data:**
    ```sh
    psql -U <your_username> -d ecommerce_db -f database/schema.sql
    psql -U <your_username> -d ecommerce_db -f database/data.sql
    ```

### Retrieving Source Code from the Repository
1. **Clone the repository:**
    ```sh
    git clone https://github.com/yourusername/yourproject.git
    ```

2. **Navigate to the project directory:**
    ```sh
    cd yourproject
    ```

3. **Pull updates from the repository:**
    ```sh
    git pull origin main
    ```

---

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
      git clone <https://github.com/yourusername/yourproject.git>
      ```

2. **Navigate to the project directory:**
    ```sh
    cd <project_directory>
    ```

3. **Set Up the PostgreSQL Database**
    - **Create a Database:**
        - Open the PostgreSQL command-line interface (psql) or use a GUI tool like pgAdmin.
        - Create a new database:
          ```sql
          CREATE DATABASE ecommerce_db;
          ```

    - **Run SQL Scripts:**
        - In the project directory, locate the `database` folder containing SQL scripts.
        - Execute the provided SQL scripts to create and populate the necessary tables:
          ```sh
          psql -U <your_username> -d ecommerce_db -f database/schema.sql
          psql -U <your_username> -d ecommerce_db -f database/data.sql
          ```

4. **Configure Database Connection**
    - Open the project in your preferred Java IDE.
    - Locate the database configuration in the code (usually in `UserDAO` and `ProductDAO` classes).
    - Update the database URL, username, and password to match your PostgreSQL setup:
      ```java
      private final String URL = System.getenv("DB_URL");
      private final String USER = System.getenv("DB_USER");
      private final String PASSWORD = System.getenv("DB_PASSWORD");
      ```

5. **Build the Project**
    - In your IDE, build the project to compile the source code. This step may vary depending on your IDE:
        - **IntelliJ IDEA**: Use the "Build" menu and select "Build Project".
        - **Eclipse**: Use the "Project" menu and select "Build All".
        - **VS Code**: Use the terminal to run:
          ```sh
          javac -cp "libs/*" *.java
          ```

6. **Run the Application**
    - In your IDE, locate the main class (e.g., `Main.java`).
    - Run the main class to start the application. This step may vary depending on your IDE:
        - **IntelliJ IDEA**: Right-click the main class and select "Run".
        - **Eclipse**: Right-click the main class and select "Run As" > "Java Application".
        - **VS Code**: Use the terminal to run:
          ```sh
          java -cp ".;libs/*" Main
          ```

### Troubleshooting
1. **Database Connection Issues:**
    - Ensure your PostgreSQL server is running.
    - Verify the database URL, username, and password in the configuration file.

2. **Compilation Errors:**
    - Ensure all dependencies are correctly set up in your IDE.
    - Check for any missing or incorrect import statements.

3. **Runtime Errors:**
    - Review the console output for error messages.
    - Ensure all required tables and data are present in the database.

### Additional Notes
- Make sure to periodically pull updates from the repository to stay up-to-date with any changes or bug fixes.
- If you encounter any issues that you cannot resolve, refer to the project documentation.

---

By following this guide, you should be able to successfully install, configure, and run our Java Console-Based E-Commerce Platform.