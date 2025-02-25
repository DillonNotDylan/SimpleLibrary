package com.lirbraryapp.backend.repository;

import com.lirbraryapp.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);
    Integer findIsActiveByEmail(String email);
    User findByEmail(String email);
}
