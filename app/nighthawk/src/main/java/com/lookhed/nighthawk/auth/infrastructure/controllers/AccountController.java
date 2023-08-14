package com.lookhed.nighthawk.auth.infrastructure.controllers;

import com.lookhed.nighthawk.user.domain.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lookhed.nighthawk.auth.application.service.AccountService;
import com.lookhed.nighthawk.auth.domain.model.AccountModel;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public ResponseEntity<AccountModel> createAccount(@RequestBody AccountModel accountModel) {
        AccountModel createdAccountModel = this.accountService.createAccount(accountModel);
        return new ResponseEntity<>(createdAccountModel, HttpStatus.CREATED);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountModel> getAccountById(@PathVariable int accountId) {
        return this.accountService.getAccountById(accountId)
                .map(account -> new ResponseEntity<>(account, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping
    public ResponseEntity<AccountModel> updateAccount(@RequestBody AccountModel updatedAccountModel) {
        return this.accountService.updateAccount(updatedAccountModel)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteAccount(@RequestBody AccountModel deleteAccountModel){
        boolean response = this.accountService.deleteAccount(deleteAccountModel);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
}
