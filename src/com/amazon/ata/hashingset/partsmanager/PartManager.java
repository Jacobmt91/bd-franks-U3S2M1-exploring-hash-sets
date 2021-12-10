package com.amazon.ata.hashingset.partsmanager;

import java.util.HashSet;
import java.util.Set;

public class PartManager {
    // instantiate a HashSet of DeviceParts to keep track of what parts we are currently using
    // Hashset and HashCode should only be used on immutable data
    // Set<DevicePart> is a base class or super case while HashSet<> is the subclass or child class (Inheritance is-a relationship)
    private Set<DevicePart> deviceParts = new HashSet<>(); // Elements in a Hash must have a unique Hash Code

    public void addDevicePart(DevicePart devicePart) {
        // Use the Hashset .add() to add the part passed to use to the deviceParts hashSet
        //      .add() automatically calls the hashCode() method to determine the Hash Code
        //      .add() sometimes also calls the equals() method when there is a Hash Code collision
        boolean isAdded = deviceParts.add(devicePart);
    }

    public void printDeviceParts() {
        for (DevicePart devicePart: deviceParts) {
            System.out.println(devicePart);
        }
    }
}
