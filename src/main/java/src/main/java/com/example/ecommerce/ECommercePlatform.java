package src.main.java.com.example.ecommerce;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ECommercePlatform {
    private static Connection connection;
    private static UserService userService;
    private static ProductService productService;
    private static User currentUser;

    public static void main(String[] args) {
        try {
            connection = getConnection();
            DatabaseSetup.executeSqlFile(connection, "./src/databases/createDatabaseSpinTop_Records.sql");
            DatabaseSetup.executeSqlFile(connection, "./src/databases/createTableProducts.sql");
            DatabaseSetup.executeSqlFile(connection, "./src/databases/createTableUsers.sql");
            DatabaseSetup.executeSqlFile(connection, "./src/databases/Products.sql");
            DatabaseSetup.executeSqlFile(connection, "./src/databases/Users.sql");

            userService = new UserService(new UserDAO(connection));
            productService = new ProductService(new ProductDAO(connection));
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Welcome to SpinTop Records E-Commerce Platform");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        registerUser(scanner);
                        break;
                    case 2:
                        loginUser(scanner);
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
        } catch (SQLException e) {
                System.out.println("Error logging in: " + e.getMessage());
        }
    }

    public static registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter role (Buyer, Seller, Admin): ");
        String role = scanner.nextLine();

        try {
            userService.registerUser(username, password, email, role);
            System.out.println("User registered successfully!");
        } catch (SQLException e) {
            System.out.println("Error registering user: " + e.getMessage());
        }
    }

    private static void loginUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try {
            User user = userService.authenticateUser(username, password);
            if (user != null) {
                System.out.println("Login successful!");
                currentUser = user;
                showMenu(scanner);
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (SQLException e) {
            System.out.println("Error logging in: " + e.getMessage());
        }
    }

    private static void showMenu(Scanner scanner) {
        switch (currentUser.getRole()) {
            case "Buyer":
                showBuyerMenu(scanner);
                break;
            case "Seller":
                showSellerMenu(scanner);
                break;
            case "Admin":
                showAdminMenu(scanner);
                break;
            default:
                System.out.println("Invalid role.");
        }
    }

    private static void showBuyerMenu(Scanner scanner) {
        while (true) {
            System.out.println("Buyer Menu");
            System.out.println("1. View Products");
            System.out.println("2. Search Product");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    getAllProducts();
                    break;
                case 2:
                    searchProduct(scanner);
                    break;
                case 3:
                    logout();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void getAllProducts() {
        try {
            List<Product> products = productService.getAllProducts();
            for (Product product : products) {
                System.out.println(product.getId() + " - " + product.getName() + " - $" + product.getPrice() + " - " + product.getQuantity() + " available");
            }
        } catch (SQLException e) {
            System.out.println("Error fetching products: " + e.getMessage());
        }
    }

    private static void searchProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        try {
            List<Product> products = productService.searchProductsByName(name);
            if (products.isEmpty()) {
                System.out.println("No products found with the name: " + name);
            } else {
                for (Product product : products) {
                    System.out.println(product.getId() + " - " + product.getName() + " - $" + product.getPrice() + " - " + product.getQuantity() + " available");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error searching products: " + e.getMessage());
        }
    }

    private static void showSellerMenu(Scanner scanner) {
        while (true) {
            System.out.println("Seller Menu");
            System.out.println("1. Add Product");
            System.out.println("2. View My Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    viewMyProducts(scanner);
                    break;
                case 3:
                    updateProduct(scanner);
                    break;
                case 4:
                    deleteProduct(scanner);
                    break;
                case 5:
                    logout();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            productService.addProduct(name, price, quantity, currentUser.getId());
            System.out.println("Product added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    private static void viewMyProducts(Scanner scanner) {
        try {
            List<Product> products = productService.getProductsBySellerId(currentUser.getId());
            for (Product product : products) {
                System.out.println(product.getId() + " - " + product.getName() + " - $" + product.getPrice() + " - " + product.getQuantity() + " available");
            }
        } catch (SQLException e) {
            System.out.println("Error fetching your products: " + e.getMessage());
        }
    }

    private static void updateProduct(Scanner scanner) {
        System.out.print("Enter product ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter new product quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        try {
            Product product = new Product(id, name, price, quantity, currentUser.getId());
            productService.updateProduct(product);
            System.out.println("Product updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error updating product: " + e.getMessage());
        }
    }

    private static void deleteProduct(Scanner scanner) {
        System.out.print("Enter product ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            productService.deleteProduct(id);
            System.out.println("Product deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting product: " + e.getMessage());
        }
    }

    private static void showAdminMenu(Scanner scanner) {
        while (true) {
            System.out.println("Admin Menu");
            System.out.println("1. View All Users");
            System.out.println("2. Delete User");
            System.out.println("3. View All Products");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewAllUsers();
                    break;
                case 2:
                    deleteUser(scanner);
                    break;
                case 3:
                    viewAllProducts();
                    break;
                case 4:
                    logout();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            for (User user : users) {
                System.out.println(user.getUsername() + " - " + user.getEmail() + " - " + user.getRole());
            }
        } catch (SQLException e) {
            System.out.println("Error fetching users: " + e.getMessage());
        }
    }

    private static void deleteUser(Scanner scanner) {
        System.out.print("Enter username to delete: ");
        String username = scanner.nextLine();

        try {
            userService.deleteUser(username);
            System.out.println("User deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting user: " + e.getMessage());
        }
    }

    private static void logout() {
        currentUser = null;
        System.out.println("Logged out successfully.");
    }
}}}