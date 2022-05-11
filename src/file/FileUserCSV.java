package file;

import manage.ManageRole;
import mode.Role;
import mode.User;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileUserCSV {
    private static String path;

    public static void writeToFile(String path, List<User> userList) throws IOException {
        File file = new File(path);
        PrintWriter pw = new PrintWriter(file);
        String str = "ID, Username, Password, Role \n";
        for (User user : userList) {
            str += user.getId() + "," + user.getUsername() + "," + user.getPassword() + "," + user.getRole().getId() +"\n";
        }
        pw.write(str);
        pw.close();
    }

    public static List<User> readFromFile(String path, List<User> userList) throws IOException {
        ManageRole manageRole = new ManageRole();
        File file = new File(path);
        Scanner sc = new Scanner(file);
        sc.nextLine();
        while (sc.hasNext()) {
            String a = sc.nextLine();
            String[] value = a.split(",");
            Role role = manageRole.findById(Integer.parseInt(value[3]));
            userList.add(new User(Integer.parseInt(value[0]), value[1], value[2], role));

        }
        return userList;
    }
}
