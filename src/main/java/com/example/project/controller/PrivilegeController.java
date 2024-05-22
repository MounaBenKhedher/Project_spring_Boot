package com.example.project.controller;


import com.example.project.dto.Privilegedto;
import com.example.project.dto.Userdto;
import com.example.project.exception.MissingEntity;
import com.example.project.model.Privilege;
import com.example.project.model.User;
import com.example.project.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/auth/privillege")
@CrossOrigin(origins="*")
@Controller
public class PrivilegeController {

    @Autowired
    PrivilegeService privilegeService ;

    @PostMapping("/add")
    public ResponseEntity<?> addPrivilege(@RequestParam long roleId, @RequestParam String menuId) {
        return ResponseEntity.ok(new Privilegedto(privilegeService.addPrivilege(roleId, menuId)));
    }

    @DeleteMapping("/deletePrivilege/{id}")
    public void deletePrivilege(@PathVariable long id) {
        privilegeService.deletePrivilege(id);

    }
    @GetMapping("/all")
    public ResponseEntity<List<Privilegedto>> getAllPrivileges() {
        List<Privilege> privileges = privilegeService.getAllPrivileges();
        if (privileges.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<Privilegedto> privilegedtos = privileges.stream().map(Privilegedto::new).collect(Collectors.toList());
        return new ResponseEntity<>(privilegedtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Privilegedto> getPrivilegeById(@PathVariable long id) {
        Privilege privilege = privilegeService.getPrivilegeById(id);
        if (privilege == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new Privilegedto(privilege), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Privilegedto> updatePrivilege(@PathVariable long id, @RequestParam Long roleId, @RequestParam String menuId) {
        Privilege updatedPrivilege = privilegeService.updatePrivilege(id, roleId, menuId);

        if (updatedPrivilege == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new Privilegedto(updatedPrivilege), HttpStatus.OK);
    }
    @GetMapping("/privilegesByRole/{roleId}")
    public ResponseEntity<List<Privilegedto>> getPrivilegesByRole(@PathVariable long roleId) {
        List<Privilege> privileges = privilegeService.getPrivilegesByRole(roleId);
        if (privileges.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<Privilegedto> privilegeDto = privileges.stream().map(Privilegedto::new).collect(Collectors.toList());
        return new ResponseEntity<>(privilegeDto, HttpStatus.OK);
    }
    }

    /*
        @GetMapping()
    public PrivilegeForm DisplayForm(){
        return privilegeService.displayForm();
    }
     */






















/*
    @GetMapping("/privilegeForm/{cod_module}")
    public PrivilegeForm displayMenuForm(@PathVariable String cod_module) {
        // Créez un nouvel objet PrivilegeForm
        PrivilegeForm privilegeForm = new PrivilegeForm();
        privilegeForm.setModule(cod_module);

        // Appelez la méthode du service pour récupérer les menus et les définir dans le formulaire
        return privilegeService.displayMenuForm(privilegeForm);
    }
/*
       @PostMapping("/addprivilege")
       public PrivilegeForm <Privilege>  addPrivilege(@RequestParam long roleId, @RequestParam String menuId) {
           privilegeService.addPrivilege(roleId, menuId);
           return ResponseEntity.ok("Privilege added successfully");
       }
*/


