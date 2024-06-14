package com.montrack.montrack.auth.repository;

import com.montrack.montrack.auth.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {
    UserAuth findByEmail(String email);
}
