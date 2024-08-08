/**
 * Represents a Buyer user in the system.
 * Inherits from the User class.
 */
public class Buyer extends User {

    /**
     * Constructs a Buyer user with the specified username, password, and email.
     */
    public Buyer(String username, String password, String email) {
        super(username, password, email, "buyer");
    }
}
