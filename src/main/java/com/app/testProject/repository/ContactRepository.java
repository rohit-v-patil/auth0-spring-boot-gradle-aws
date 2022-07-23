package com.app.testProject.repository;

import com.app.testProject.entity.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

  @Query(value = "SELECT c from Contact c WHERE c.emailId=:emailId")
  Optional<Contact> findByEmailId(String emailId);
}
