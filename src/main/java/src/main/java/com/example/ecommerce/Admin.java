package src.main.java.com.example.ecommerce;

public class Admin extends User {
    public Admin(String username, String password, String email) {
        super(username, password, email, "Admin");
    }
}
