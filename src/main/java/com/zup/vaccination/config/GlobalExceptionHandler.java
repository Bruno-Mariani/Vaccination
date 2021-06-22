package com.zup.vaccination.config;

import com.zup.vaccination.dtos.ApiResponse;
import com.zup.vaccination.exceptions.UniqueKeyViolationException;
import com.zup.vaccination.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {UserNotFoundException.class})
    ResponseEntity<ApiResponse> handleUserNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>(
                new ApiResponse(false, ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(value = {UniqueKeyViolationException.class})
    ResponseEntity<ApiResponse> handleUniqueKeyViolationException(UniqueKeyViolationException ex) {
        return new ResponseEntity<>(
                new ApiResponse(false, ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = {Exception.class})
    ResponseEntity<ApiResponse> handleExceptions(Exception ex) {
        return new ResponseEntity<>(
                new ApiResponse(false, ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
