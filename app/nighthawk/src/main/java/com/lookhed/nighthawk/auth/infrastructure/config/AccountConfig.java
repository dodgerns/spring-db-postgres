package com.lookhed.nighthawk.auth.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lookhed.nighthawk.auth.application.service.AccountService;
import com.lookhed.nighthawk.auth.application.usecase.CreateAccount;
import com.lookhed.nighthawk.auth.application.usecase.DeleteAccount;
import com.lookhed.nighthawk.auth.application.usecase.RetrieveAccount;
import com.lookhed.nighthawk.auth.application.usecase.UpdateAccount;
import com.lookhed.nighthawk.auth.domain.port.out.AccountRepositoryPort;
import com.lookhed.nighthawk.auth.infrastructure.repository.JpaAccountRepositoryAdapter;


@Configuration
public class AccountConfig {
    @Bean
    public AccountService accountService(AccountRepositoryPort accountRepositoryPort) {
        return new AccountService(new CreateAccount(accountRepositoryPort),
                new RetrieveAccount(accountRepositoryPort),
                new UpdateAccount(accountRepositoryPort),
                new DeleteAccount(accountRepositoryPort)
        );
    }

    @Bean
    public AccountRepositoryPort accountRepositoryPort(JpaAccountRepositoryAdapter jpaAccountRepositoryAdapter) {
        return jpaAccountRepositoryAdapter;
    }
}
