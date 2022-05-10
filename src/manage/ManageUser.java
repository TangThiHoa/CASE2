package manage;

import file.FileUserCSV;
import file.Path;
import mode.Role;
import mode.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageUser {
    List<User> userList = new ArrayList<>();
    public static User currentUser = new User();

    public ManageUser(List<User> userList) {
        this.userList = userList;
    }

    public ManageUser() throws IOException {
        userList = FileUserCSV.readFromFile(Path.PATH_USER);

    }

    public List<User> getUserList() {
        return userList;
    }

    public void add(User user) {
        userList.add(user);

    }

    public int findIndexById(int id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id) {
                return i;
            }

        }
        return -1;
    }

    public User findById(int id) {
        return userList.get(findIndexById(id));
    }

    public void edit(int id, User user) {
        userList.set(findIndexById(id), user);
    }

    public void delete(int id) {
        userList.remove(findIndexById(id));
    }

    public void showAll() {
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));

        }
    }

    public int login(String username, String pass) {
        for (User user : userList) {
            if (username.equals(user.getUsername()) && pass.equals(user.getPassword())) {
                currentUser = user;
                return 1;
            }
        }
        return 0;
    }

    public String showUserName(String name) {
        String str = "Tài khoản : ";
        for (User user : userList) {
            if (name.equals(user.getUsername())) {
                str += user.getUsername();
            }
        }
        return str;
    }

    public void filterParttime() {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getType().equals(" Parttime ")) {
                System.out.println(" Danh sách NV Parttime là : ");
                System.out.println(userList.get(i));

            }
        }
    }

    public void filterFulltime() {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getType().equals(" Fulltime ")) {
                System.out.println("  Danh sách NV Fulltime là : ");
                System.out.println(userList.get(i));

            }
        }
    }

    public void updateStaffStatus(String name) throws Exception {
        int index = findIndexById(Integer.parseInt(name));
        if (index != -1) {
            boolean change = !userList.get(index).isStatus();
            userList.get(index).setStatus(change);
            FileUserCSV.writeToFile(userList);
            System.out.println("Update trạng thái công việc thành công! ");
        } else {
            System.out.println("Không có " + name + " trong danh sách!!!");
        }
    }
    public void calSalaryParttime() {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getType().equals(" Parttime ")) {
                System.out.println(userList.get(i).getUsername() + " có lương : " + userList.get(i).getSalary());
            }

        }
    }
    public void calSalaryFulltime() {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getType().equals(" Fulltime ")) {
                System.out.println(userList.get(i).getUsername() + " có lương : " + userList.get(i).getSalary());
            }

        }
    }

}
