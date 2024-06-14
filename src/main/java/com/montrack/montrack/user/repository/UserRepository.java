package com.montrack.montrack.user.repository;

import com.montrack.montrack.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
