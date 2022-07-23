package com.app.testProject.api;

import com.app.testProject.dto.ContactDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = "Contact API")
public interface ContactAPI {

    @ApiOperation(value = "Gets a Contact by ID", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully returns Contact details.", response = ContactDTO.class),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "emailId", value = "email id of Contact",
                    required = true, paramType = "path", dataType = "String")
    })
    ResponseEntity<ContactDTO> getContact(@PathVariable final String emailId);


  @ApiOperation(value = "Creates a new Contact", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully saved contact details", response = String.class),
      @ApiResponse(code = 400, message = "Bad Request")
  })
  ResponseEntity<String> postContact(@RequestBody final ContactDTO contactDTO);
}
