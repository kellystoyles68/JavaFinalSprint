package src.main.java.com.example.ecommerce;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            /** Get the database connection */
            Connection connection = DatabaseConnection.getConnection();
            System.out.println("Database connected successfully!");

            /**Perform database operations */
            Menu menu = new Menu(); ;
            menu.displayMainMenu();

            /**Close the database connection */
            DatabaseConnection.closeConnection();
            System.out.println("Database connection closed.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

