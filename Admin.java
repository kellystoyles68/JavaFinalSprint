/**
 * Represents an Admin user in the system.
 * Inherits from the User class.
 */
public class Admin extends User {

    /**
     * Constructs an Admin user with the specified username, password, and email.
     */
    public Admin(String username, String password, String email) {
        super(username, password, email, "admin");
    }
}
