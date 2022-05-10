import manage.ManageUser;
import menu.Menu;
import menu.UserMenu;
import mode.User;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ManageUser manageUser = new ManageUser();
        Scanner sc = new Scanner(System.in);
        Scanner scc = new Scanner(System.in);
        String username ;
        String password ;
        int choice = -1 ;
        while (choice != 0 ){
            Menu.mainMenu();
            switch (choice){
                case 1 :
                    System.out.println("Đăng Nhập");
                    System.out.println("Nhập tài khoản ");
                    username = sc.nextLine();
                    System.out.println("Nhập mật khẩu");
                    password = sc.nextLine();
                    if (manageUser.login(username,password) == 1){
                        System.out.println("Đăng nhập thành công ");
                        System.out.println(manageUser.showUserName(username));
                        int choice1 = -1 ;
                        while (choice1 != 0){
                            UserMenu.mainLogin();
                            switch (choice1){
                                case 1 :
                                    int choice2 = -1 ;
                                    while ((choice2 != 0 )){

                                    }
                            }
                        }
                    }
            }


        }

    }
}
