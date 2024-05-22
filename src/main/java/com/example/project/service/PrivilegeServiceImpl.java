package com.example.project.service;


import com.example.project.dto.Privilegedto;
import com.example.project.dto.Userdto;
import com.example.project.form.PrivilegeForm;

import com.example.project.model.*;

import com.example.project.repository.MenuRepository;
import com.example.project.repository.ModuleRepository;
import com.example.project.repository.PrivilegeRepository;
import com.example.project.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
    @Autowired
    MenuRepository menuRepository;

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PrivilegeRepository privilegeRepository;



    @Override
    public Privilege addPrivilege(long roleId, String menuId) {
        Role role=roleRepository.findById(roleId).orElse(null);
        Menu menu=menuRepository.findById(menuId).orElse(null) ;
        Privilege privilege=new Privilege();
        privilege.setRole(role);
        privilege.setMenu(menu);
        return privilegeRepository.save(privilege);
    }


    @Override
    public void deletePrivilege(long id) {
        privilegeRepository.deleteById(id);
    }

    @Override
    public List<Privilege> getAllPrivileges() {
        List<Privilege> privileges = privilegeRepository.findAll();
        return privileges;
    }

    @Override
    public Privilege getPrivilegeById(long id) {

        return privilegeRepository.findById(id).orElse(null);
    }

    @Override
    public Privilege updatePrivilege(long id, Long roleId, String menuId) {
        // Récupérer le privilège à mettre à jour par son ID
        Optional<Privilege> privilegeOptional = privilegeRepository.findById(id);

        // Vérifier si le privilège existe dans la base de données
        if (privilegeOptional.isPresent()) {
            // Récupérer le privilège de l'Optional
            Privilege privilege = privilegeOptional.get();

            // Mettre à jour les champs du privilège avec les nouvelles valeurs
            Role role = roleRepository.findById(roleId).orElse(null);
            Menu menu = menuRepository.findById(menuId).orElse(null);

            // Vérifier si le rôle et le menu existent
            if (role != null && menu != null) {
                // Mettre à jour les champs du privilège
                privilege.setRole(role);
                privilege.setMenu(menu);

                // Enregistrer les modifications dans la base de données
                return privilegeRepository.save(privilege);
            } else {
                // Gérer le cas où le rôle ou le menu n'est pas trouvé
                // Vous pouvez jeter une exception ou retourner null selon votre logique métier
                return null;
            }
        } else {
            // Gérer le cas où le privilège n'est pas trouvé
            // Vous pouvez jeter une exception ou retourner null selon votre logique métier
            return null;
        }
    }

    @Override
    public List<Privilege> getPrivilegesByRole(long roleId) {

        return privilegeRepository.findByRoleId(roleId);
    }

}
    /*
    @Override
    public void setPrivilegeByRole(PrivilegeForm privilegeForm) {

        List<String> codeMenus = privilegeForm.getCodeMenus();

        List<Menu> menus = codeMenus.stream().map(codeMenu ->
                menuRepository.findByCodmenu(codeMenu).get()).collect(java.util.stream.Collectors.toList());

        Role role = roleRepository.findById(privilegeForm.getRole()).get();

        menus.forEach(menu -> {
            Privilege privilege = new Privilege() ;
            privilege.setMenu(menu);
            privilege.setRole(role);
            privilegeRepository.save(privilege);
        });

    }



}
/*
    @Override
    public PrivilegeForm displayForm() {
        List<Role> roles = ntRoleRepository.findAll();
        List<Modul> modules = moduleRepository.findAll();
        PrivilegeForm form = new PrivilegeForm();
        form.setRoles(roles);
        form.setModules(modules);
        return form;
    }

    @Override
    public PrivilegeForm displayMenuForm(PrivilegeForm privilegeForm) {
        Modul module = moduleRepository.findById(privilegeForm.getModule()).get();
        List<Menu> menus = menuRepository.findByModule(module);
        privilegeForm.setMenus(menus);
        return privilegeForm;
    }}
/*
    @Override
    public void addPrivilege(long roleId, String menuId) {
        Role role=roleRepository.findById(roleId).orElse(null);
        Menu menu=menuRepository.findById(menuId).orElse(null) ;
        Privilege privilege=new Privilege();
        privilege.setRole(role);
        privilege.setMenu(menu);
        privilegeRepository.save(privilege);

    }
 /*
    @Override
    public void deletePrivilege(long roleId, String menuId) {

    }



    @Override
    public long removegrant(long privilegeId) {
        Privilege p = privilegeRepository.findById(privilegeId).get();
        privilegeRepository.delete(p);
        return p.getRole().getId();
    }/*/
