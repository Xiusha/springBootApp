package com.fortech.testApp.exceptions;

public class DataNotFoundException extends RuntimeException
{
   private static final long serialVersionUID = -4391440105982937276L;


   public DataNotFoundException( ) {
      super();
   }

   public DataNotFoundException( final String message ) {
      super( message );
   }

}
