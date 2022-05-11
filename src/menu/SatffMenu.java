package menu;

import file.FileUserCSV;
import manage.ManageUser;
import mode.User;

import java.io.IOException;
import java.util.Scanner;

public class SatffMenu {
    public static void menuUser() {
        System.out.println("=====Quản lí Nhân viên=====");
        System.out.println(" 1. Hiển thị danh sách nhân viên ");
        System.out.println(" 2. Hiển thị danh sách nhân viên fulltime ");
        System.out.println(" 3. Hiển thị danh sách nhân viên parttime");
        System.out.println(" 4. Lương của nhân viên fulltime ");
        System.out.println(" 5. Lương của nhân viên parttime ");
        System.out.println(" 6. Tìm kiếm nhân viên");
    }

    public static void menuRole() {
        System.out.println(" 7. Thêm nhân viên ");
        System.out.println(" 8. Chỉnh sửa nhân viên ");
        System.out.println(" 9. Thay đổi trạng thái nhân viên ");
        System.out.println(" 10 . Thoát ");
        System.out.println(" Nhập lựa chọn : ");
    }

    public static void menuDefault() {
        System.out.println("0. Thoát ");
        System.out.print("Nhập lựa chọn : ");
    }

    public static void menuStaffShowAll() throws IOException {//HIển thị danh sách nv
        ManageUser manageUser = new ManageUser();
        System.out.println("Danh sách tổng số nhân viên : ");
        manageUser.showAll();
    }

    public static void menuStaffShowName() throws IOException {
        ManageUser manageUser = new ManageUser() ; //tìm nhân viên
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID nhân viên cần tìm :");
        int staffName = sc.nextInt();
        manageUser.findIndexById(staffName);
    }

    public static void menuStaffAdd(ManageUser manageUser) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID nhân viên ");
        String id = sc.nextLine();
        if (manageUser.findIndexById(Integer.parseInt(id)) == -1) {
            System.out.println("Nhập tên nhân viên ");
            String name = sc.nextLine();
            System.out.println("Nhập loại nhân viên  ");
            String stype = sc.nextLine();
            System.out.println("Nhập trạng thái nhân viên  ");
            String status = sc.nextLine();
            System.out.println("Nhập lương");
            int salary = sc.nextInt();
            User user = manageUser.findById(ManageUser.currentUser.getId());
            manageUser.add(new User(id, name, stype, status, salary, user));
            System.out.println("Bạn đã thêm " + name + "thành công");
            FileUserCSV.writeToFile(manageUser.getUserList());


        } else System.out.println("ID nhân viên đã tồn tại");
    }

    public static void menuStaffEdit() throws IOException {
        Scanner sc = new Scanner(System.in);
        ManageUser manageUser = new ManageUser();
        System.out.println("Nhập ID nhân viên cần tìm");
        int id = sc.nextInt();
        if (manageUser.findIndexById(id) != 1) {
            System.out.println("Nhập tên nhân viên : ");
            String name = sc.nextLine();
            System.out.println("Nhập loại nhân viên  ");
            String stype = sc.nextLine();
            System.out.println("Nhập trạng thái nhân viên  ");
            String status = sc.nextLine();
            System.out.println("Nhập lương");
            int salary = sc.nextInt();
            User user = manageUser.findById(ManageUser.currentUser.getId());
            manageUser.edit(id, new User(id, name, stype, status, salary, user));
            System.out.println("Bạn đã sửa thành công");
            FileUserCSV.writeToFile(manageUser.getUserList());

        } else System.out.println("Không tìm thấy ID");
    }

    public static void menuStaffFull() throws IOException {
        ManageUser manageUser = new ManageUser();
        System.out.println("Danh sách nhân viên fulltime : ");
        manageUser.filterFulltime();

    }
    public static void menuStaffPart() throws IOException {
        ManageUser manageUser = new ManageUser();
        System.out.println("Danh sách nhân viên parttime : ");
        manageUser.filterParttime();

    }
    public  static void menuSafull() throws IOException {
        ManageUser manageUser = new ManageUser();
        System.out.println("Lương nhân viên fulltime  : ");
        manageUser.calSalaryFulltime();

    }
    public  static void menuSaPart() throws IOException {
        ManageUser manageUser = new ManageUser();
        System.out.println("Lương nhân viên parttime  : ");
        manageUser.calSalaryParttime();

    }



}






