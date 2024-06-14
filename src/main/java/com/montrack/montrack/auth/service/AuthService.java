package com.montrack.montrack.auth.service;

import com.montrack.montrack.auth.model.dto.PinRequestDto;
import com.montrack.montrack.auth.model.dto.PinResponseDto;
import com.montrack.montrack.auth.model.dto.RegisterRequestDto;
import com.montrack.montrack.user.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {
    String generateToken(Authentication authentication);
    UserDetails registerUserAuth(User user, RegisterRequestDto registerRequestDto);
    PinResponseDto setPin(PinRequestDto pinRequestDto) throws IllegalAccessException;
}
