package com.ht.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author PragayanshuShukla
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

    private Date timestamp;
    private String message;
    private String details;
}
