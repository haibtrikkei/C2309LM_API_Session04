package com.example.demo_api_custom_validation.model.dto.request;

import com.example.demo_api_custom_validation.validate.ConfirmPasswordMatching;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ConfirmPasswordMatching(password = "password",rePassWord = "repassWord")
public class AccountRequest {
    @NotBlank(message = "Username is empty!")
    private String username;
    @NotBlank(message = "Password is empty!")
    private String password;
    @NotBlank(message = "RepassWord is empty!")
    private String repassWord;
    @NotBlank(message = "Full name is empty!")
    private String fullName;
    @NotBlank(message = "Address is empty!")
    private String address;
    @NotBlank(message = "Email is empty!")
    private String email;
    @NotBlank(message = "Phone is empty!")
    private String phone;
}
