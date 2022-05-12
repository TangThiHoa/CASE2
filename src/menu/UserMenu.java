package menu;

import file.FileUserCSV;
import file.Path;
import manage.ManageRole;
import manage.ManageUser;
import mode.Role;
import mode.User;

import java.io.IOException;
import java.util.Scanner;

public class UserMenu {
    public static void mainLogin() {
        System.out.println("                                                                      MENU LOGIN ");
        System.out.println("                                                             1. Trang chủ           ");
        System.out.println("                                                             2. Thông tin tài khoản ");
        System.out.println("                                                             3. Đổi mật khẩu");

        if (ManageUser.currentUser.getRole().getName().equals("Admin")) {
            System.out.println("                                                             4. Thêm , xóa role");
        }
        System.out.println("                                                             0. Logout");
        System.out.print("                                                    Nhập lựa chọn : ");
    }

    public static void information() {
        System.out.println("Thông tin tài khoản của bạn : ");
//        System.out.println("ID ,Tên , Mật Khẩu ,Role ");
        System.out.println(ManageUser.currentUser);
    }
    public static void addRole (ManageUser manageUser){

    }

    public static void changePass(ManageUser manageUser) throws IOException {
        Scanner scc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập pass mới : ");
            String newPass = scc.nextLine();
            ManageUser.currentUser.setPassword(newPass);
            System.out.println("Bạn đã đổi mật khẩu thành công !!");
            FileUserCSV.writeToFile(Path.PATH_USER, manageUser.getUserList());
            break;


        }


    }

    public static void register(ManageUser manageUser) throws IOException {
        ManageRole manageRole = new ManageRole();
        Scanner sc = new Scanner(System.in);
        String status = "1";
        System.out.println("Đăng kí");
        System.out.println("Nhập ID");
        int id = sc.nextInt();
        sc.nextLine();
        if (manageUser.findIndexById(id) == -1) {
            System.out.println("Nhập tên tài khoản");
            String username = sc.nextLine();
            System.out.println("Nhập mật khẩu");
            String password = sc.nextLine();
            manageRole.showAll();
            System.out.println("Chọn role !!");
            int id1 = sc.nextInt();
            sc.nextLine();
            Role role = manageRole.findById(id1);
            manageUser.add(new User(id, username, password, role));
            System.out.println("Bạn đã tạo tài khoản thành công !");
            FileUserCSV.writeToFile(Path.PATH_USER, manageUser.getUserList());
        } else System.out.println("ID đã tồn tại");
    }
}


