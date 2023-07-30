package com.mrcl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    @Transactional
    public Customer saveCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Transactional
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}