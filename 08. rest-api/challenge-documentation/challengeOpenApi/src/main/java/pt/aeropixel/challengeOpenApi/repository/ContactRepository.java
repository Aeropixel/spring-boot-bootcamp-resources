package pt.aeropixel.challengeOpenApi.repository;

import org.springframework.stereotype.Repository;
import pt.aeropixel.challengeOpenApi.pojo.Contact;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactRepository {

    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact getContact(int index) {
        return contacts.get(index);
    }

    public void saveContact(Contact contact) {
        contacts.add(contact);
    }

}
