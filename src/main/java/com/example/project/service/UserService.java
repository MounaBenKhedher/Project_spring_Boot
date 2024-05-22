package com.example.project.service;


import com.example.project.dto.Userdto;
import com.example.project.exception.MissingEntity;
import com.example.project.form.ModulForm;
import com.example.project.form.Userform;
import com.example.project.model.Modul;
import com.example.project.model.Role;
import com.example.project.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface UserService {
    public List<User> getUsers();
    Set<Role> assignRolesToUser(long userId, Set<Role> roles);

    public User getByUserId(Long id) throws MissingEntity;


    Map<String,Boolean> deleteUser(long id) throws MissingEntity;
    public User updateUser(long id, Userform form) throws MissingEntity;

    void removeRoleFromUser(Long userId, Long roleId);
    Userdto getUserWithRoles(Long userId);
}
