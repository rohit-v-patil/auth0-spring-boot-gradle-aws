package com.app.testProject.exception;

public class ResourceNotFoundException extends CustomRuntimeException{

  private static final long serialVersionUID = 1891387748892708428L;

  public ResourceNotFoundException(String message) { super(message); }
}
