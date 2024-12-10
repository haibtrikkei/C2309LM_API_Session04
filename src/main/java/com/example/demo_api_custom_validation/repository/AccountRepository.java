package com.example.demo_api_custom_validation.repository;

import com.example.demo_api_custom_validation.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account getAccountByUsername(String username);
}
