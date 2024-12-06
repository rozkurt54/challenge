package org.enoca.challenge.controllers.product;

import org.enoca.challenge.entities.concretes.product.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProductController {

    @GetMapping()
    public ResponseEntity<?> getAll() {

        var list = new ArrayList<Product>();

        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {
        return null;
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Product product) {

        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Product product){

        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        return ResponseEntity.ok().build();

    }


}
