package src.main.java.com.example.ecommerce;

public class BCrypt {

    /** Function to hash a password */
    public static String hashPassword(String password) {
        String salt = BCrypt.gensalt(10);
        return BCrypt.hashpw(password, salt);
    }

    /** Function to compare a plaintext password with a hashed password */
    public static boolean comparePassword(String plaintextPassword, String hashedPassword) {
        return BCrypt.checkpw(plaintextPassword, hashedPassword);
    }

    public static void main(String[] args) {
        String password = "mySecurePassword";

        // Hash the password
        String hashedPassword = hashPassword(password);
        System.out.println("Hashed Password: " + hashedPassword);

        // Verify the password
        boolean isMatch = comparePassword(password, hashedPassword);
        System.out.println("Do passwords match? " + isMatch);
    }
}

