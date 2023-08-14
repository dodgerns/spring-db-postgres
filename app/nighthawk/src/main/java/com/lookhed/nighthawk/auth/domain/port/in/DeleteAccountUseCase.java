package com.lookhed.nighthawk.auth.domain.port.in;

import com.lookhed.nighthawk.auth.domain.model.AccountModel;

public interface DeleteAccountUseCase {
    boolean deleteAccount(AccountModel accountModel);
}
