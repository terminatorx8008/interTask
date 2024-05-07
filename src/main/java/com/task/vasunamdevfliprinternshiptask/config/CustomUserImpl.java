package com.task.vasunamdevfliprinternshiptask.config;

import com.task.vasunamdevfliprinternshiptask.entities.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserImpl implements UserDetails {
    private Admin admin;

    public CustomUserImpl(Admin admin) {
        super();
        this.admin = admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = null;
        if(admin!=null)
            simpleGrantedAuthority = new SimpleGrantedAuthority(admin.getRole());
        return List.of(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return admin.getAdminPassword();
    }

    @Override
    public String getUsername() {
        return admin.getAdminEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}