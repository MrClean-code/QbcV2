package com.mrcl.service;

import com.mrcl.dto.CustomerDto;
import com.mrcl.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    Customer saveCustomer(Customer customer);

    List<CustomerDto> findAll();
}