package tinnova.carsCrud.model.enumerations;

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
