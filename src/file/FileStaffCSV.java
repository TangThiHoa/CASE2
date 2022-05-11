package file;

import manage.ManageRole;
import manage.ManageUser;
import mode.Role;
import mode.Staff;
import mode.User;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class FileStaffCSV {
    public static void writeToFile(String path, List<Staff> staffList) throws IOException {
        File file = new File(path);
        PrintWriter pw = new PrintWriter(file);
        String str = "ID,NAME,TYPE,STATUS,SALARY,ID USER\n";
        for (Staff staff : staffList) {
            str += staff.getId()+","+staff.getName()+","+staff.getType()+","+staff.getStatus()+","+staff.getSalary()+","+staff.getUser().getUsername()+"\n";
        }
        pw.write(str);
        pw.close();
    }
    public static List<Staff> readFromFile(String path, List<Staff> staffList) throws IOException {
        File file = new File(path);
        ManageUser manageUser = new ManageUser();
        Scanner sc = new Scanner(file);
        sc.nextLine();
        while (sc.hasNext()) {
            String a = sc.nextLine();
            String[] value = a.split(",");
            User user = manageUser.findByName(value[5]);
            staffList.add(new Staff(Integer.parseInt(value[0]), value[1], value[2],value[3],value[4], user));

        }
        return staffList;
    }
}

