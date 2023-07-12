package com.ht.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

/**
 * @author PragayanshuShukla
 */
@Data
@RequiredArgsConstructor
public class LoginResult {

    @NonNull
    private String jwt;
}