package com.app.TaskManagementSystem.security.service;

import com.app.TaskManagementSystem.entity.RoleData;
import com.app.TaskManagementSystem.entity.User;
import com.app.TaskManagementSystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            var userObj = user.get();
            return org.springframework.security.core.userdetails.User.builder()
                    .username(userObj.getEmail())
                    .password(userObj.getPassword())
                    .roles(getRoles(userObj.getRoleData()))
                    .build();
        } else {
            throw new UsernameNotFoundException(email);
        }
    }
    private String getRoles(RoleData roleData) {
        if(roleData.getRoleName() == null || roleData.getRoleName() == ("USER")) {
            return new String ("USER");
        } else
        return ("ADMIN");
    }


}
