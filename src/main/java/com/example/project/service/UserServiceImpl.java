package com.example.project.service;

import com.example.project.dto.Userdto;
import com.example.project.exception.MissingEntity;
import com.example.project.form.Userform;
import com.example.project.model.Menu;
import com.example.project.model.Modul;
import com.example.project.model.Role;
import com.example.project.model.User;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{
@Autowired
UserRepository userRepository ;

    @Override
    public List<User> getUsers() {

        return userRepository.findAll();
    }
    @Override
    public Set<Role> assignRolesToUser(long userId, Set<Role> roles) {
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            user.getRoles().addAll(roles);
            userRepository.save(user);
        }
        return user.getRoles();
    }

    @Override
    public User getByUserId(Long id) throws MissingEntity {
        Optional<User> user =userRepository.findById(id);
        if(!user.isPresent()){
            throw new MissingEntity("user not found with id :"+id);
        }
        return user.get();
    }

    @Override
    public Map<String, Boolean> deleteUser(long id) throws MissingEntity {
        User user =getByUserId(id);
        userRepository.delete(user);
        Map<String,Boolean> map = new HashMap<>();
        map.put("deleted",Boolean.TRUE);
        return map;
    }

    @Override
    public User updateUser(long id, Userform form) throws MissingEntity {
        User user = getByUserId(id);
        user.setUsername(form.getUsername());
        user.setFullname(form.getFullname());
        user.setEmail(form.getEmail());
        user.setPhone(form.getPhone());
        return userRepository.save(user);
    }

    @Override
    public Userdto getUserWithRoles(Long userId) {
            User user = userRepository.findById(userId).orElse(null);
            if (user != null) {
                return new Userdto(user);
            }
            return null;
        }

    @Override
    public void removeRoleFromUser(Long userId, Long roleId) {
        userRepository.findById(userId).ifPresent(user -> {
            Role roleToRemove = user.getRoles().stream()
                    .filter(role -> role.getId() == roleId)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Role not found"));
            user.getRoles().remove(roleToRemove);
            userRepository.save(user);
        });
    }
    }


