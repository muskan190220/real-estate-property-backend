package com.realestate.propertyapp.Service;

import com.realestate.propertyapp.Entity.Property;

import java.util.List;

public interface PropertyService {


    // Method to add a new property
    void addProperty(String propertyTitle, String description, String location, String ownerName, String ownerContact, String type, String size, Double price, String imageUrl);

    // Method to update an existing property
    void updateProperty(Long propertyId, String propertyTitle, String description, String location, String ownerName, String ownerContact, String type, String size, Double price, String imageUrl);

    // Method to delete a property
    void deleteProperty(Long propertyId);

    // Method to get all properties
    List<Property> getAllProperties();

    // Method to get a property by ID
    Property getPropertyById(Long propertyId);
}
