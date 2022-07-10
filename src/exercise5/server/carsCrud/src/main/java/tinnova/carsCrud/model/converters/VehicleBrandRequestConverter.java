package tinnova.carsCrud.model.converters;

import org.springframework.core.convert.converter.Converter;
import tinnova.carsCrud.model.enumerations.VehicleBrand;


public class VehicleBrandRequestConverter implements Converter<String, VehicleBrand> {

    @Override
    public VehicleBrand convert(String source) {
        return VehicleBrand.valueOf(source.toUpperCase());
    }
}