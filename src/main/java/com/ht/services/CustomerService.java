package com.ht.services;

import com.ht.domain.Customer;
import com.ht.dto.CustomerDto;
import com.ht.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author PragayanshuShukla
 */
@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerDto addCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        customer = customerRepository.save(customer);
        customer.setPassword(null);
        CustomerDto customerDto1 = modelMapper.map(customer,CustomerDto.class);
        return customerDto1;
    }

    public List<CustomerDto> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        customers.forEach(x->x.setPassword(null));
        List<CustomerDto> customerDtoColl = customers
                                           .stream()
                                            .map(y -> modelMapper.map(y, CustomerDto.class))
                                            .toList();
        return customerDtoColl;
    }

    public CustomerDto updateCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        customer = customerRepository.save(customer);
        customer.setPassword(null);
        CustomerDto customerDto1 = modelMapper.map(customer,CustomerDto.class);
        return customerDto1;
    }

}
