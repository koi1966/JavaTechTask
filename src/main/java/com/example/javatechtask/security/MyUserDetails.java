package com.example.javatechtask.security;

import com.example.javatechtask.models.User;


import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

//@Service
//public class MyUserDetails implements UserDetails {
public class MyUserDetails implements UserDetails {

    private User user;

    public MyUserDetails(User user){
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(user.getRoles().split(", "))//split the role string into separate parts separated by commas
                .map(SimpleGrantedAuthority::new) // convert the value to the desired class
                .collect(Collectors.toList()); //collecting roles into a sheet
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // indicates the role has expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // check the validity of the user account
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // password expiration date
    }

    @Override
    public boolean isEnabled() {
        return true;  // check the user is enabled or disabled
    }
}
