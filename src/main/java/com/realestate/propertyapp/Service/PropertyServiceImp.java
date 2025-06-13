package com.realestate.propertyapp.Service;


import com.realestate.propertyapp.Entity.Property;
import com.realestate.propertyapp.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImp implements PropertyService{

    
    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyServiceImp(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public String addProperty(String propertyTitle, String description, String location, String ownerName, String ownerContact, String type, String size, Double price, String imageUrl) {
        Property property = new Property(propertyTitle, description, location, ownerName, ownerContact, type, size, price, imageUrl, LocalDateTime.now());
        propertyRepository.save(property);
        return propertyTitle;
    }

    @Override
    public void updateProperty(Long propertyId, String propertyTitle, String description, String location, String ownerName, String ownerContact, String type, String size, Double price, String imageUrl) {
        Optional<Property> optionalProperty = propertyRepository.findById(propertyId);

        if (optionalProperty.isPresent()) {
            Property property = optionalProperty.get();
            property.setPropertyTitle(propertyTitle);
            property.setDescription(description);
            property.setLocation(location);
            property.setOwnerName(ownerName);
            property.setOwnerContact(ownerContact);
            property.setType(type);
            property.setSize(size);
            property.setPrice(price);
            property.setImageUrl(imageUrl);

            // Save the updated entity
            propertyRepository.save(property);
        }
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public Property getPropertyById(Long propertyId) {
        return propertyRepository.findById(propertyId).orElse(null);
    }

    @Override
    public void save(Property property) {
            propertyRepository.save(property);
        }
    }


