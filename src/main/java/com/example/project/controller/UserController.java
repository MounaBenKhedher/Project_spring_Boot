package com.example.project.controller;


import com.example.project.dto.Userdto;
import com.example.project.exception.MissingEntity;
import com.example.project.form.Userform;
import com.example.project.model.Role;
import com.example.project.model.User;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/auth/user")
@CrossOrigin(origins = "*")
@Controller
public class UserController {
    @Autowired
    UserService userService ;



    @GetMapping
    List<Userdto> getAll(){
        List<User> users = userService.getUsers();
        return Userdto.of(users);
    }

    @PutMapping("/{userId}/roles")
    public void assignRolesToUser(@PathVariable long userId, @RequestBody Set<Role> roles) {
        userService.assignRolesToUser(userId, roles);
    }


    @GetMapping(value = "/getByUserId/{id}")
    public Userdto getByUserId(@PathVariable long id) throws MissingEntity {
        User user = userService.getByUserId(id);
        return Userdto.of(user);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String,Boolean> deleteUser(@PathVariable long id) throws MissingEntity {
        return userService.deleteUser(id);
    }



    //mise a jourr
    @PutMapping(("/updateUser/{id}"))
    public  Userdto updateUser(@PathVariable long id,@Valid @RequestBody Userform form) throws MissingEntity
    {
        User user=userService.updateUser(id,form);
        return Userdto.of(user);
    }


    @GetMapping("/userRole/{userId}")
    public ResponseEntity<Userdto> getUserWithRoles(@PathVariable Long userId) {
        Userdto userDto = userService.getUserWithRoles(userId);
        if (userDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
    @DeleteMapping("/user/{userId}/roles/{roleId}")
    public ResponseEntity<?> removeRoleFromUser(@PathVariable Long userId, @PathVariable Long roleId) {
        userService.removeRoleFromUser(userId, roleId);
        return ResponseEntity.ok().build();
    }
}
