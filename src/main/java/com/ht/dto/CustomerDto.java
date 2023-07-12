package com.ht.dto;



import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author PragayanshuShukla
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private long id;
    private String username;
    private String name;
    private String phone;
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;
}
