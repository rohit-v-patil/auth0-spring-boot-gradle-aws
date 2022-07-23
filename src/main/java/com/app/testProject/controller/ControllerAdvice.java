package com.app.testProject.controller;

import com.app.testProject.dto.ErrorResponseDTO;
import com.app.testProject.exception.CustomRuntimeException;
import com.app.testProject.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

  @ExceptionHandler(value = CustomRuntimeException.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponseDTO handleException(CustomRuntimeException e) {
    ErrorResponseDTO response = new ErrorResponseDTO();
    response.setMessage(
        String.format("System exception occurred. Reference number: %d.", new Date().getTime()));
    log.error(response.getMessage() + " " + e.getMessage(), e);
    return response;
  }

  @ExceptionHandler(value = ResourceNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorResponseDTO handleResourceNotFoundException(ResourceNotFoundException e) {
    ErrorResponseDTO response = new ErrorResponseDTO();
    response.setMessage(e.getMessage());
    log.error(response.getMessage(), e);
    return response;
  }
}
