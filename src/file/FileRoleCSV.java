package file;

import mode.Role;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class FileRoleCSV {
    public static void writeToFile(String path, List<Role> roleList) throws IOException {
        File file = new File(path);
        PrintWriter pw = new PrintWriter(file);
        String str = "ID,NAME,DESCRIPTION\n";
        for (Role role : roleList) {
            str += role.getId()+","+role.getName()+","+role.getDescription()+"\n";
        }
        pw.write(str);
        pw.close();
    }

    public static List<Role> readFromFile(String path ,List<Role> roleList) throws IOException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        sc.nextLine();
        while (sc.hasNext()){
            String a = sc.nextLine();
            String[] value = a.split(",");
            roleList.add( new Role(Integer.parseInt(value[0]),value[1],value[2]));

        }
        return roleList;
    }
}


