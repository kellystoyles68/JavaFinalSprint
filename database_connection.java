public class database_connection {
    package src.main.java.com.example.ecommerce;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    
    public class DatabaseConnection {
        private static final String URL = "jdbc:postgresql://localhost:5432/ecommerce";
        private static final String USER = "your_database_user";
        private static final String PASSWORD = "your_database_password";
    
        private static Connection connection = null;
    
        // Private constructor to prevent instantiation
        private DatabaseConnection() {}
    
        // Method to get the connection instance
        public static Connection getConnection() throws SQLException {
            if (connection == null || connection.isClosed()) {
                try {
                    // Load the PostgreSQL JDBC driver
                    Class.forName("org.postgresql.Driver");
                    // Establish the connection
                    connection = DriverManager.getConnection(URL, USER, PASSWORD);
                } catch (ClassNotFoundException e) {
                    throw new SQLException("PostgreSQL JDBC Driver not found.", e);
                }
            }
            return connection;
        }
    
        // Method to close the connection
        public static void closeConnection() throws SQLException {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    } 
}
