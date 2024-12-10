package com.example.demo_api_custom_validation.advice_controller;

import com.example.demo_api_custom_validation.model.dto.response.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class AccountControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse<Map<String,String>>> handleDataIntegrity(MethodArgumentNotValidException ex){
        Map map = new HashMap();
        List<ObjectError> allErrors = ex.getAllErrors();
        for(int i=0;i<allErrors.size();i++)
            map.put("error-"+(i+1),allErrors.get(i).getDefaultMessage());
        return new ResponseEntity<>(new ErrorResponse<>("error!",map, HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse<String>> handNoSuchElement(NoSuchElementException ex){
        return new ResponseEntity<>(new ErrorResponse<>("error",ex.getLocalizedMessage(),HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }
}
