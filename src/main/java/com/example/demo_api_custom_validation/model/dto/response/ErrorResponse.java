package com.example.demo_api_custom_validation.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorResponse <T>{
    private String message;
    private T data;
    private HttpStatus httpStatus;
}
