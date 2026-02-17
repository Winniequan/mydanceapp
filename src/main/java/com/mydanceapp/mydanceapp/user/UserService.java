package com.mydanceapp.mydanceapp.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mydanceapp.mydanceapp.user.dto.RegisterRequestDTO;
import com.mydanceapp.mydanceapp.user.dto.UserResponse;
import com.mydanceapp.mydanceapp.user.exception.UserAlreadyExistsException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse register(RegisterRequestDTO registerRequest) {
        if(userRepository.findByUsername(registerRequest.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("Username already exists");
        }
        if(userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Email already registered");
        }
        //hash password
        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());

        Role role;
        try {
            role = registerRequest.getRole() != null ? Role.valueOf(registerRequest.getRole().toUpperCase()) : Role.STUDENT;
        } catch (IllegalArgumentException e) {
            // TODO: handle exception default to student
             role = Role.STUDENT;
        }

        User newUser = User.builder()
            .username(registerRequest.getUsername())
            .email(registerRequest.getEmail())
            .passwordHash(encodedPassword)
            .role(role)
            .build();
        
        User savedUser = userRepository.save(newUser);

        return UserResponse.builder()
            .id(savedUser.getId())
            .username(savedUser.getUsername())
            .email(savedUser.getEmail())
            .role(savedUser.getRole().name())
            .build();
    }
    
}
