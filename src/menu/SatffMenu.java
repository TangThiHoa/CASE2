package menu;

import file.FileStaffCSV;
import file.FileUserCSV;
import file.Path;
import manage.ManageStaff;
import manage.ManageUser;
import mode.Staff;
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
        ManageStaff manageStaff = new ManageStaff();
        System.out.println("Danh sách tổng số nhân viên : ");
        manageStaff.showAll();
    }

    public static void menuStaffShowName() throws IOException {
        ManageStaff manageStaff = new ManageStaff();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID nhân viên cần tìm :");
        int staffName = sc.nextInt();
        manageStaff.findIndexById(staffName);
    }

    public static void menuStaffAdd(ManageStaff manageStaff,ManageUser manageUser) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID nhân viên ");
        int id = sc.nextInt();
        sc.nextLine();
        if (manageStaff.findIndexById(id) == -1) {
            System.out.println("Nhập tên nhân viên ");
            String name = sc.nextLine();
            System.out.println("Nhập loại nhân viên  ");
            String stype = sc.nextLine();
            System.out.println("Nhập trạng thái nhân viên  ");
            String status = sc.nextLine();
            System.out.println("Nhập lương");
            String salary = sc.nextLine();
            User user = manageUser.findById(ManageUser.currentUser.getId());
            manageStaff.add(new Staff(id, name, stype, status, salary,user));
            System.out.println("Bạn đã thêm " + name + "thành công");
            FileStaffCSV.writeToFile("staff.csv",manageStaff.getStaffList());
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
            FileUserCSV.writeToFile(Path.PATH_USER,manageUser.getUserList());

        } else System.out.println("Không tìm thấy ID");
    }

    public static void menuStaffFull() throws IOException {
        ManageStaff manageStaff = new ManageStaff();
        System.out.println("Danh sách nhân viên fulltime : ");
        manageStaff.showAll();
    }
//    public static void menuStaffPart() throws IOException {
//        ManageUser manageUser = new ManageUser();
//        System.out.println("Danh sách nhân viên parttime : ");
//        manageUser.filterParttime();
//
//    }
    public  static void menuSafull() throws IOException {
        ManageStaff manageStaff = new ManageStaff();
        System.out.println("Lương nhân viên fulltime  : ");
        manageStaff.calSalaryFulltime();

    }
//    public  static void menuSaPart() throws IOException {
//        ManageUser manageUser = new ManageUser();
//        System.out.println("Lương nhân viên parttime  : ");
//        manageUser.calSalaryParttime();
//
//    }



}






