package org.enoca.challenge.customer.controllers;


import org.enoca.challenge.cart.dtos.request.CartRowRequestDto;
import org.enoca.challenge.cart.services.ICartService;
import org.enoca.challenge.core.tools.StandardizedResponseUtil;
import org.enoca.challenge.customer.dtos.request.CustomerRequestDto;
import org.enoca.challenge.customer.services.ICustomerService;
import org.enoca.challenge.order.services.IOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final ICustomerService customerService;

    private final ICartService cartService;

    private final IOrderService orderService;

    public CustomerController(ICustomerService customerService, ICartService cartService, IOrderService orderService) {

        this.customerService = customerService;

        this.cartService = cartService;
        this.orderService = orderService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllCustomers() {

        var result = customerService.getAll();

        var message = String.format("%d customer's retrieved", result.size());

        var responseCode = HttpStatus.OK;

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message, result);

        return new ResponseEntity<>(response, responseCode);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneCustomer(@PathVariable String id) {

        var result = customerService.getOne(id);

        var message = String.format("%s id's Customer retrieved", result.getId());

        var responseCode = HttpStatus.OK;

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message, result);

        return new ResponseEntity<>(response, responseCode);

    }

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody CustomerRequestDto customerRequestDto) {

        var result = customerService.create(customerRequestDto);

        var message = String.format("%s id's Customer has been created", result.getId());

        var responseCode = HttpStatus.OK;

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message, result);

        return new ResponseEntity<>(response, responseCode);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable String id, @RequestBody CustomerRequestDto customerRequestDto) {

        var result = customerService.update(id, customerRequestDto);

        var responseCode = HttpStatus.OK;

        var message = String.format("%s id's Customer has been updated", result.getId());

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message, result);

        return new ResponseEntity<>(response, responseCode);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {

        customerService.delete(id);

        var message = String.format("%s id's Customer has been removed", id);

        var responseCode = HttpStatus.OK;

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message);

        return new ResponseEntity<>(response, responseCode);

    }

    @GetMapping("api/v1/{customerId}/cart")
    public ResponseEntity<?> getCustomerCart(@PathVariable String customerId) {

        var customer = customerService.getOneEntity(customerId);

        var customerCart = customer.getCart();

        var customerCartResponseDto = cartService.getMapper().toResponse(customerCart);

        var message = String.format("%s id's cart has been retrieved", customer.getId());

        var responseCode = HttpStatus.OK;

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message, customerCartResponseDto);

        return new ResponseEntity<>(response, responseCode);


    }

    @PostMapping("/api/v1/{customerId}/cart")
    public ResponseEntity<?> addProductToCart(@PathVariable String customerId, @RequestBody List<CartRowRequestDto> cartRowRequestDtos) {

        cartRowRequestDtos
                .forEach(item -> cartService.addProductToCart(customerId, item));

        var cart = customerService.getOneEntity(customerId).getCart();

        var cartResponseDto = cartService.getMapper().toResponse(cart);

        var responseCode = HttpStatus.OK;

        var message = String.format("%d product has been added to cart", cartRowRequestDtos.size());

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message, cartResponseDto);

        return new ResponseEntity<>(response, responseCode);


    }

    @PostMapping("/api/v1/{customerId}/cart/empty-cart")
    public ResponseEntity<?> emptyCart(@PathVariable String customerId) {

        var customer = customerService.getOneEntity(customerId);

        var cart = customer.getCart();

        var blankCart = cartService.emptyCart(cart.getId());

        var responseCode = HttpStatus.OK;

        var message = "All items from customer's cart has been deleted";

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message, blankCart);

        return new ResponseEntity<>(response, responseCode);


    }

    @GetMapping("/api/v1/{customerId}/orders")
    public ResponseEntity<?> getAllOrders(@PathVariable String customerId) {

        var customer = customerService.getOneEntity(customerId);

        var orderList = customer.getOrders();

        var orderResponseDtoList = orderList
                .stream()
                .map(item -> orderService.getMapper().toResponse(item))
                .toList();

        var responseCode = HttpStatus.OK;

        var message = String.format("%d orders have been retrieved", orderResponseDtoList.size());

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message, orderResponseDtoList);

        return new ResponseEntity<>(response, responseCode);


    }

}
