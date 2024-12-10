package com.example.demo_api_custom_validation.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Objects;

public class PasswordMatchingValidator implements ConstraintValidator<ConfirmPasswordMatching, Object> {
    private String password;
    private String rePassWord;

    @Override
    public void initialize(ConfirmPasswordMatching constraintAnnotation) {
        password = constraintAnnotation.password();
        rePassWord = constraintAnnotation.rePassWord();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object passwordValue = new BeanWrapperImpl(o).getPropertyValue(password);
        Object rePasswordValue = new BeanWrapperImpl(o).getPropertyValue(rePassWord);
        return Objects.equals(passwordValue,rePasswordValue);
    }
}
