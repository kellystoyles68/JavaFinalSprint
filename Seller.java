/**
 * Represents a Seller user in the system.
 * Inherits from the User class.
 */
public class Seller extends User {

    /**
     * Constructs a Seller user with the specified username, password, and email.
     */
    public Seller(String username, String password, String email) {
        super(username, password, email, "seller");
    }
}
