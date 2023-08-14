package com.lookhed.nighthawk.user.application.usecase;

import java.util.Optional;

import com.lookhed.nighthawk.user.domain.model.UserModel;
import com.lookhed.nighthawk.user.domain.port.in.RetrieveUserUseCase;
import com.lookhed.nighthawk.user.domain.port.out.UserRepositoryPort;

public class RetrieveUser implements RetrieveUserUseCase {

    private final UserRepositoryPort userRepositoryPort;
    public RetrieveUser(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }
    @Override
    public Optional<UserModel> getUserById(int userId) {
        return this.userRepositoryPort.findById(userId);
    }
}
