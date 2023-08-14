package com.lookhed.nighthawk.auth.application.service;

import java.util.Optional;

import com.lookhed.nighthawk.auth.domain.model.AccountModel;
import com.lookhed.nighthawk.auth.domain.port.in.CreateAccountUseCase;
import com.lookhed.nighthawk.auth.domain.port.in.DeleteAccountUseCase;
import com.lookhed.nighthawk.auth.domain.port.in.RetrieveAccountUseCase;
import com.lookhed.nighthawk.auth.domain.port.in.UpdateAccountUseCase;


public class AccountService implements CreateAccountUseCase, DeleteAccountUseCase, RetrieveAccountUseCase, UpdateAccountUseCase {
    private final CreateAccountUseCase createAccountUseCase;
    private final DeleteAccountUseCase deleteAccountUseCase;
    private final RetrieveAccountUseCase retrieveAccountUseCase;
    private final UpdateAccountUseCase updateAccountUseCase;

    public AccountService(CreateAccountUseCase createAccountUseCase,
                          RetrieveAccountUseCase retrieveAccountUseCase,
                          UpdateAccountUseCase updateAccountUseCase,
                          DeleteAccountUseCase deleteAccountUseCase){
        this.createAccountUseCase = createAccountUseCase;
        this.deleteAccountUseCase = deleteAccountUseCase;
        this.retrieveAccountUseCase = retrieveAccountUseCase;
        this.updateAccountUseCase = updateAccountUseCase;
    }

    @Override
    public AccountModel createAccount(AccountModel accountModel) {
        return this.createAccountUseCase.createAccount(accountModel);
    }

    @Override
    public boolean deleteAccount(AccountModel accountModel) {
        return this.deleteAccountUseCase.deleteAccount(accountModel);
    }

    @Override
    public Optional<AccountModel> getAccountById(int id) {
        return this.retrieveAccountUseCase.getAccountById(id);
    }

    @Override
    public Optional<AccountModel> updateAccount(AccountModel accountModel) {
        return this.updateAccountUseCase.updateAccount(accountModel);
    }
}
