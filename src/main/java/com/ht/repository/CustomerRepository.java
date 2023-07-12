package com.ht.repository;

import com.ht.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PragayanshuShukla
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findCustomerByUsername(String username);
    Customer findCustomerByEmail(String email);

}
