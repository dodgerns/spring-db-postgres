package com.lookhed.nighthawk.user.domain.port.in;

import java.util.Optional;

import com.lookhed.nighthawk.user.domain.model.UserModel;

public interface RetrieveUserUseCase {
    Optional<UserModel> getUserById(int userId);
}
