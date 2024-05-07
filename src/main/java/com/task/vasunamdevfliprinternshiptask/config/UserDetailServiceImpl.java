package com.task.vasunamdevfliprinternshiptask.config;


import com.task.vasunamdevfliprinternshiptask.dao.AdminRepo;
import com.task.vasunamdevfliprinternshiptask.entities.Admin;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private AdminRepo adminRepo;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Admin> admin = adminRepo.findByAdminEmail(username);
        if(admin.isPresent()){
            return new CustomUserImpl(admin.get());
        }
        throw new UsernameNotFoundException("User not found");
    }
}
