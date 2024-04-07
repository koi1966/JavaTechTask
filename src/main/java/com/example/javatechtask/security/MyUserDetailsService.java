package com.example.javatechtask.security;

import com.example.javatechtask.models.User;
import com.example.javatechtask.models.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository; //

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByName(username);   // тут null
        return user.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username  + " not found."));
    }
}
