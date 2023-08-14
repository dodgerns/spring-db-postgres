package com.lookhed.nighthawk.auth.infrastructure.repository;

import java.util.Optional;

import com.lookhed.nighthawk.auth.infrastructure.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByIdAndAvailableTrue(int id);
    boolean existsByIdAndAvailableTrue(int id);
    Optional<Account> findByUsernameAndAvailableTrue(String username);
}
