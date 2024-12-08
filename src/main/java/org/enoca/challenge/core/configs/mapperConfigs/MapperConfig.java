package org.enoca.challenge.core.configs.mapperConfigs;

import org.enoca.challenge.cart.mappers.CartMapper;
import org.enoca.challenge.cart.mappers.CartRowMapper;
import org.enoca.challenge.cart.mappers.ICartMapper;
import org.enoca.challenge.cart.mappers.ICartRowMapper;
import org.enoca.challenge.cart.services.ICartRowService;
import org.enoca.challenge.cart.services.ICartService;
import org.enoca.challenge.customer.mappers.CustomerMapper;
import org.enoca.challenge.customer.mappers.ICustomerMapper;
import org.enoca.challenge.customer.services.ICustomerService;
import org.enoca.challenge.order.mappers.IOrderMapper;
import org.enoca.challenge.order.mappers.IOrderRowMapper;
import org.enoca.challenge.order.mappers.OrderMapper;
import org.enoca.challenge.order.mappers.OrderRowMapper;
import org.enoca.challenge.order.services.IOrderRowService;
import org.enoca.challenge.order.services.IOrderService;
import org.enoca.challenge.product.mappers.IProductMapper;
import org.enoca.challenge.product.mappers.ProductMapper;
import org.enoca.challenge.product.services.IProductService;
import org.enoca.challenge.unit.services.IUnitService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public IProductMapper productMapper(IUnitService iUnitService) {

        return new ProductMapper(iUnitService);

    }

    @Bean
    public ICartMapper cartMapper(ICartRowService cartRowService) {

        return new CartMapper(cartRowService);

    }


    @Bean
    public ICartRowMapper cartRowMapper(IProductService productService) {

        return new CartRowMapper(productService);

    }

    @Bean
    public ICustomerMapper customerMapper() {

        return new CustomerMapper();

    }

    @Bean
    public IOrderMapper orderMapper(IOrderRowService orderRowService, ICartService cartService, ICartRowService cartRowService ) {

        return new OrderMapper(orderRowService, cartService, cartRowService);

    }

    @Bean
    IOrderRowMapper orderRowMapper(IProductService productService) {

        return new OrderRowMapper(productService);

    }
}
