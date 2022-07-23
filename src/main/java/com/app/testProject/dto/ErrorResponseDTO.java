package com.app.testProject.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Data
@EqualsAndHashCode(callSuper = false)
public class ErrorResponseDTO implements Serializable {

  private String message;
}
