package com.book.check.repository;

import com.book.check.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    
    Optional<User> findByProviderAndProviderId(String provider, String providerId);
}
