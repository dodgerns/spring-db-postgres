package com.lookhed.nighthawk.auth.application.usecase;

import com.lookhed.nighthawk.auth.domain.model.AccountModel;
import com.lookhed.nighthawk.auth.domain.port.in.RetrieveAccountUseCase;
import com.lookhed.nighthawk.auth.domain.port.out.AccountRepositoryPort;

import java.util.Optional;

public class RetrieveAccount implements RetrieveAccountUseCase {
    private final AccountRepositoryPort accountRepositoryPort;

    public RetrieveAccount(AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Override
    public Optional<AccountModel> getAccountById(int id) {
        return this.accountRepositoryPort.findById(id);
    }
}
