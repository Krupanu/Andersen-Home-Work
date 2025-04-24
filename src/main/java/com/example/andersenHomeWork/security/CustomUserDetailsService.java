package com.example.andersenHomeWork.security;

import com.example.andersenHomeWork.models.User;
import com.example.andersenHomeWork.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        String authority = "ROLE_" + user.getRole().getValue().toUpperCase();

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority(authority)));
        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }
}