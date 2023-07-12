package com.ht.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

/**
 * @author PragayanshuShukla
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;
    private String name;
    private String phone;
    private String email;
    private String password;
    private Date registrationDate;
}
