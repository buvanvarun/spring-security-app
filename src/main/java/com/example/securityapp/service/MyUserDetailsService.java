package com.example.securityapp.service;

import com.example.securityapp.model.UserPrincipal;
import com.example.securityapp.model.Users;
import com.example.securityapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);
        if(user==null){
            System.out.println("User Not found");
            throw new UsernameNotFoundException("User Not found");
        }
        return new UserPrincipal(user);
    }
}
