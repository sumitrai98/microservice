/**
 * @Author codeforsolution
 *
 **/
package com.codeforsolution.user.service.userservice.service;

import com.codeforsolution.user.service.userservice.model.CustomUserDetails;
import com.codeforsolution.user.service.userservice.model.User;
import com.codeforsolution.user.service.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomeUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}
