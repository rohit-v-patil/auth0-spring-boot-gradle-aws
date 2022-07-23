package com.app.testProject.controller;

import com.app.testProject.api.ContactAPI;
import com.app.testProject.dto.ContactDTO;
import com.app.testProject.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/contacts")
public class ContactController implements ContactAPI {

  private final ContactService contactService;

  @Override
  @GetMapping("/{emailId}")
  public ResponseEntity<ContactDTO> getContact(@PathVariable final String emailId) {
    return ResponseEntity.ok(contactService.getContact(emailId));
  }

  @Override
  @PostMapping
  public ResponseEntity<String> postContact(@RequestBody final ContactDTO contactDTO) {
    return ResponseEntity.ok(
        String.format("Contact created successfully with id: %s", contactService.createContact(contactDTO)));
  }
}
