package com.lookhed.nighthawk.user.application.usecase;

import com.lookhed.nighthawk.user.domain.model.UserModel;
import com.lookhed.nighthawk.user.domain.port.in.CreateUserUseCase;
import com.lookhed.nighthawk.user.domain.port.out.UserRepositoryPort;

public class CreateUser implements CreateUserUseCase {
    private final UserRepositoryPort userRepositoryPort;

    public CreateUser(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public UserModel createUser(UserModel userModel) {
        return this.userRepositoryPort.save(userModel);
    }
}
