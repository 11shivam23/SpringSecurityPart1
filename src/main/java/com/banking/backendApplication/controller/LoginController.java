package com.banking.backendApplication.controller;

import com.banking.backendApplication.model.Customer;
import com.banking.backendApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        Customer savedCustomer;
        String exception = null;
        try {
            String hashPwd = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashPwd);
            savedCustomer = customerRepository.save(customer);
            if(savedCustomer.getId() > 0) {
                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are saved successfully");
            }
        } catch (Exception ex) {
            exception = ex.getMessage();

        }
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An exception occured due to " + exception);
    }
}
