package com.lookhed.nighthawk.user.infrastructure.repository;

import java.util.Optional;

import com.lookhed.nighthawk.user.domain.model.UserModel;
import com.lookhed.nighthawk.user.domain.port.out.UserRepositoryPort;
import com.lookhed.nighthawk.user.infrastructure.entity.Users;

import org.springframework.stereotype.Component;

@Component
public class JpaUserRepositoryAdapter implements UserRepositoryPort {
    private final JpaUserRepository jpaUserRepository;

    public JpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public UserModel save(UserModel userModel) {
        Users userEntity = Users.fromDomainEntity(userModel);
        Users savedUserEntity = jpaUserRepository.save(userEntity);
        return savedUserEntity.fromEntityDomain();
    }

    @Override
    public Optional<UserModel> findById(int id) {
        return this.jpaUserRepository.findByIdAndAvailableTrue(id).map(Users::fromEntityDomain);
    }

    @Override
    public Optional<UserModel> update(UserModel updatedUserModel) {
        if (jpaUserRepository.existsByIdAndAvailableTrue(updatedUserModel.getId())) {
            Users userEntity = Users.fromDomainEntity(updatedUserModel);
            Users updatedUserEntity = jpaUserRepository.save(userEntity);
            return Optional.of(updatedUserEntity.fromEntityDomain());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteUser(UserModel userModel) {
        if (jpaUserRepository.existsByIdAndAvailableTrue(userModel.getId())) {
            Users userEntity = Users.fromDomainEntity(userModel);
            userEntity.setAvailable(false);
            Users updatedUserEntity = jpaUserRepository.save(userEntity);
            return true;
        }
        return false;
    }
}
