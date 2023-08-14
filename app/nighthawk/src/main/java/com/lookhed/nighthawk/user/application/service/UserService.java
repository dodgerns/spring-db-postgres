package com.lookhed.nighthawk.user.application.service;

import java.util.Optional;

import com.lookhed.nighthawk.user.domain.model.UserModel;
import com.lookhed.nighthawk.user.domain.port.in.CreateUserUseCase;
import com.lookhed.nighthawk.user.domain.port.in.DeleteUserUseCase;
import com.lookhed.nighthawk.user.domain.port.in.RetrieveUserUseCase;
import com.lookhed.nighthawk.user.domain.port.in.UpdateUserUseCase;

public class UserService{
    private final CreateUserUseCase createUserUseCase;
    private final RetrieveUserUseCase retrieveUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    public UserService(
            CreateUserUseCase createUserUseCase,
            RetrieveUserUseCase retrieveUserUseCase,
            UpdateUserUseCase updateUserUseCase,
            DeleteUserUseCase deleteUserUseCase
    ) {
        this.createUserUseCase = createUserUseCase;
        this.retrieveUserUseCase = retrieveUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    public UserModel createUser(UserModel userModel){
        return this.createUserUseCase.createUser(userModel);
    }
    public Optional<UserModel> getUserById(int userId) {
        return this.retrieveUserUseCase.getUserById(userId);
    }
    public Optional<UserModel> updateUser(UserModel updatedUserModel) {
        return this.updateUserUseCase.updateUser(updatedUserModel);
    }
    public boolean deleteUser(UserModel userModel){
        return this.deleteUserUseCase.deleteUser(userModel);
    }
}
