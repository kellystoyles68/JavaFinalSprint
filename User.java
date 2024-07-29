public class User {
    private String username;
    private String password;
    private String email;
    private String role;
    
    public User(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    //**Getters and setters */ 
    
    //**Get Username */ 
    public String getUsername() {
        return username;
    }

    //**Set Username */ 
    public void setUsername(String username) {
        this.username = username;
    }

    //**Get Password */ 
    public String getPassword() {
        return password;
    }

    //**Set Password */ 
    public void setPassword(String password) {
        this.password = password;
    }

    //**Get Email */ 
    public String getEmail() {
        return email;
    }

    //**Set Email */ 
    public void setEmail(String email) {
        this.email = email;
    }

    //**Get Role */ 
    public String getRole() {
        return role;
    }

    //**Set Role */ 
    public void setRole(String role) {
        this.role = role;
}

  
}