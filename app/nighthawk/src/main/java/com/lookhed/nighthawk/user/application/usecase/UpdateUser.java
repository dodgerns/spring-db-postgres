package com.lookhed.nighthawk.user.application.usecase;

import java.util.Optional;

import com.lookhed.nighthawk.user.domain.model.UserModel;
import com.lookhed.nighthawk.user.domain.port.in.UpdateUserUseCase;
import com.lookhed.nighthawk.user.domain.port.out.UserRepositoryPort;

public class UpdateUser implements UpdateUserUseCase {
    private UserRepositoryPort userRepositoryPort;
    public UpdateUser(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<UserModel> updateUser(UserModel updatedUserModel) {
        return userRepositoryPort.update(updatedUserModel);
    }
}
