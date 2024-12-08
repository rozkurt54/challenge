package org.enoca.challenge.cart.dtos.response;

import org.enoca.challenge.core.dtos.responses.ResponseDto;
import org.enoca.challenge.customer.dtos.response.CustomerResponseDto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class CartResponseDto extends ResponseDto<String> {



    private final List<CartRowResponseDto> cartItems;

    private final int cartRowCount;

    private final BigDecimal totalTax;

    private final BigDecimal subTotal;

    private final BigDecimal grandTotal;


    public CartResponseDto(String s,
                           Instant createdAt,
                           Instant editedAt,
                           List<CartRowResponseDto> cartItems,
                           int cartRowCount,
                           BigDecimal totalTax,
                           BigDecimal subTotal,
                           BigDecimal grandTotal) {

        super(s, createdAt, editedAt);
         this.cartItems = cartItems;
        this.cartRowCount = cartRowCount;
        this.totalTax = totalTax;
        this.subTotal = subTotal;
        this.grandTotal = grandTotal;

    }

    public List<CartRowResponseDto> getCartItems() {

        return cartItems;

    }

    public int getCartRowCount() {

        return cartRowCount;

    }

    public BigDecimal getTotalTax() {

        return totalTax;

    }

    public BigDecimal getSubTotal() {

        return subTotal;

    }

    public BigDecimal getGrandTotal() {

        return grandTotal;

    }
}
