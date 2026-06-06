package com.plotease.dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String userId;
    private String fullName;
    private String studentId;
    private String email;
    private String password;
}