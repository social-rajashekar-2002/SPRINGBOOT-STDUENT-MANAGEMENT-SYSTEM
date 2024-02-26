package com.student.management_system.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    private HttpStatus status;
    private String message;
    private String details;
    private LocalDateTime timestamp;


}
