package com.lookhed.nighthawk.auth.domain.port.out;

import java.util.Optional;

import com.lookhed.nighthawk.auth.domain.model.AccountModel;


public interface AccountRepositoryPort {
    AccountModel save(AccountModel accountModel);
    Optional<AccountModel> findById(int id);
    Optional<AccountModel> update(AccountModel updatedAccountModel);
    boolean deleteAccount(AccountModel accountModel);
}
