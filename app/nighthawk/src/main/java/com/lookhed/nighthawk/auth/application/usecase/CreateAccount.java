package com.lookhed.nighthawk.auth.application.usecase;

import com.lookhed.nighthawk.auth.domain.model.AccountModel;
import com.lookhed.nighthawk.auth.domain.port.in.CreateAccountUseCase;
import com.lookhed.nighthawk.auth.domain.port.out.AccountRepositoryPort;

public class CreateAccount implements CreateAccountUseCase {
    private final AccountRepositoryPort accountRepositoryPort;

    public CreateAccount(AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Override
    public AccountModel createAccount(AccountModel accountModel) {
        return this.accountRepositoryPort.save(accountModel);
    }
}
