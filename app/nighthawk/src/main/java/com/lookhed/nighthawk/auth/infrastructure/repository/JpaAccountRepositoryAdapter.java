package com.lookhed.nighthawk.auth.infrastructure.repository;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.lookhed.nighthawk.auth.domain.model.AccountModel;
import com.lookhed.nighthawk.auth.domain.port.out.AccountRepositoryPort;
import com.lookhed.nighthawk.auth.infrastructure.entity.Account;

@Component
public class JpaAccountRepositoryAdapter implements AccountRepositoryPort {

    private final JpaAccountRepository jpaAccountRepository;

    public JpaAccountRepositoryAdapter(JpaAccountRepository jpaAccountRepository) {
        this.jpaAccountRepository = jpaAccountRepository;
    }

    @Override
    public AccountModel save(AccountModel accountModel) {
        Account accountEntity = Account.fromDomainEntity(accountModel);
        Account savedAccountEntity = jpaAccountRepository.save(accountEntity);
        return savedAccountEntity.fromEntityDomain();
    }

    @Override
    public Optional<AccountModel> findById(int id) {
        return this.jpaAccountRepository.findByIdAndAvailableTrue(id).map(Account::fromEntityDomain);
    }

    @Override
    public Optional<AccountModel> update(AccountModel updatedAccountModel) {
        if (jpaAccountRepository.existsByIdAndAvailableTrue(updatedAccountModel.getId())) {
            Account accountEntity = Account.fromDomainEntity(updatedAccountModel);
            Account updatedAccountEntity = jpaAccountRepository.save(accountEntity);
            return Optional.of(updatedAccountEntity.fromEntityDomain());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteAccount(AccountModel accountModel) {
        if (jpaAccountRepository.existsByIdAndAvailableTrue(accountModel.getId())) {
            Account accountEntity = Account.fromDomainEntity(accountModel);
            accountEntity.setAvailable(false);
            Account updatedAccountEntity = jpaAccountRepository.save(accountEntity);
            return true;
        }
        return false;
    }
}
