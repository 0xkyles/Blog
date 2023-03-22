package com.example.blog.DTOs.Response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ErrorMessage {
    private final String status;
    private final String message;
}
