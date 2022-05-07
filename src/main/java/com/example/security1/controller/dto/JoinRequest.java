package com.example.security1.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class JoinRequest {
    private final String username;
    private final String password;
    private final String email;
}
