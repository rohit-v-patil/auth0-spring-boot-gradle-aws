package com.app.testProject.mapper;

import com.app.testProject.config.Constants;
import com.app.testProject.dto.ContactDTO;
import com.app.testProject.entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = Constants.COMPONENT_MODEL_SPRING)
public interface ContactMapper {

  @Mapping(target = "firstName", source = "firstName")
  @Mapping(target = "lastName", source = "lastName")
  @Mapping(target = "emailId", source = "emailId")
  @Mapping(target = "phone", source = "phone")
  ContactDTO mapContactToContactDTO(Contact contact);

  @Mapping(target = "id", ignore = true)
  Contact mapContactDTOtoContact(ContactDTO contactDTO);
}
