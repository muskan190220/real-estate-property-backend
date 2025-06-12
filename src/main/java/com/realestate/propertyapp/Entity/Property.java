package com.realestate.propertyapp.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long propertyId;

    private String propertyTitle;
    private String description;
    private String location;
    private String ownerName;
    private String ownerContact;
    private String type;
    private String size;
    private Double price;
    private String imageUrl;
    private LocalDateTime listedDate;

    public PropertyEntity() {
    }

    public PropertyEntity(String propertyTitle, String description, String location, String ownerName, String ownerContact, String type, String size, Double price, String imageUrl, LocalDateTime listedDate) {
        this.propertyTitle = propertyTitle;
        this.description = description;
        this.location = location;
        this.ownerName = ownerName;
        this.ownerContact = ownerContact;
        this.type = type;
        this.size = size;
        this.price = price;
        this.imageUrl = imageUrl;
        this.listedDate = listedDate;
    }


    public long getPropertyId() {
        return propertyId;
    }
    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }
    public String getPropertyTitle() {
        return propertyTitle;
    }
    public void setPropertyTitle(String propertyTitle) {
        this.propertyTitle = propertyTitle;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public String getOwnerContact() {
        return ownerContact;
    }
    public void setOwnerContact(String ownerContact) {
        this.ownerContact = ownerContact;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public LocalDateTime getListedDate() {
        return listedDate;
    }
    public void setListedDate(LocalDateTime listedDate) {
        this.listedDate = listedDate;
    }

}
