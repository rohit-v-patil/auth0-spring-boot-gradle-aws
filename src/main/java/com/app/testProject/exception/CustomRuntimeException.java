package com.app.testProject.exception;

public class CustomRuntimeException extends RuntimeException {

  public CustomRuntimeException(Throwable t) { super(t); }

  public CustomRuntimeException(String message, Throwable t) { super(message, t); }

  public CustomRuntimeException(String message) { super(message); }
}
