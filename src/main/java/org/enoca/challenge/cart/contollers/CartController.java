package org.enoca.challenge.cart.contollers;


import org.enoca.challenge.cart.dtos.request.CartRowRequestDto;
import org.enoca.challenge.cart.services.ICartService;
import org.enoca.challenge.core.tools.StandardizedResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    private final ICartService cartService;

    public CartController(ICartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {

        var result = cartService.getAll();

        var message = String.format("%d carts retrieved", result.size());

        var responseCode = HttpStatus.OK;

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message, result);

        return new ResponseEntity<>(response, responseCode);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {

        var result = cartService.getOne(id);

        var message = String.format("%s id's cart retrieved", result.getId());

        var responseCode = HttpStatus.OK;

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message, result);

        return new ResponseEntity<>(response, responseCode);

    }

    @PostMapping("/{id}")
    public ResponseEntity<?> addProductToCart(@PathVariable String id, @RequestBody CartRowRequestDto cartRowRequestDto) {

        var result = cartService.addProductToCart(id, cartRowRequestDto);

        var responseCode = HttpStatus.OK;

        var message = "Given product has been added to given cart";

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message, result);

        return new ResponseEntity<>(response, responseCode);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> emptyCart(@PathVariable String id) {

        var result = cartService.emptyCart(id);

        var responseCode = HttpStatus.OK;

        var message = "All items removed from given cart";

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message, result);

        return new ResponseEntity<>(response, responseCode);

    }


    @DeleteMapping("/{id}/{rowId}")
    public ResponseEntity<?> deleteProductFromCart(@PathVariable String id, @PathVariable String rowId) {

        // TODO deleteProductFromCart method will be implemented

        var message = "Given cart row has been deleted from the given cart";

        var responseCode = HttpStatus.OK;

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message);

        return new ResponseEntity<>(response, responseCode);
    }

    @PutMapping("/{cartId}/{rowId}")
    public ResponseEntity<?> updateCartRow(@PathVariable String cartId, @PathVariable String rowId, @RequestBody CartRowRequestDto cartRowRequestDto) {


        // TODO updateCartRow method will be implemented

        var message = "Given cart row has been updated to given cart";

        var responseCode = HttpStatus.OK;

        var response = StandardizedResponseUtil.createSuccessResponse(responseCode, message);

        return new ResponseEntity<>(response, responseCode);


    }


}
