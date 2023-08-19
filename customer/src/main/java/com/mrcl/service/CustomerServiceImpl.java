package com.mrcl.service;

import com.mrcl.model.Customer;
import com.mrcl.order.OrderApi;
import com.mrcl.rep.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final OrderApi orderApi;

    @Transactional
    public Customer saveCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Transactional
    public List<Customer> findAll() {
        List<Customer> customerList = customerRepository.findAll();
        customerList.forEach( c -> {
            c.setOrderList(orderApi.findOrderByPrice(1.0, 3000.0));
        });
        return customerList;
    }
}
