package src.main.java.com.example.ecommerce;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private int sellerId;

    public Product(int id, String name, double price, int quantity, int sellerId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sellerId = sellerId;
    }
    
        //**Getters and setters */ 
        
        //**Get Product */ 
        public int getId() {
            return id;
        }
    
        //**Set Product */ 
        public void setId(int id) {
            this.id = id;
        }
    
        //**Get Name */ 
        public String getName() {
            return name;
        }
    
        //**Set Name */ 
        public void setName(String name) {
            this.name = name;
        }
    
        //**Get price */ 
        public double getPrice() {
            return price;
        }
    
        //**Set Price */ 
        public void setPrice (double price) {
            this.price = price;
        }
    
        //**Get Quantity */ 
        public int getQuantity() {
            return quantity;
        }
    
        //**Set Quantity */ 
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }


        //**Get SellerId */ 
        public int getSellerId() {
            return sellerId;
        }
    
        //**Set SellerId */ 
        public void setSellerId (int sellerId) {
            this.sellerId = sellerId;  
         }

    public void updateProduct(Scanner scanner) {
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
        System.out.print("Enter sellerId: ");
        int sellerId = scanner.nextInt();
        scanner.nextLine();

        try {
            product product = new Product(id, name, price, quantity, sellerId;
            productService.updateProduct(product);
            System.out.println("Product updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error updating product: " + e.getMessage());
        }
    }

   
}
