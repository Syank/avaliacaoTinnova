package tinnova.carsCrud.model.converters;

import tinnova.carsCrud.model.enumerations.VehicleBrand;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


/**
 * A converter class to teach to JPA how to convert a {@link VehicleBrand} enum into a valid database value and how
 * to revert it to an enum again
 *
 * @author Rafael Furtado
 */
@Converter
public class VehicleBrandConverter implements AttributeConverter<VehicleBrand, String> {

    @Override
    public String convertToDatabaseColumn(VehicleBrand attribute) {
        return attribute.getValue();
    }

    @Override
    public VehicleBrand convertToEntityAttribute(String dbData) {
        VehicleBrand[] brands = VehicleBrand.values();

        for (int i = 0; i < brands.length; i++) {
            VehicleBrand brand = brands[i];

            if (brand.getValue().equals(dbData)) {
                return brand;
            }

        }

        throw new RuntimeException("Unable to convert the database data \'" + dbData + "\" to the enumeration VehicleBrand");
    }

}
