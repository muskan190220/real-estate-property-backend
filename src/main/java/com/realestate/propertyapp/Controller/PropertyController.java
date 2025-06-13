package com.realestate.propertyapp.Controller;

import com.realestate.propertyapp.Entity.Property;
import com.realestate.propertyapp.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

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

    @PostMapping("/api/property/{id}/upload-image")
    public String uploadImage(@PathVariable Long id, @RequestParam("image") MultipartFile file) {
        try {
            Property property = propertyService.getPropertyById(id);
            if (property == null) return "Property not found";

            String folder = "src/main/resources/static/uploads/";
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path path = Paths.get(folder + fileName);

            Files.write(path, file.getBytes());

            String imageUrl = "/uploads/" + fileName;
            property.setImageUrl(imageUrl);
            propertyService.save(property);  // Add save() method in service

            return "Image uploaded successfully! URL: " + imageUrl;
        } catch (IOException e) {
            return "Error uploading image: " + e.getMessage();
        }
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
