package com.fortech.testApp.exceptions;

public class EmailExistsException extends RuntimeException {

	private static final long serialVersionUID = -2183568305348484850L;

	public EmailExistsException( ) {
      super();
    }

   public EmailExistsException( final String message ) {
      super( message );
   }
}
