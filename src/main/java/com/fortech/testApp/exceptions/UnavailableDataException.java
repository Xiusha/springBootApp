package com.fortech.testApp.exceptions;

public class UnavailableDataException extends Exception {

	private static final long serialVersionUID = -5439442963650852648L;
	
	public UnavailableDataException( ) {
      super();
    }


    public UnavailableDataException( final String message ) {
      super( message );
    }
	
}
