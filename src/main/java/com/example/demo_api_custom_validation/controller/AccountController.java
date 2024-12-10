package com.example.demo_api_custom_validation.controller;

import com.example.demo_api_custom_validation.model.dto.request.AccountRequest;
import com.example.demo_api_custom_validation.model.dto.response.DataResponse;
import com.example.demo_api_custom_validation.model.entity.Account;
import com.example.demo_api_custom_validation.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<DataResponse<List<Account>>> getAccounts(){
        return new ResponseEntity<>(new DataResponse<>(accountService.getAccounts(), HttpStatus.OK),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse<Account>> insertAccount(@Valid @RequestBody AccountRequest accountRequest){
        return new ResponseEntity<>(new DataResponse<>(accountService.insertAccount(accountRequest),HttpStatus.CREATED),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponse<Account>> updateAccount(@PathVariable Integer id, @Valid @RequestBody AccountRequest accountRequest){
        return new ResponseEntity<>(new DataResponse<>(accountService.updateAccount(id,accountRequest),HttpStatus.OK),HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<DataResponse<Account>> getAccount(@PathVariable String username){
        return new ResponseEntity<>(new DataResponse<>(accountService.getByUserName(username),HttpStatus.OK),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResponse<String>> deleteAccount(@PathVariable Integer id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>(new DataResponse<>("Delete successfully!",HttpStatus.NO_CONTENT),HttpStatus.NO_CONTENT);
    }
}
