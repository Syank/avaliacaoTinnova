package tinnova.carsCrud.model.enumerations;


/**
 * An enumeration class to define all the valid types of brands for vehicles
 *
 * @author Rafael Furtado
 */
public enum VehicleBrand {
    FORD("Ford"),
    BMW("BMW"),
    FERRARI("Ferrari"),
    CHEVROLET("Chevrolet"),
    FIAT("Fiat"),
    HONDA("Honda"),
    HYUNDAI("Hyundai");

    private String value;

    VehicleBrand(String value) {
        this.value = value;

    }

    public String getValue() {
        return this.value;
    }
}
