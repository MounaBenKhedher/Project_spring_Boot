package com.example.project.form;


import com.example.project.model.Role;
import com.example.project.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Userform {
    private long id;
    @NotBlank
    @Size(max = 20)
    private String username;
    @NotBlank // ce champs ne doit pas etre vide
    private String fullname;
    @NotBlank
    private String phone;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank
    @Size(max = 120)
    private String password;

    //private Set<Role> roles = new HashSet<>();
    private Boolean status;
    public Userform(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.fullname = user.getFullname();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.password = user.getPassword();
      //  this.roles = user.getRoles();
        this.status=user.getStatus();

    }

    public Userform() {
    }
}