package com.mrcl.cont;

import com.mrcl.service.CustomerService;
import com.mrcl.model.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.saveCustomer(customer),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(customerService.findAll(),
                HttpStatus.OK);
    }

}
