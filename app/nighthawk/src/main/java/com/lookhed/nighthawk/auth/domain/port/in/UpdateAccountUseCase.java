package com.lookhed.nighthawk.auth.domain.port.in;

import com.lookhed.nighthawk.auth.domain.model.AccountModel;

import java.util.Optional;

public interface UpdateAccountUseCase {
    Optional<AccountModel> updateAccount(AccountModel accountModel);
}
