package com.lookhed.nighthawk.user.infrastructure.repository;

import java.util.Optional;

import com.lookhed.nighthawk.user.infrastructure.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByIdAndAvailableTrue(int id);
    boolean existsByIdAndAvailableTrue(int id);
}
