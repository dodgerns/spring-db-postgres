package com.lookhed.nighthawk.auth.domain.port.in;

import com.lookhed.nighthawk.auth.domain.model.AccountModel;

public interface CreateAccountUseCase {
    AccountModel createAccount(AccountModel accountModel);
}
