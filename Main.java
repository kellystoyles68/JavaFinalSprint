import java.util.List;
import java.util.Scanner;

/**
 * The main class for the console-based E-Commerce application.
 */
public class Main {
    private static UserService userService = new UserService();
    private static ProductService productService = new ProductService();
    private static Scanner scanner = new Scanner(System.in);
    private static User loggedInUser;

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    /**
     * Prompts the user to register a new account.
     */
    private static void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        String role;
        while (true) {
            System.out.print("Enter role (buyer, seller, admin): ");
            role = scanner.nextLine().toLowerCase();
            if (role.equals("buyer") || role.equals("seller") || role.equals("admin")) {
                break;
            } else {
                System.out.println("Invalid role. Please enter 'buyer', 'seller', or 'admin'.");
            }
        }
        
        userService.registerUser(username, password, email, role);
        System.out.println("User registered successfully!");
    }
    /**
     * Prompts the user to log in.
     */
    private static void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        User user = userService.loginUser(username, password);
        if (user != null) {
            loggedInUser = user;
            System.out.println("Login successful!");
            switch (user.getRole()) {
                case "buyer":
                    buyerMenu();
                    break;
                case "seller":
                    sellerMenu();
                    break;
                case "admin":
                    adminMenu();
                    break;
                default:
                    System.out.println("Unknown role.");
            }
        } else {
            System.out.println("Invalid username or password.");
        }
    }
    /**
     * Displays the menu for buyers and handles their actions.
     */
    private static void buyerMenu() {
        boolean running = true;
        while (running) {
            System.out.println("Buyer Menu:");
            System.out.println("1. Browse Products");
            System.out.println("2. Search Products");
            System.out.println("3. View Product Info");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    List<Product> products = productService.getAllProducts();
                    for (Product product : products) {
                        System.out.println("Id: " + product.getId() + " - " + product.getName() + " - $" + product.getPrice());
                    }
                    break;
                case 2:
                    System.out.print("Enter product name to search: ");
                    String productName = scanner.nextLine();
                    scanner.nextLine();
                    List<Product> Searchproducts = productService.getProductsByName(productName);
                    if (Searchproducts != null && !Searchproducts.isEmpty()) {
                        for (Product product : Searchproducts) {
                            System.out.println("Id: " + product.getId() + " - " + product.getName() + " - $" + product.getPrice());
                        }
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter product Id to view: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    Product idproduct = productService.getProductById(productId);
                    if (idproduct != null) {
                        System.out.println("Id: ~~~~~~~~ " + idproduct.getId());
                        System.out.println("Name: ~~~~~~ " + idproduct.getName());
                        System.out.println("Price: ~~~~~ $" + idproduct.getPrice());
                        System.out.println("Quantity: ~~ " + idproduct.getQuantity());
                        System.out.println("Seller Id: ~ " + idproduct.getSellerId());
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    /**
     * Displays the menu for sellers and handles their actions.
     */
    private static void sellerMenu() {
        boolean running = true;
        while (running) {
            System.out.println("Seller Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View My Products");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    int sellerId = loggedInUser.getId();
                    productService.addProduct(name, price, quantity, sellerId);
                    System.out.println("Product added successfully!");
                    break;
                case 2:
                    System.out.print("Enter product ID to update: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    Product product = productService.getProductById(productId);
                    if (product != null) {
                        System.out.print("Enter new product name: ");
                        product.setName(scanner.nextLine());
                        while (true) {
                            System.out.print("Enter new product price: ");
                            price = scanner.nextDouble();
                            if (price > 0) {
                                product.setPrice(price);
                                break;
                            } else {
                                System.out.println("Price must be greater than 0. Please enter a valid price.");
                            }
                        }
                        while (true) {
                            System.out.print("Enter new product quantity: ");
                            quantity = scanner.nextInt();
                            if (quantity > 0) {
                                product.setQuantity(quantity);
                                break;
                            } else {
                                System.out.println("Quantity must be greater than 0. Please enter a valid quantity.");
                            }
                        }
                        scanner.nextLine();
                        productService.updateProduct(product);
                        System.out.println("Product updated successfully!");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;                
                case 3:
                    System.out.print("Enter product ID to delete: ");
                    int deleteProductId = scanner.nextInt();
                    scanner.nextLine();
                    productService.deleteProduct(deleteProductId);
                    System.out.println("Product deleted successfully!");
                    break;
                case 4:
                    if (loggedInUser.getId() == -1) {
                        System.out.println("You need to log in first.");
                        break;
                    }
                    
                    List<Product> sellerProducts = productService.getAllProducts();
                    boolean hasProducts = false;
                    for (Product p : sellerProducts) {
                        if (p.getSellerId() == loggedInUser.getId()) {
                            System.out.println("Id: " + p.getId() + " - " + p.getName() + " - $" + p.getPrice() + ", Quantity: " + p.getQuantity());
                            hasProducts = true;
                        }
                    }
                    if (!hasProducts) {
                        System.out.println("No products found for seller ID: " + loggedInUser.getId());
                    }
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    /**
     * Displays the menu for admins and handles their actions.
     */
    private static void adminMenu() {
        boolean running = true;
        while (running) {
            System.out.println("Admin Menu:");
            System.out.println("1. View All Users");
            System.out.println("2. Delete User");
            System.out.println("3. View all products");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    List<User> users = userService.getAllUsers();
                    for (User user : users) {
                        System.out.println("Id: " + user.getId() + "Name: " + user.getUsername() + ", Role: " + user.getRole() + ", Contact: " + user.getEmail());
                    }
                    break;
                case 2:
                    System.out.print("Enter user ID to delete: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    User user = userService.getUserById(userId);
                    if (user != null) {
                        userService.deleteUser(userId);
                        System.out.println(user.getUsername() + " deleted successfully!");
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 3:
                    List<Product> products = productService.getAllProductsWithSellerInfo();
                    for (Product product : products) {
                        System.out.println("Id: " + product.getId() + 
                                           ", Name: " + product.getName() + 
                                           ", Price: $" + product.getPrice() + 
                                           ", Quantity: " + product.getQuantity() + 
                                           ", Seller ID: " + product.getSellerId() + 
                                           ", Seller Name: " + product.getSellerName());
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
