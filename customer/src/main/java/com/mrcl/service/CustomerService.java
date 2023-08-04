package com.mrcl.service;

import com.mrcl.model.Customer;
import com.mrcl.rep.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface CustomerService {

    Customer saveCustomer(Customer customer);

    List<Customer> findAll();
}