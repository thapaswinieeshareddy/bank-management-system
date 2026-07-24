package com.bank.bank_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.bank_management_system.exception.AccountNotFoundException;

import com.bank.bank_management_system.entity.Account;
import com.bank.bank_management_system.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Create Account
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    // Get Account By Id
    /*    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }*/

    public Account getAccountById(Long id) {

        return accountRepository.findById(id)
            .orElseThrow(() ->
                new AccountNotFoundException("Account not found with id: " + id));
    }

    // Update Account
    /*public Account updateAccount(Long id, Account updatedAccount) {

        Account existingAccount = accountRepository.findById(id).orElse(null);

        if (existingAccount != null) {
            existingAccount.setAccountHolderName(updatedAccount.getAccountHolderName());
            existingAccount.setBalance(updatedAccount.getBalance());

            return accountRepository.save(existingAccount);
        }

        return null;
    } */
    
    public Account updateAccount(Long id, Account updatedAccount) {

        Account existingAccount = accountRepository.findById(id)
            .orElseThrow(() ->
                new AccountNotFoundException("Account not found with id: " + id));

        existingAccount.setAccountHolderName(updatedAccount.getAccountHolderName());
        existingAccount.setBalance(updatedAccount.getBalance());

        return accountRepository.save(existingAccount);
    }
    


    
    // Delete Account
    /* public void deleteAccount(Long id) {
    accountRepository.deleteById(id);
    }*/
    public void deleteAccount(Long id) {

        Account account = accountRepository.findById(id)
            .orElseThrow(() ->
                new AccountNotFoundException("Account not found with id: " + id));

        accountRepository.delete(account);
    }

    // Deposit Money
    public Account deposit(Long id, Double amount) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found with id: " + id));

        account.setBalance(account.getBalance() + amount);

        return accountRepository.save(account);
    } 

    // Withdraw Money
        public Account withdraw(Long id, Double amount) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found with id: " + id));

        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            return accountRepository.save(account);
        }

        return null;
    }

}