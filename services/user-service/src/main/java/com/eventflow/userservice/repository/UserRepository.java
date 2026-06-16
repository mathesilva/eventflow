package com.eventflow.userservice.repository;

import com.eventflow.userservice.domain.entity.User;
import com.eventflow.userservice.domain.enums.UserStatus;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User>findByEmail(String email);
    boolean existsByEmail(String email);

    Optional<User> findUserByStatus(User status);

    boolean existsByPassword(String password);
}
