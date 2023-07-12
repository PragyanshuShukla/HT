package com.ht.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author PragayanshuShukla
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate check_in_date;
    private LocalDate check_out_date;
    private String special_request;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Customer customer;

}
