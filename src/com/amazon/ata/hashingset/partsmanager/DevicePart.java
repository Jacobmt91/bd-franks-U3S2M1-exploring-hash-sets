package com.amazon.ata.hashingset.partsmanager;

import java.util.List;
import java.util.Objects;

// immutable - value can not be change once its assigned
// mutable - value can be changed with setters
public class DevicePart {
    private String manufacturer;                // read-only immutable value
    private String manufacturersPartNumber;     // read-only immutable value
    private List<AmazonDevice> devicesUsedIn;   // read and write mutable value

    public DevicePart(String manufacturer, String manufacturersPartNumber, List<AmazonDevice> devicesUsedIn) {
        this.manufacturer = manufacturer;
        this.manufacturersPartNumber = manufacturersPartNumber;
        this.devicesUsedIn = devicesUsedIn;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getManufacturersPartNumber() {
        return manufacturersPartNumber;
    }

    public List<AmazonDevice> getDevicesUsedIn() {
        return devicesUsedIn;
    }

    public void setDevicesUsedIn(List<AmazonDevice> devicesUsedIn) {
        this.devicesUsedIn = devicesUsedIn;
    }

    public void addDeviceUsedIn(AmazonDevice amazonDevice) {
        devicesUsedIn.add(amazonDevice);
    }

    public void removeDeviceUsedIn(AmazonDevice amazonDevice) {
        devicesUsedIn.remove(amazonDevice);
    }

    @Override
    public String toString() {
        return String.format("Device Part: {manufacturer: %s, manufacturersPartNumber: %s, devicesUsedIn: %s}",
                manufacturer, manufacturersPartNumber, devicesUsedIn);
    }

    // @Override rules: same name, parameters, and return type
    @Override
    public boolean equals(Object o) { // Note: Object is used for the parameter type because the method we are overriding has Object class as a parameter type
        // The next line is for training purposes only
        System.out.println("DevicePart equals()...");
        // if the object being compared is the same as the object your comparing to, they are equal
        if (this == o) return true;

        // if the object being compared is null or a different class than the object your comparing to, they are equal
        if (o == null || getClass() != o.getClass()) return false;

        // instantiating an object of a class used in our comparison (object passed is an Object class object)
        DevicePart that = (DevicePart) o;

        // Use the class data members to determine equality
        // Note the use of the String class .equals to check manufacturer and manufacturerPartNumber
        return getManufacturer().equals(that.getManufacturer()) && getManufacturersPartNumber().equals(that.getManufacturersPartNumber());
    }

    @Override
    public int hashCode() {
        // The next line is for training purposes only
        System.out.println("DevicePart hashCode()...");
        // Use the Java hash() to generate a Hash Code using the immutable data member of the class
        return Objects.hash(getManufacturer(), getManufacturersPartNumber());
    }
}
