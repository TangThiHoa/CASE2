package file;

import manage.ManageRole;
import mode.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUserCSV {
    private static String path;

    public static void writeToFile(List<User> userList) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "id,name,pass,status,role \n";
        for (User user : userList) {
            str += user;
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
    }

    public static List<User> readFromFile(String path) throws IOException {
        List<User> userList = new ArrayList<>();
        ManageRole manageRole = new ManageRole();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = bufferedReader.readLine();
        while ((str = bufferedReader.readLine()) != null) {
            if (str.equals("")) {
                break;
            }

        }return userList;
    }
}
