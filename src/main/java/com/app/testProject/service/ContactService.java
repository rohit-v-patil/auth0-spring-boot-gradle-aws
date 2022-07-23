package com.app.testProject.service;

import com.app.testProject.dto.ContactDTO;
import com.app.testProject.entity.Contact;
import com.app.testProject.exception.ResourceNotFoundException;
import com.app.testProject.mapper.ContactMapper;
import com.app.testProject.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContactService {

  private final ContactMapper contactMapper;
  private final ContactRepository contactRepository;

  public ContactDTO getContact(String emailId) {
    Contact contact = contactRepository.findByEmailId(emailId)
        .orElseThrow(() -> new ResourceNotFoundException("Cannot find the requested Resource"));
    return contactMapper.mapContactToContactDTO(contact);
  }

  public String createContact(ContactDTO contactDTO) {
    Contact contact = contactMapper.mapContactDTOtoContact(contactDTO);
    contact = contactRepository.save(contact);
    log.info("Contact Saved with ID: " + contact.getId().toString());
    return contact.getId().toString();
  }
}
