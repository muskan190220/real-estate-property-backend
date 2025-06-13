package com.realestate.propertyapp.Repository;

import com.realestate.propertyapp.Entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

}
