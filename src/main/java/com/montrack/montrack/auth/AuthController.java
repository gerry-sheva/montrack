package com.montrack.montrack.auth;

import com.montrack.montrack.auth.model.UserAuth;
import com.montrack.montrack.auth.model.dto.*;
import com.montrack.montrack.auth.service.AuthService;
import com.montrack.montrack.user.model.User;
import com.montrack.montrack.user.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
@Log
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<?> register(@RequestBody RegisterRequestDto registerRequestDto) {
        User user = userService.registerUser(new User());
        UserDetails userAuth = authService.registerUserAuth(user, registerRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto userLogin) throws IllegalAccessException {
        log.info("User login request received for user: " + userLogin.getEmail());
        Authentication authentication =
                authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(
                                userLogin.getEmail(),
                                userLogin.getPassword()));

        var ctx = SecurityContextHolder.getContext();
        ctx.setAuthentication(authentication);
        UserAuth userDetails = (UserAuth) authentication.getPrincipal();
        log.info("Token requested for user :" + userDetails.getUsername() + " with roles: " + userDetails.getAuthorities());
        String token = authService.generateToken(authentication);

        LoginResponseDto response = new LoginResponseDto();
        response.setMessage("User logged in successfully");
        response.setToken(token);

        Cookie cookie = new Cookie("sid", token);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Set-Cookie", cookie.getName() + "=" + cookie.getValue() + "; Path=/; HttpOnly");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(response);
    }

    @PostMapping("/pin")
    public ResponseEntity<?> setPin(@RequestBody PinRequestDto pinRequestDto) throws IllegalAccessException {
        PinResponseDto response = authService.setPin(pinRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/forgot")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPwdRequestDto forgotPwdRequestDto) {
        authService.resetPwd(forgotPwdRequestDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
