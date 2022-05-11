package manage;

import file.FileStaffCSV;
import file.Path;
import mode.Staff;
import mode.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageStaff {
    List<Staff> staffList = new ArrayList<>();

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public ManageStaff() throws IOException {
        staffList = FileStaffCSV.readFromFile(Path.PATH_STAFF, staffList);
    }

    public ManageStaff(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public void add(Staff staff) {
        staffList.add(staff);

    }

    public int findIndexById(int id) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getId() == id) {
                return i;
            }

        }
        return -1;
    }

    public void edit(int id, Staff staff) {
        staffList.set(findIndexById(id), staff);
    }

    public void delete(int id) {
        staffList.remove(findIndexById(id));
    }

    public void showAll() {
        for (int i = 0; i < staffList.size(); i++) {
            System.out.println(staffList.get(i));

        }
    }

    public void filterPartTime() {
        boolean check = false;
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getType().equals("parttime")) {
                System.out.println(staffList.get(i));
                check = true;
            }
        }
        if (!check) System.out.println("Không tìm được nhân viên nào !!");
    }

    public void filterFullTime() {
        boolean check = false;
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getType().equals("fulltime")) {
                System.out.println(staffList.get(i));
                check = true;
            }
        }
        if (!check) System.out.println("Không tìm được nhân viên nào !!");
    }

    public void calSalaryParttime() {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getType().equals("parttime")) {
                System.out.println(staffList.get(i).getName() + " có lương : " + staffList.get(i).getSalary());
            }

        }
    }

    public void calSalaryFulltime() {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getType().equals("fulltime")) {
                System.out.println(staffList.get(i).getName() + " có lương : " + staffList.get(i).getSalary());
            }

        }
    }

}

