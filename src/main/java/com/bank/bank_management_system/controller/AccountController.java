package com.bank.bank_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bank.bank_management_system.entity.Account;
import com.bank.bank_management_system.service.AccountService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Create Account
    @PostMapping
    public Account createAccount(@Valid @RequestBody Account account) {
        return accountService.createAccount(account);
    }

    // Get Account By Id
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    // Update Account
    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Long id,@RequestBody Account account) {
        return accountService.updateAccount(id, account);
    }

    // Delete Account
    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id) {

        accountService.deleteAccount(id);

        return "Account deleted successfully!";
    }
    // Deposit Money
    @PutMapping("/{id}/deposit")
    public Account deposit(@PathVariable Long id,
                        @RequestParam Double amount) {

        return accountService.deposit(id, amount);
    }

    // Withdraw Money
    @PutMapping("/{id}/withdraw")
    public Account withdraw(@PathVariable Long id,
                            @RequestParam Double amount) {

        return accountService.withdraw(id, amount);
    }
}