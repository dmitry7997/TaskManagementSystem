package com.app.TaskManagementSystem.security.controller;

import com.app.TaskManagementSystem.entity.RoleData;
import com.app.TaskManagementSystem.entity.User;
import com.app.TaskManagementSystem.repository.RoleDataRepository;
import com.app.TaskManagementSystem.repository.UserRepository;
import com.app.TaskManagementSystem.security.configuration.JWTGenerator;
import com.app.TaskManagementSystem.security.dto.AuthResponseDto;
import com.app.TaskManagementSystem.security.dto.LoginDto;
import com.app.TaskManagementSystem.security.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RegistrationController {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JWTGenerator jwtGenerator;

    private final RoleDataRepository roleDataRepository;

    @PostMapping("register/user")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) throws Exception {
        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode((registerDto.getPassword())));

        RoleData roleData = roleDataRepository.findByRoleName("USER")
                .orElseThrow(() -> new Exception("RoleData does not exist with roleName: USER"));
        user.setRoleData(roleData);

        userRepository.save(user);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generationToken(authentication);
        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
    }
}
