package com.lookhed.nighthawk.auth.application.usecase;

import com.lookhed.nighthawk.auth.domain.model.AccountModel;
import com.lookhed.nighthawk.auth.domain.port.in.DeleteAccountUseCase;
import com.lookhed.nighthawk.auth.domain.port.out.AccountRepositoryPort;

public class DeleteAccount implements DeleteAccountUseCase {
    private final AccountRepositoryPort accountRepositoryPort;

    public DeleteAccount(AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Override
    public boolean deleteAccount(AccountModel accountModel) {
        return this.accountRepositoryPort.deleteAccount(accountModel);
    }
}
