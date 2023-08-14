package com.lookhed.nighthawk.user.infrastructure.config;

import com.lookhed.nighthawk.user.application.usecase.DeleteUser;
import com.lookhed.nighthawk.user.application.usecase.UpdateUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lookhed.nighthawk.user.application.usecase.CreateUser;
import com.lookhed.nighthawk.user.application.service.UserService;
import com.lookhed.nighthawk.user.application.usecase.RetrieveUser;
import com.lookhed.nighthawk.user.domain.port.out.UserRepositoryPort;
import com.lookhed.nighthawk.user.infrastructure.repository.JpaUserRepositoryAdapter;

@Configuration
public class ApplicationConfig {
    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort) {
            return new UserService(new CreateUser(userRepositoryPort),
                    new RetrieveUser(userRepositoryPort),
                    new UpdateUser(userRepositoryPort),
                    new DeleteUser(userRepositoryPort)
            );
    }

    @Bean
    public UserRepositoryPort userRepositoryPort(JpaUserRepositoryAdapter jpaUserRepositoryAdapter) {
        return jpaUserRepositoryAdapter;
    }
}
