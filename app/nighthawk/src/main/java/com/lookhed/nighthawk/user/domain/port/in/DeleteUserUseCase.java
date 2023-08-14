package com.lookhed.nighthawk.user.domain.port.in;

import com.lookhed.nighthawk.user.domain.model.UserModel;

public interface DeleteUserUseCase {
    boolean deleteUser(UserModel userModel);
}
