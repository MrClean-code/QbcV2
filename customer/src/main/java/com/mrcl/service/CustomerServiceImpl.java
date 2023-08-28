package com.mrcl.service;

import com.mrcl.dto.CustomerDto;
import com.mrcl.model.Customer;
import com.mrcl.model.Order;
import com.mrcl.order.OrderApi;
import com.mrcl.rep.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<CustomerDto> findAll() {
        List<Customer> customerList = customerRepository.findAll();
        List<Order> orderList = orderApi.findOrderByPrice(1.0, 300000.0);

        List<CustomerDto> customerDtoList = customerList.stream()
                .map(Customer::toCustomerDto)
                .collect(Collectors.toList());

        customerDtoList.stream()
                .forEach(customerDto -> {
                   customerDto.setOrderList(orderList);
                });

        return customerDtoList;
    }
}
