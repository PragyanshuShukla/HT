package com.ht.repository;

import com.ht.domain.Customer;
import com.ht.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author PragayanshuShukla
 */
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    List<Reservation> findReservationByCustomer(Customer customer);

}
