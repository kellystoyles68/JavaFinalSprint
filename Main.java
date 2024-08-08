import java.util.List;
import java.util.Scanner;

public class Main {
    private static UserService userService = new UserService();
    private static ProductService productService = new ProductService();
    private static Scanner scanner = new Scanner(System.in);

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

    private static void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter role (buyer, seller, admin): ");
        String role = scanner.nextLine();
        userService.registerUser(username, password, email, role);
        System.out.println("User registered successfully!");
    }

    private static void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        User user = userService.loginUser(username, password);
        if (user != null) {
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

    private static void buyerMenu() {
        boolean running = true;
        while (running) {
            System.out.println("Buyer Menu:");
            System.out.println("1. Browse Products");
            System.out.println("2. Search Products");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    List<Product> products = productService.getAllProducts();
                    for (Product product : products) {
                        System.out.println(product.getName() + " - $" + product.getPrice());
                    }
                    break;
                case 2:
                    System.out.print("Enter product ID to search: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    Product product = productService.getProductById(productId);
                    if (product != null) {
                        System.out.println(product.getName() + " - $" + product.getPrice());
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

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
                    System.out.print("Enter seller ID: ");
                    int sellerId = scanner.nextInt();
                    scanner.nextLine();
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
                        System.out.print("Enter new product price: ");
                        product.setPrice(scanner.nextDouble());
                        System.out.print("Enter new product quantity: ");
                        product.setQuantity(scanner.nextInt());
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
                    System.out.print("Enter seller ID to view products: ");
                    int viewSellerId = scanner.nextInt();
                    scanner.nextLine();
                    List<Product> sellerProducts = productService.getAllProducts();
                    for (Product p : sellerProducts) {
                        if (p.getSellerId() == viewSellerId) {
                            System.out.println(p.getName() + " - $" + p.getPrice());
                        }
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

    private static void adminMenu() {
        boolean running = true;
        while (running) {
            System.out.println("Admin Menu:");
            System.out.println("1. View All Users");
            System.out.println("2. Delete User");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    List<User> users = userService.getAllUsers();
                    for (User user : users) {
                        System.out.println(user.getUsername() + " - " + user.getRole());
                    }
                    break;
                case 2:
                    System.out.print("Enter user ID to delete: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    userService.deleteUser(userId);
                    System.out.println("User deleted successfully!");
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
