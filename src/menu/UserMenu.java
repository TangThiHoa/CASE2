package menu;

import file.FileUserCSV;
import manage.ManageRole;
import manage.ManageUser;
import mode.User;

import java.io.IOException;
import java.util.Scanner;

public class UserMenu {
    public static void mainLogin() {
        System.out.println("-----------Menu Login---------");
        System.out.println("1.Trang chủ ");
        System.out.println("2.Thông tin tài khoản ");
        System.out.println("3.Đổi mật khẩu");

        if (ManageUser.currentUser.getRole().getName().equals("Admin")) {
            System.out.println("4. Thêm , xóa role");
        }
        System.out.println("0. Logout");
        System.out.print("Nhập lựa chọn : ");
    }

    public static void information() {
        System.out.println("Thông tin tài khoản của bạn : ");
        System.out.println("ID,Tên ,Mật Khẩu,Status,Role");
        System.out.println(ManageUser.currentUser);
    }

    public static void changePass() throws IOException {
        ManageUser manageUser = new ManageUser();
        Scanner scc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập pass mới : ");
            String newPass = scc.nextLine();
            ManageUser.currentUser.setPassword(newPass);
            System.out.println("Bạn đã đổi mật khẩu thành công !!");
            FileUserCSV.writeToFile(manageUser.getUserList());
            break;


        }


    }

    public static void register() throws IOException {
        ManageUser manageUser = new ManageUser();
        ManageRole manageRole = new ManageRole();
        Scanner sc = new Scanner(System.in);
        String status = "1";
        System.out.println("Đăng kí");
        System.out.println("Nhập ID");
        String id = sc.nextLine();
        if (manageUser.findIndexById(Integer.parseInt(id)) == -1) {
            while (true) {
                System.out.println("Nhập tên tài khoản");
                String username = sc.nextLine();
                if (manageUser.findIndexById(Integer.parseInt(username)) == -1) {
                    while (true) {
                        System.out.println("Nhập mật khẩu");
                        String password = sc.nextLine();
                        manageUser.add(new User(id, username, password));
                        System.out.println("Bạn đã tạo tài khoản thành công !");
                        FileUserCSV.writeToFile(manageUser.getUserList());
                    }


                } else System.out.println("Tài khoản đã tồn tại ");
                break;
            }
        }else System.out.println("ID đã tồn tại");
    }


}
