package com.tca.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor 
@AllArgsConstructor
@Data
public class Address {


	private String houseNumber;   	// maps to house_number column in EMP table
    private String street;         // maps to street column in EMP table
    private String city;           // maps to city column in EMP table
    private String pinCode;        // maps to pin_code column in EMP table

    // NO @Id field -- @Embeddable classes do NOT have a primary key
    // NO @Entity 	-- this class does NOT have its own DB table
}
