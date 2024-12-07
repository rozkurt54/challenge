package org.enoca.challenge.core.configs.mapperConfigs;

import org.enoca.challenge.product.mappers.IProductMapper;
import org.enoca.challenge.product.mappers.ProductMapper;
import org.enoca.challenge.unit.mappers.IUnitMapper;
import org.enoca.challenge.unit.services.IUnitService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public IProductMapper productMapper(IUnitMapper iUnitMapper, IUnitService iUnitService) {

        return new ProductMapper(iUnitService, iUnitMapper);

    }

}
