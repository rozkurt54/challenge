package org.enoca.challenge.customer.controllers;


import org.enoca.challenge.customer.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @GetMapping()
    public ResponseEntity<?> getAllCustomers() {

        var list = new ArrayList<Customer>();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneCustomer(@PathVariable String id) {

        return new ResponseEntity<>(id, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {

        return new ResponseEntity<>(customer, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {

        return new ResponseEntity<>(customer, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {

        return ResponseEntity.ok().build();

    }

}
