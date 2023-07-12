package com.ht.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 * @author PragayanshuShukla
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String description;
    private int number_of_person;
    private boolean have_private_bathroom;
    private double price;

    @OneToMany
    List<Reservation> reservations;
}
