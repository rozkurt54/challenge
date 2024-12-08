package org.enoca.challenge.order.controllers;

import org.enoca.challenge.core.tools.StandardizedResponseUtil;
import org.enoca.challenge.order.dtos.response.OrderResponseDto;
import org.enoca.challenge.order.dtos.request.OrderRowRequestDto;
import org.enoca.challenge.order.services.IOrderRowService;
import org.enoca.challenge.order.services.IOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {


    private final IOrderService orderService;

    private final IOrderRowService orderRowService;


    public OrderController(IOrderService orderService, IOrderRowService orderRowService) {
        this.orderService = orderService;
        this.orderRowService = orderRowService;
    }

    @GetMapping()
    public ResponseEntity<?> getAll(@RequestParam(required = false) String productId) {

        List<OrderResponseDto> orders;

        String message;

        Map<String, Object> response;

        var responseCode = HttpStatus.OK;

        if (productId != null) {
            orders = orderService.getOrdersByProductId(productId);
            message = String.format("%d Order's retrieved according to given product id: %s", orders.size(), productId);
            response = StandardizedResponseUtil.createSuccessResponse(responseCode, message, orders);
            return new ResponseEntity<>(response, responseCode);
        }

        orders = orderService.getAll();
        message = String.format("%d Order's retrieved", orders.size());
        response = StandardizedResponseUtil.createSuccessResponse(responseCode, message, orders);
        return new ResponseEntity<>(response, responseCode);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {

        var result = orderService.getOne(id);

        var message = String.format("%s id's order has retrieved", result.getId());

        var responseCode = HttpStatus.OK;

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message, result);

        return new ResponseEntity<>(response, responseCode);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable String id) {

        orderService.delete(id);

        var message = String.format("Order with ID %s has been deleted.", id);

        var responseCode = HttpStatus.OK;

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message);

        return new ResponseEntity<>(response, responseCode);

    }

    @PostMapping("/{id}/rows")
    public ResponseEntity<?> addNewProductToOrder(@PathVariable String id, @RequestBody OrderRowRequestDto orderRowRequestDto) {

        var result = orderService.addRowToOrder(id, orderRowRequestDto);

        var responseCode = HttpStatus.OK;

        var message = String.format("%s product has been added to specified order", "result");

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message, result);

        return new ResponseEntity<>(response, responseCode);

    }


}
