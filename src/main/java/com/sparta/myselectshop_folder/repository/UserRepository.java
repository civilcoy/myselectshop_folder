package com.sparta.myselectshop_folder.repository;

import com.sparta.myselectshop_folder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}