package com.ht.controller;

import com.ht.config.JwtHelper;
import com.ht.dto.CustomerDto;
import com.ht.dto.LoginResult;
import com.ht.services.CustomerService;
import com.ht.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The auth controller to handle login requests
 *
 * @author PragayanshuShukla
 */
@RestController
@RequestMapping("/api/v1")
public class AuthController {


    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final JwtHelper jwtHelper;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final CustomerService customerService;

    private final AuthenticationProvider authenticationManager;
    public AuthController(JwtHelper jwtHelper, UserDetailsService userDetailsService,
                          PasswordEncoder passwordEncoder, AuthenticationProvider authenticationManager,
                          CustomerService customerService) {
        this.jwtHelper = jwtHelper;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.customerService = customerService;
    }

    @PostMapping(path = "login", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public LoginResult login(
            @RequestParam String username,
            @RequestParam String password) {

        UserDetails userDetails;
        Authentication authentication;
        try {
           authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));

        } catch (UsernameNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found");
        }
//        UserDetails userDetails1  =(UserDetails) authentication.getPrincipal();
        UserDetailsImpl userDetails1  =(UserDetailsImpl) authentication.getPrincipal();
        if (passwordEncoder.matches(password, userDetails1.getPassword())) {
            Map<String, String> claims = new HashMap<>();
            claims.put("username", username);

            String authorities = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(","));
            claims.put("authorities", authorities);
            claims.put("userId", String.valueOf(userDetails1.getId()));

            String jwt = jwtHelper.createJwtForClaims(username, claims);
            logger.info("User Authenticated "+ claims.toString());
            return new LoginResult(jwt);
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
    }


}
