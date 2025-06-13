package com.realestate.propertyapp.Controller;

import com.realestate.propertyapp.Entity.Property;
import com.realestate.propertyapp.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/api/properties")
    public List<Property> getProperties() {
        return propertyService.getAllProperties();
    }

    @GetMapping("/api/property/{id}")
    public Property getPropertyById(@PathVariable Long id) {
        return propertyService.getPropertyById(id);
    }

    @PostMapping("/api/property/add")
    public String addProperty(@RequestBody Property property) {
        propertyService.addProperty(
                property.getPropertyTitle(), property.getDescription(), property.getLocation(),
                property.getOwnerName(), property.getOwnerContact(), property.getType(),
                property.getSize(), property.getPrice(), property.getImageUrl()
        );
        return "Property added successfully!";
    }

    @PutMapping("/api/property/update/{id}")
    public String updateProperty(@PathVariable Long id, @RequestBody Property property) {
        propertyService.updateProperty(
                id, property.getPropertyTitle(), property.getDescription(), property.getLocation(),
                property.getOwnerName(), property.getOwnerContact(), property.getType(),
                property.getSize(), property.getPrice(), property.getImageUrl()
        );
        return "Property updated successfully!";
    }

    @DeleteMapping("/api/property/delete/{id}")
    public void deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
    }
}
