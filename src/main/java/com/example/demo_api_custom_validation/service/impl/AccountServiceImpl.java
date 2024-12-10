package com.example.demo_api_custom_validation.service.impl;

import com.example.demo_api_custom_validation.model.dto.request.AccountRequest;
import com.example.demo_api_custom_validation.model.entity.Account;
import com.example.demo_api_custom_validation.repository.AccountRepository;
import com.example.demo_api_custom_validation.service.AccountService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account insertAccount(AccountRequest accountRequest) {
        Account accountByUsername = accountRepository.getAccountByUsername(accountRequest.getUsername());
        if(accountByUsername!=null)
            throw new NoSuchElementException("Username da ton tai!");
        Account acc = Account.builder()
                .username(accountRequest.getUsername())
                .password(BCrypt.hashpw(accountRequest.getPassword(),BCrypt.gensalt(12)))
                .fullName(accountRequest.getFullName())
                .address(accountRequest.getAddress())
                .email(accountRequest.getEmail())
                .phone(accountRequest.getPhone())
                .build();
        return accountRepository.save(acc);
    }

    @Override
    public Account updateAccount(Integer id, AccountRequest accountRequest) {
        accountRepository.findById(id).orElseThrow(()->new NoSuchElementException("Khong ton tai account!"));
        Account acc = Account.builder()
                .username(accountRequest.getUsername())
                .password(BCrypt.hashpw(accountRequest.getPassword(),BCrypt.gensalt(12)))
                .fullName(accountRequest.getFullName())
                .address(accountRequest.getAddress())
                .email(accountRequest.getEmail())
                .phone(accountRequest.getPhone())
                .build();
        acc.setId(id);
        return accountRepository.save(acc);
    }

    @Override
    public Account getByUserName(String username) {
        return accountRepository.getAccountByUsername(username);
    }

    @Override
    public void deleteAccount(Integer id) {
        accountRepository.findById(id).orElseThrow(()->new NoSuchElementException("Khong ton tai account!"));
        accountRepository.deleteById(id);
    }
}
