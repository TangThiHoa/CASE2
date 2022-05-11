package manage;

import file.FileRoleCSV;
import file.FileUserCSV;
import file.Path;
import mode.Role;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageRole {
    List<Role> roleList = new ArrayList<>();

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public ManageRole() throws IOException {
        roleList = FileRoleCSV.readFromFile(Path.PATH_ROLE,roleList);
    }

    public ManageRole(List<Role> roleList) {
        this.roleList = roleList;
    }
    public void add ( Role role){
        roleList.add(role);

    }

    public int findIndexById (int id ){
        for (int i = 0; i < roleList.size(); i++) {
            if (roleList.get(i).getId() == id){
                return i ;
            }

        } return -1 ;
    }

    public Role findById(int id ){
        return roleList.get(findIndexById(id));
    }

    public void edit (int id , Role role){
        roleList.set(findIndexById(id),role);
    }

    public void delete (int id){
        roleList.remove(findIndexById(id));
    }

    public  void showAll(){
        for (int i = 0; i < roleList.size(); i++) {
            System.out.println(roleList.get(i));

        }
    }

}
