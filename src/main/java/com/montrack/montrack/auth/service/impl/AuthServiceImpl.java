package com.montrack.montrack.auth.service.impl;

import com.montrack.montrack.auth.model.UserAuth;
import com.montrack.montrack.auth.model.dto.PinRequestDto;
import com.montrack.montrack.auth.model.dto.PinResponseDto;
import com.montrack.montrack.auth.model.dto.RegisterRequestDto;
import com.montrack.montrack.auth.repository.UserAuthRepository;
import com.montrack.montrack.auth.service.AuthService;
import com.montrack.montrack.user.model.User;
import com.montrack.montrack.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl  implements AuthService {

    private final JwtDecoder jwtDecoder;
    private final PasswordEncoder passwordEncoder;
    private final UserAuthRepository userAuthRepository;
    private final UserRepository userRepository;
    private final JwtEncoder jwtEncoder;

    @Override
    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();

        String scope = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(6, ChronoUnit.HOURS))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
    }

    @Override
    public UserDetails registerUserAuth(User user, RegisterRequestDto registerRequestDto) {
        String pwd = passwordEncoder.encode(registerRequestDto.getPassword());
        UserAuth userAuth = new UserAuth();
        userAuth.setUser(user);
        userAuth.setEmail(registerRequestDto.getEmail());
        userAuth.setPassword(pwd);
        userAuth.setRole("dumdum");
        return userAuthRepository.save(userAuth);
    }

    @Override
    public PinResponseDto setPin(PinRequestDto pinRequestDto) throws IllegalAccessException {
//        Check whether the user is logged in or not
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalAccessException();
        }
//        Check whether the user has already set a pin
        UserAuth userAuth = userAuthRepository.findByEmail(authentication.getName());
        boolean isUpdating = userAuth.getPin() != null;
//      If the user is updating their pin, make sure that they input their old pin
        if (isUpdating) {
         String oldPin = pinRequestDto.getOldPin();
         if (!oldPin.equals(userAuth.getPin())) {
             throw new IllegalAccessException();
         }
        }
//        Check whether the pin is correct
        if (!pinRequestDto.getNewPin().equals(pinRequestDto.getConfirmPin())) {
            throw new IllegalAccessException();
        }

        userAuth.setPin(pinRequestDto.getNewPin());
        userAuthRepository.save(userAuth);
        return new PinResponseDto(pinRequestDto.getNewPin());
    }
}
