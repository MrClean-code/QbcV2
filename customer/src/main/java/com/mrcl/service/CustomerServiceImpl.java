package com.mrcl.service;

import com.mrcl.model.Customer;
import com.mrcl.rep.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

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
