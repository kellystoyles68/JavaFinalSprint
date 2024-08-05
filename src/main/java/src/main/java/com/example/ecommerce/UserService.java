package src.main.java.com.example.ecommerce;

import java.sql.SQLException;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

public class UserService {
    private  UserService userDAO;

    public UserService(UserService userDAO) {
        this.userDAO = userDAO;
    }

    public UserService(UserDAO userDAO2) {
        //TODO Auto-generated constructor stub
    }

    private void addUser(Object user) {
        throw new UnsupportedOperationException("Unimplemented method 'addUser'");
    }

    public void registerUser(String username, String password, String email, String role) throws SQLException {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12)); // Use 12 salt rounds
        Object user = new Object ();
        userDAO.addUser(user);
    }


    public User authenticateUser(String username, String password) throws SQLException {
        User user = userDAO.getUserByUsername(username);
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    public List<User> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }

    public void deleteUser(String username) throws SQLException {
        userDAO.deleteUser(username);
    }
}
