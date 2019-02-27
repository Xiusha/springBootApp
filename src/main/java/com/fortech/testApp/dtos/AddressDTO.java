package com.fortech.testApp.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO implements Serializable {

	private static final long serialVersionUID = -2885021484808848439L;
	   
    private String street;

    private String city;

    private String zip;

    private String country;

}
