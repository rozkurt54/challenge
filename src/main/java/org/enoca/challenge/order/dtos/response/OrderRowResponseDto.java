package org.enoca.challenge.order.dtos.response;

import org.enoca.challenge.core.dtos.responses.ResponseDto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;

public class OrderRowResponseDto extends ResponseDto<String> {

    private final String orderId;

    private final Map<String, String> product;

    private final Map<String, String> unit;

    private final Double quantity;

    private final BigDecimal unitPrice;

    private final BigDecimal tax;

    private final BigDecimal subTotal;

    private final BigDecimal grandTotal;


    public OrderRowResponseDto(String s, Instant createdAt, Instant editedAt, String orderId,
                               Map<String, String> product, Map<String, String> unit, Double quantity,
                               BigDecimal unitPrice, BigDecimal tax, BigDecimal subTotal, BigDecimal grandTotal) {

        super(s, createdAt, editedAt);
        this.orderId = orderId;
        this.product = product;
        this.unit = unit;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.tax = tax;
        this.subTotal = subTotal;
        this.grandTotal = grandTotal;

    }

    public String getOrderId() {

        return orderId;

    }

    public Map<String, String> getProduct() {

        return product;

    }

    public Map<String, String> getUnit() {

        return unit;

    }

    public Double getQuantity() {

        return quantity;

    }

    public BigDecimal getUnitPrice() {

        return unitPrice;

    }

    public BigDecimal getTax() {

        return tax;

    }

    public BigDecimal getSubTotal() {

        return subTotal;

    }

    public BigDecimal getGrandTotal() {

        return grandTotal;

    }

}
