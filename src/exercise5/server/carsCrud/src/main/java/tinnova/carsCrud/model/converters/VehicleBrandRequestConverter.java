package tinnova.carsCrud.model.converters;

import org.springframework.core.convert.converter.Converter;
import tinnova.carsCrud.model.enumerations.VehicleBrand;


/**
 * A converter class to teach to Spring how to convert a value from a request into a valid {@link VehicleBrand} enum
 *
 * @author Rafael Furtado
 */
public class VehicleBrandRequestConverter implements Converter<String, VehicleBrand> {

    @Override
    public VehicleBrand convert(String source) {
        return VehicleBrand.valueOf(source.toUpperCase());
    }

}