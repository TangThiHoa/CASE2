package mode;



public class User {
    private int id;
    private String username;
    private String password;
    private boolean type;
    private boolean status;
    private String salary;
    private Role role;

    public User(String id, String username, String password, String status, int salary, User user) {
    }

    public User(int id, String username, String password, boolean type, boolean status, String salary, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
        this.status = status;
        this.salary = salary;
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
    public boolean isType() {
        return type;
    }


    public String getType(){
        if (isType()){
            return "Fulltime";
        } return "Parttime";
    }


    public void setType(boolean type) {
        this.type = type;
    }

    public String geStatus(){
        if (isStatus()){
            return "Đang làm";
        } return "Thôi việc";
    }



    public boolean isStatus() {
        return status;
    }


    public void setStatus(boolean status) {
        this.status = status;
    }


    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return  id +
                "," + username + "," + password +
                "," + type +"," + status +"," + "," + role.getId()
                + salary ;

                
    }
}
