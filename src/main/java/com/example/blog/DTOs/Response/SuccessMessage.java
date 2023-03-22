package com.example.blog.DTOs.Response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class SuccessMessage {
    private final String status;
    private final String message;
}
