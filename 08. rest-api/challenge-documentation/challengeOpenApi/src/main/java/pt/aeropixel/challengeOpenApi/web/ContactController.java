package pt.aeropixel.challengeOpenApi.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import pt.aeropixel.challengeOpenApi.pojo.Contact;
import pt.aeropixel.challengeOpenApi.service.ContactService;

import java.util.List;

@RestController
@Tag(name = "This is the whole class tag", description = "As the title says, this is on the class level")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping(value = "/contact/all", produces = MediaType.APPLICATION_JSON_VALUE) // O argumento "produces" é para o OpenAPI
    @Operation(summary = "Some summary here", description = "Some description here")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of contactszzz", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Contact.class))))
    public ResponseEntity<List<Contact>> getContacts() {
        List<Contact> contacts = contactService.getContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping(value = "/contact/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Some summary here", description = "Some description here")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieval of contact by ID", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Contact.class)))),
            @ApiResponse(responseCode = "404", description = "Contact doesn't exist")
    })
    public ResponseEntity<Contact> getContact(@PathVariable String id) {
        Contact contact = contactService.getContactById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PostMapping(value = "/contact", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Some summary here", description = "Some description here")
    @ApiResponses(value = {
                    @ApiResponse(responseCode = "201", description = "Successful creation of contact"),
                    @ApiResponse(responseCode = "400", description = "Bad Request: unsuccessful submition",  content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact) {
        contactService.saveContact(contact);
        return new ResponseEntity<>(contact, HttpStatus.CREATED);
    }
}
