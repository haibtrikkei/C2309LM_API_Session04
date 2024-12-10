package com.example.demo_api_custom_validation.service;

import com.example.demo_api_custom_validation.model.dto.request.AccountRequest;
import com.example.demo_api_custom_validation.model.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAccounts();
    Account insertAccount(AccountRequest accountRequest);
    Account updateAccount(Integer id, AccountRequest accountRequest);
    Account getByUserName(String username);
    void deleteAccount(Integer id);
}
