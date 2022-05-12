import manage.ManageStaff;
import manage.ManageUser;
import menu.Menu;
import menu.SatffMenu;
import menu.UserMenu;
import mode.User;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ManageUser manageUser = new ManageUser();
        ManageStaff manageStaff = new ManageStaff();
        Scanner sc = new Scanner(System.in);
        Scanner scc = new Scanner(System.in);
        String username;
        String password;
        int choice = -1;
        while (choice != 0) {
            Menu.mainMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Đăng Nhập");
                    System.out.println("Nhập tài khoản ");
                    username = sc.nextLine();
                    System.out.println("Nhập mật khẩu");
                    password = sc.nextLine();
                    if (manageUser.login(username, password) == 1) {
                        System.out.println("Đăng nhập thành công ");
                        System.out.println(manageUser.showUserName(username));
                        int choice1 = -1;
                        while (choice1 != 0) {
                            UserMenu.mainLogin();
                            choice1 = sc.nextInt();
                            sc.nextLine();
                            switch (choice1) {
                                case 1:
                                    int choice2 = -1;
                                    while ((choice2 != 0)) {
                                        SatffMenu.menuUser();
                                        if (ManageUser.currentUser.getRole().getName().equals("Admin")){
                                            SatffMenu.menuRole();
                                            choice2 = sc.nextInt();
                                            sc.nextLine();
                                        }else {
                                            SatffMenu.menuDefault();
                                            choice2 = sc.nextInt();
                                            sc.nextLine();
                                        }
                                        switch (choice2) {
                                            case 1:
                                                SatffMenu.menuStaffShowAll(manageStaff);
                                                break;
                                            case 2:
                                                SatffMenu.menuStaffFull(manageStaff);
                                                break;
                                            case 3:
                                                SatffMenu.menuStaffPart(manageStaff);
                                                break;
                                            case 4:
                                                SatffMenu.menuSafull(manageStaff);
                                                break;
                                            case 5:
                                                SatffMenu.menuSaPart(manageStaff);
                                                break;
                                            case 6:
                                                SatffMenu.menuStaffShowName();
                                                break;
                                            case 7:
                                                if (ManageUser.currentUser.getRole().getName().equals("Admin")) {
                                                    SatffMenu.menuStaffAdd(manageStaff, manageUser);
                                                }
                                                break;
                                            case 8:
                                                if (ManageUser.currentUser.getRole().getName().equals("Admin")){
                                                    SatffMenu.menuStaffEdit(manageStaff,manageUser);
                                                }
                                                break;
                                            case 9 :
                                                if (ManageUser.currentUser.getRole().getName().equals("Admin")) {
                                                    SatffMenu.menuEditStatus(manageStaff);
                                            }break;

                                        }

                                    }
                                    break;
                                case 2:
                                    UserMenu.information();
                                    break;
                                case 3:
                                    UserMenu.changePass(manageUser);
                                    break;
                                case 0:
                                    ManageUser.currentUser = null;
                                    break;


                            }
                        }
                    }else System.out.println("Tên đăng nhập hoặc mật khẩu bị sai");
                    break;
                case 2 :
                    UserMenu.register(manageUser);
                    break;
            }

        }
    }
}
