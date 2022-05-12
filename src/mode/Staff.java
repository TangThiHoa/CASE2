package mode;

public class Staff {
    private int id;
    private String name;
    private String type;
    private String status;
    private String salary;
    private User user;

    public Staff() {
    }

    public Staff(int id, String name, String type, String status, String salary) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.salary = salary;
    }

    public Staff(int id, String name, String type, String status, String salary, User user) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.salary = salary;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return
                "ID : " + id +
                        ", Tên : " + name +
                        ", Loại : " + type +
                        ", Trạng thái : " + status +
                        ", Lương : " + salary +
                        ", Người dùng : " + user.getUsername()
                ;
    }
}
