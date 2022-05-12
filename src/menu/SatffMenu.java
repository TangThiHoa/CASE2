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
        System.out.println("                                                         MENU STAFF             ");
        System.out.println("                                      1. Hiển thị danh sách nhân viên ");
        System.out.println("                                      2. Hiển thị danh sách nhân viên fulltime ");
        System.out.println("                                      3. Hiển thị danh sách nhân viên parttime");
        System.out.println("                                      4. Lương của nhân viên fulltime ");
        System.out.println("                                      5. Lương của nhân viên parttime ");
        System.out.println("                                      6. Tìm kiếm nhân viên");
    }

    public static void menuRole() {
        System.out.println("                                      7. Thêm nhân viên ");
        System.out.println("                                      8. Chỉnh sửa nhân viên ");
        System.out.println("                                      9. Thay đổi trạng thái nhân viên ");
        System.out.println("                                      0 . Thoát ");
        System.out.println("                          Nhập lựa chọn : ");
    }

    public static void menuDefault() {
        System.out.println("0. Thoát ");
        System.out.print("Nhập lựa chọn : ");
    }

    public static void menuStaffShowAll(ManageStaff manageStaff) throws IOException {//HIển thị danh sách nv
        System.out.println("Danh sách tổng số nhân viên : ");
        manageStaff.showAll();
    }

    public static void menuStaffShowName(ManageStaff manageStaff ) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID nhân viên cần tìm :");
        int staffName = sc.nextInt();
        manageStaff.showById(staffName);
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
            System.out.println("Bạn đã thêm " + name + " thành công !");
            FileStaffCSV.writeToFile("staff.csv",manageStaff.getStaffList());
        } else System.err.println("ID nhân viên đã tồn tại");
    }

    public static void menuStaffEdit(ManageStaff manageStaff,ManageUser manageUser) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID nhân viên cần tìm");
        int id = sc.nextInt();
        sc.nextLine();
        if (manageStaff.findIndexById(id) != -1) {
           manageStaff.showById(id);
            System.out.println("Nhập loại nhân viên  ");
            String stype = sc.nextLine();
            System.out.println("Nhập trạng thái nhân viên  ");
            String status = sc.nextLine();
            System.out.println("Nhập lương");
            String salary = sc.nextLine();
            User user = manageUser.findById(ManageUser.currentUser.getId());
            manageStaff.edit(id, new Staff(id,manageStaff.update(id),stype,status,salary,user));
            System.out.println("Bạn đã sửa thành công");
            manageStaff.showById(id);
            FileStaffCSV.writeToFile(Path.PATH_STAFF,manageStaff.getStaffList());

        } else System.err.println("Không tìm thấy ID");
    }

    public static void menuStaffFull(ManageStaff manageStaff) throws IOException {
        System.out.println("Danh sách nhân viên fulltime : ");
        manageStaff.filterFullTime();
    }
    public static void menuStaffPart(ManageStaff manageStaff) throws IOException {
        System.out.println("Danh sách nhân viên parttime : ");
        manageStaff.filterPartTime();

    }
    public  static void menuSafull(ManageStaff manageStaff) throws IOException {
        System.out.println("Lương nhân viên fulltime  : ");
        manageStaff.calSalaryFulltime();

    }
    public  static void menuSaPart(ManageStaff manageStaff) throws IOException {
        System.out.println("Lương nhân viên parttime  : ");
        manageStaff.calSalaryParttime();

    }
    public static void menuEditStatus(ManageStaff manageStaff) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id nhân viên cần sửa : ");
        int id = scanner.nextInt();
        manageStaff.showByStatusOn(id);
        FileStaffCSV.writeToFile("staff.csv",manageStaff.getStaffList());
    }



}






