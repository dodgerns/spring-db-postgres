package com.lookhed.nighthawk.user.application.usecase;

import com.lookhed.nighthawk.user.domain.model.UserModel;
import com.lookhed.nighthawk.user.domain.port.in.DeleteUserUseCase;
import com.lookhed.nighthawk.user.domain.port.out.UserRepositoryPort;

public class DeleteUser implements DeleteUserUseCase {

    private UserRepositoryPort userRepositoryPort;

    public DeleteUser(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public boolean deleteUser(UserModel userModel) {
        return this.userRepositoryPort.deleteUser(userModel);
    }
}
