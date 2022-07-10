package tinnova.carsCrud.model.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tinnova.carsCrud.model.converters.VehicleBrandRequestConverter;


/**
 * A class to provide configurations settings to the Spring framework
 *
 * @author Rafael Furtado
 */
@Configuration
public class SpringConfiguration implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new VehicleBrandRequestConverter());

    }

}