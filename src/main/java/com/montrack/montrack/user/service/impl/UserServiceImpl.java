package com.montrack.montrack.user.service.impl;

import com.montrack.montrack.user.model.User;
import com.montrack.montrack.user.repository.UserRepository;
import com.montrack.montrack.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }
}
