package org.enoca.challenge.order.dtos.response;

import org.enoca.challenge.core.dtos.responses.ResponseDto;
import org.enoca.challenge.customer.dtos.response.CustomerResponseDto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderResponseDto extends ResponseDto<String> {

    private final Map<String, String> customer;

    private final String shippingAddress;

    private final List<OrderRowResponseDto> orderedProducts;

    private final BigDecimal taxTotal;

    private final BigDecimal subTotal;

    private final BigDecimal grandTotal;


    public OrderResponseDto(String s, Instant createdAt, Instant editedAt, Map<String, String> customer,
                            String shippingAddress, List<OrderRowResponseDto> orderedProducts,
                            BigDecimal taxTotal, BigDecimal subTotal, BigDecimal grandTotal) {

        super(s, createdAt, editedAt);
        this.customer = customer;
        this.shippingAddress = shippingAddress;
        this.orderedProducts = orderedProducts;
        this.taxTotal = taxTotal;
        this.subTotal = subTotal;
        this.grandTotal = grandTotal;

    }

    public Map<String, String> getCustomer() {

        return customer;

    }

    public String getShippingAddress() {

        return shippingAddress;

    }

    public List<OrderRowResponseDto> getOrderedProducts() {

        return orderedProducts;

    }

    public BigDecimal getTaxTotal() {

        return taxTotal;

    }

    public BigDecimal getSubTotal() {

        return subTotal;

    }

    public BigDecimal getGrandTotal() {

        return grandTotal;

    }
}
