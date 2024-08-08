import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Service class for managing users.
 * Acts as a bridge between the presentation layer and the data access layer.
 */
public class UserService {
    private UserDAO userDAO;

    /**
     * Constructs a new UserService and initializes the UserDAO.
     */
    public UserService() {
        this.userDAO = new UserDAO();
    }

    /**
     * Registers a new user in the system.
     * Hashes the user's password before storing it.
     * @param username the username of the user
     * @param password the password of the user
     * @param email the email of the user
     * @param role the role of the user (e.g., buyer, seller, admin)
     */
    public void registerUser(String username, String password, String email, String role) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User(username, hashedPassword, email, role);
        userDAO.addUser(user);
    }

    /**
     * Logs in a user by verifying their username and password.
     * @param username the username of the user
     * @param password the password of the user
     * @return the authenticated user, or null if authentication fails
     */
    public User loginUser(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    /**
     * Retrieves a user by their ID.
     * @param id the ID of the user to retrieve
     * @return the user with the specified ID, or null if not found
     */
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    /**
     * Retrieves all users from the database.
     * @return a list of all users
     */
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    /**
     * Updates an existing user in the database.
     * @param user the user to update
     */
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    /**
     * Deletes a user from the database by their ID.
     * @param id the ID of the user to delete
     */
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
