package com.example.project.dto;

import com.example.project.form.Userform;
import com.example.project.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Getter
@Setter
public class Userdto  extends Userform {
    private Set<RoleDto> userRoles;


    public Userdto(User user) {
        super(user);
        this.userRoles = user.getRoles().stream().map(RoleDto::new).collect(Collectors.toSet());
    }

    public static Userdto of(User user){

        return new Userdto(user);
    }

    public static List<Userdto> of(List<User> products){
        return products.stream().map(Userdto::of).collect(Collectors.toList());
    }
}
