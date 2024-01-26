package com.banking.backendApplication.controller;

import com.banking.backendApplication.model.Customer;
import com.banking.backendApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        Customer savedCustomer;
        ResponseEntity response = null;
        String pwddd = customer.getPwd();
        String exception = null;
        try {
            String hashPwd = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashPwd);
            customer.setCreateDt(new Date(System.currentTimeMillis()));
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

    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication) {
        List<Customer> customers = customerRepository.findByEmail(authentication.getName());
        if (customers.size() > 0) {
            return customers.get(0);
        } else {
            return null;
        }

    }
}
