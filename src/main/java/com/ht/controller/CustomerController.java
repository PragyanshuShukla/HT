package com.ht.controller;


import com.ht.domain.Customer;
import com.ht.dto.CustomerDto;
import com.ht.services.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author PragayanshuShukla
 */

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    private final PasswordEncoder passwordEncoder;
    private final CustomerService customerService;
    private final ModelMapper  modelMapper;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDto>> addAllCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
    @PostMapping(path = "register")
    public ResponseEntity<CustomerDto> login(
            @RequestBody CustomerDto customerDto) {
        customerDto.setPassword(passwordEncoder.encode(customerDto.getPassword()));
        return ResponseEntity.ok(customerService.addCustomer(customerDto));
    }
}
