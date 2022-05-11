package manage;

import file.FileUserCSV;
import file.Path;
import mode.Role;
import mode.Staff;
import mode.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static file.Path.PATH_USER;

public class ManageUser {
    List<User> userList = new ArrayList<>();
    public static User currentUser = new User();

    public ManageUser(List<User> userList) {
        this.userList = userList;
    }

    public ManageUser() throws IOException {
        userList = FileUserCSV.readFromFile(PATH_USER, userList);

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
    public int findByIndexName(String name){
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(name)){
                return i;
            }
        }
        return -1;
    }
    public User findByName(String name){
        return userList.get(findByIndexName(name));
    }
}
