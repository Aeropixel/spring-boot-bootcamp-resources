package pt.aeropixel.challengeOpenApi.service;

import pt.aeropixel.challengeOpenApi.pojo.Contact;

import java.util.List;

public interface ContactService {
    Contact getContactById(String id);
    void saveContact(Contact contact);
    List<Contact> getContacts();
}
