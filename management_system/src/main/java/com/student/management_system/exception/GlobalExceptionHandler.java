package com.student.management_system.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> ResponseEntityExceptionHandler(ResourceNotFoundException exception,WebRequest request){
        ErrorDetails errorDetails=new ErrorDetails(HttpStatus.NOT_FOUND,exception.getMessage(),request.getDescription(true),LocalDateTime.now());
        return ResponseEntity.status(200).body(errorDetails);
    }




    // https://www.baeldung.com/spring-boot-bean-validation
    // https://www.linkedin.com/pulse/spring-boot-handling-exceptionserrors-restful-api-abdelghani-roussi/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }


    // handle else other exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> ExceptionHandler(Exception exception,WebRequest request){
        ErrorDetails errorDetails=new ErrorDetails(HttpStatus.NOT_FOUND,"unhandled exception",request.getDescription(false),LocalDateTime.now());
        return ResponseEntity.status(400).body(errorDetails);
    }

        


}
