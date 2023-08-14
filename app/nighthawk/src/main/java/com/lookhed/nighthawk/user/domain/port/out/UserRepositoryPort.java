package com.lookhed.nighthawk.user.domain.port.out;

import java.util.Optional;

import com.lookhed.nighthawk.user.domain.model.UserModel;

public interface UserRepositoryPort {
    UserModel save(UserModel userModel);
    Optional<UserModel> findById(int id);
    Optional<UserModel> update(UserModel updatedUserModel);
    boolean deleteUser(UserModel userModel);
}
