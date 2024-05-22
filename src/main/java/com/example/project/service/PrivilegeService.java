package com.example.project.service;


import com.example.project.dto.Privilegedto;
import com.example.project.dto.Userdto;
import com.example.project.form.PrivilegeForm;
import com.example.project.model.Privilege;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PrivilegeService {


    Privilege addPrivilege(long roleId, String menuId) ;

    void deletePrivilege(long id);
    //List<Privilege> getPrivilegeByRole(long roleId) ;
    List<Privilege> getAllPrivileges() ;
    Privilege getPrivilegeById(long id);
    Privilege updatePrivilege(long id, Long roleId, String menuId);
    List<Privilege> getPrivilegesByRole(long roleId);

    /*void setPrivilegeByRole(PrivilegeForm privilegeForm) ;





/*PrivilegeForm displayMenuForm(PrivilegeForm privilegeForm);
/*   PrivilegeForm displayForm();
    void addPrivilege(long roleId, String menuId) ;
    /*
    void deletePrivilege(long roleId, String menuId) ;



    long removegrant(long privilegeId) ;/*/
}