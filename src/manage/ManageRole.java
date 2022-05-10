package manage;

import mode.Role;

import java.util.ArrayList;
import java.util.List;

public class ManageRole {
    List<Role> roleList = new ArrayList<>();

    public ManageRole() {
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
