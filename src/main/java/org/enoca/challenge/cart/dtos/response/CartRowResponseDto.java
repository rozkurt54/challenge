package org.enoca.challenge.cart.dtos.response;

import org.enoca.challenge.core.dtos.responses.ResponseDto;
import org.enoca.challenge.product.dtos.response.ProductResponseDto;
import org.enoca.challenge.product.entities.Product;
import org.enoca.challenge.unit.dtos.responses.UnitResponseDto;
import org.enoca.challenge.unit.entities.Unit;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class CartRowResponseDto extends ResponseDto<String> {

    private final Map<String, String> product;

    private final Double quantity;

    private final Map<String, String> unit;;

    private final BigDecimal price;

    private final BigDecimal total;

    public CartRowResponseDto(String s,
                              Instant createdAt,
                              Instant editedAt,
                              Product product,
                              Double quantity,
                              BigDecimal price,
                              BigDecimal total,
                              Unit unit) {

        super(s, createdAt, editedAt);

        this.product = createProductMap(product);
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.unit = createUnitMap(unit);

    }



    public Double getQuantity() {

        return quantity;

    }

    public BigDecimal getPrice() {

        return price;

    }

    public BigDecimal getTotal() {

        return total;

    }

    public Map<String, String> getProduct() {
        return product;
    }

    public Map<String, String> getUnit() {
        return unit;
    }

    private Map<String,String> createProductMap(Product product) {

        var productMap = new HashMap<String, String>();

        productMap.put("productId", product.getId());
        productMap.put("productName", product.getName());

        return productMap;
    }

    private  Map<String, String> createUnitMap(Unit unit) {

        var unitMap = new HashMap<String, String>();

        unitMap.put("unitId", unit.getId());
        unitMap.put("unitName", unit.getName());
        unitMap.put("unitShortName", unit.getShortName());

        return unitMap;

    }
}
