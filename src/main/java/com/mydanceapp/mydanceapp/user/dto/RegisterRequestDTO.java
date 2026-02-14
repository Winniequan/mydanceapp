package com.mydanceapp.mydanceapp.user.dto;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class RegisterRequestDTO {
    private String username;
    private String email;
    private String role;
    private String password;
    
}
