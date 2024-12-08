package org.enoca.challenge.product.controllers;

import org.enoca.challenge.core.tools.StandardizedResponseUtil;
import org.enoca.challenge.product.dtos.request.ProductRequestDto;
import org.enoca.challenge.product.entities.Product;
import org.enoca.challenge.product.services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {

        var result = productService.getAll();

        var message = String.format("%d products retrieved", result.size());

        var response = StandardizedResponseUtil.createSuccessResponse(HttpStatus.OK, message, result);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {

        var result = productService.getOne(id);

        var message = String.format("%s id's product is retrieved.", result.getId());

        var responseCode = HttpStatus.OK;

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message, result);

        return new ResponseEntity<>(response, responseCode);

    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody ProductRequestDto requestDto) {

        var result = productService.create(requestDto);

        var message = String.format("%s id's Product has been created", result.getId());

        var responseCode = HttpStatus.OK;

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message, result);

        return new ResponseEntity<>(response, responseCode);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody ProductRequestDto productRequestDto){

        var result = productService.update(id, productRequestDto);

        var messages = String.format("%s id's Product has been updated", result.getId());

        var responseCode = HttpStatus.OK;

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, messages, result);

        return new ResponseEntity<>(response, responseCode);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        productService.delete(id);

        var responseCode = HttpStatus.OK;

        var message = String.format("%s id's Product has been deleted.", id);

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message);

        return new ResponseEntity<>(response, responseCode);

    }


}
