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
        int sum = 0;
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getType().equals("parttime")) {
                System.out.println(staffList.get(i).getName() + " có lương : " + staffList.get(i).getSalary());
                sum += Integer.parseInt(staffList.get(i).getSalary());
            }

        }
        System.out.println("Tổng lương nhân viên parttime : " + sum);
    }

    public void calSalaryFulltime() {
        int sum = 0;
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getType().equals("fulltime")) {
                System.out.println(staffList.get(i).getName() + " có lương : " + staffList.get(i).getSalary());
                sum += Integer.parseInt(staffList.get(i).getSalary());
            }
        }
        System.out.println("Tổng lương nhân viên fulltime : " + sum);
    }

    public void updateWorking(int id) {
        int index = findIndexById(id);
        if (index == -1) {
            System.out.println("Không tìm thấy , vui lòng nhập lại ");
        } else {
            staffList.get(index).setStatus("Đang làm ");
            System.out.println("Cập nhật thành công !");

        }

    }

    public int findByStatusOn() {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getStatus().equals("Đang làm ")) {
                System.out.println(staffList);
                return i;
            }
        }
        return -1;
    }

    public int findByStatusOff() {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getStatus().equals("Nghỉ việc ")) {
                System.out.println(staffList);
                return i;
            }
        }
        return -1;
    }

    public void showByStatusOn(int id) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getId() == id && staffList.get(i).getStatus().equals("Đang làm ")) {
                System.out.println(staffList.get(i));
                staffList.get(findIndexById(id)).setStatus("Nghỉ việc ");
                staffList.get(findIndexById(id)).setSalary("0");
                staffList.get(findIndexById(id)).setType("Đang nghỉ ");
            } else if (staffList.get(i).getId() == id && staffList.get(i).getStatus().equals("Nghỉ việc ")) {
                System.out.println(staffList.get(i));
                staffList.get(findIndexById(id)).setStatus("Đang làm ");
            }
        }
        System.out.println("Sau khi thay đổi trạng thái : \n" + staffList.get(findIndexById(id)));
    }

    //    public void showByStatusOff(int id) {
//        for (int i = 0; i < staffList.size(); i++) {
//            if (staffList.get(i).getId() == id &&staffList.get(i).getStatus().equals("Nghỉ việc ")) {
//
//            }
//        }
//    }
    public void updateQuit(String name) {
        int indexOf = findIndexById(Integer.parseInt(name));
        if (indexOf == -1) {
            System.out.println("Không tìm thấy , vui lòng nhập lại ");
        } else {
            staffList.get(indexOf).setStatus("Nghỉ việc ");
            System.out.println("Cập nhật thành công !");
        }

    }


}

