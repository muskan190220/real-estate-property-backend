package com.realestate.propertyapp.Repository;

import com.realestate.propertyapp.Entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {

}
