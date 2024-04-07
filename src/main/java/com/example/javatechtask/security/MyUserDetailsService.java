package com.example.javatechtask.security;

import com.example.javatechtask.models.User;
import com.example.javatechtask.models.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByName(username));
        return user.map(MyUserDetails::new )
                .orElseThrow(() -> new UsernameNotFoundException(username  + " not found."));
    }
}
