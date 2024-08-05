package src.main.java.com.example.ecommerce;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
        public static void executeSqlFile(Connection connection, String filePath) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                StringBuilder sql = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sql.append(line).append("\n");
                }
                String[] sqlStatements = sql.toString().split(";");
                try (Statement statement = connection.createStatement()) {
                    for (String sqlStatement : sqlStatements) {
                        if (!sqlStatement.trim().isEmpty()) {
                            statement.execute(sqlStatement.trim());
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading the SQL file: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("Error executing SQL statement: " + e.getMessage());
            }
        }
    }
