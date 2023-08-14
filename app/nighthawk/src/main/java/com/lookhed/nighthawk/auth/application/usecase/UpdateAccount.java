package com.lookhed.nighthawk.auth.application.usecase;

import com.lookhed.nighthawk.auth.domain.model.AccountModel;
import com.lookhed.nighthawk.auth.domain.port.in.UpdateAccountUseCase;
import com.lookhed.nighthawk.auth.domain.port.out.AccountRepositoryPort;

import java.util.Optional;

public class UpdateAccount implements UpdateAccountUseCase {
    private final AccountRepositoryPort accountRepositoryPort;

    public UpdateAccount(AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Override
    public Optional<AccountModel> updateAccount(AccountModel accountModel) {
        return this.accountRepositoryPort.update(accountModel);
    }
}
