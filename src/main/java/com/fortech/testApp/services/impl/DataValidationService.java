package com.fortech.testApp.services.impl;

import com.fortech.testApp.exceptions.UnavailableDataException;

public class DataValidationService {
	
	protected void assertNotNull(Object obj, String message) throws UnavailableDataException {
		if( obj == null ) {
			throw new UnavailableDataException(message);
		}
	}
}
