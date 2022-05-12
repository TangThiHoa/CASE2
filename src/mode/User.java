package mode;


public class User {
    private int id;
    private String username;
    private String password;
    private Role role;

    public User(String id, String username, String password, String status, int salary, User user) {

    }

    public User(int id, String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {

    }

    public User(int id, String name, String stype, String status, int salary, User user) {
    }

    public User(String id, String username, String password) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return   "ID : " + id + "," +" Name : " + username +"," +
                " Mật khẩu : " + password + "," + " Người dùng : " +
                 role.getName() ;
    }
}
