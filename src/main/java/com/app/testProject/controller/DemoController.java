package com.app.testProject.controller;

import com.app.testProject.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Validated
@RequiredArgsConstructor
public class DemoController {

  private final ContactService contactService;

  @GetMapping
  public ResponseEntity<String> helloWorld() {
    LocalDateTime now = LocalDateTime.now();
    return ResponseEntity.ok(now.toString());
  }

}
