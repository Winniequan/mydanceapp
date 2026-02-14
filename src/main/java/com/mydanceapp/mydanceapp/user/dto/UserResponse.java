package com.mydanceapp.mydanceapp.user.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String role;
}
