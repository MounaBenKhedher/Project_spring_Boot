package com.example.project.security.services;


import com.example.project.model.User;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository agent;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {


        User user = agent.findByUsernameAndStatus(s,false).orElseThrow(
                ()-> new UsernameNotFoundException("User Not found with username :"+s)
        );

        return UserDetailsImpl.build(user);
    }
}