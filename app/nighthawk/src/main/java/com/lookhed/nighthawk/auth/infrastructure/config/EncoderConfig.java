package com.lookhed.nighthawk.auth.infrastructure.config;

import com.lookhed.nighthawk.auth.infrastructure.entity.Account;
import com.lookhed.nighthawk.auth.infrastructure.repository.JpaAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Optional;

@Configuration
class EncoderConfig {
    @Autowired
    private JpaAccountRepository jpaAccountRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Optional<Account> accountOptional = jpaAccountRepository.findByUsernameAndAvailableTrue(username);
            if (accountOptional.isPresent()) {
                Account account = accountOptional.get();
                return org.springframework.security.core.userdetails.User.builder()
                        .username(account.getUsername())
                        .password(account.getPassword())
                        .roles("USER")
                        .build();
            } else {
                throw new UsernameNotFoundException("User not found with username: " + username);
            }
        };
    }/*
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.builder().
                username("Admin")
                .password(passwordEncoder().encode("Admin")).roles("ADMIN").
                build();
        return new InMemoryUserDetailsManager(userDetails);
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}