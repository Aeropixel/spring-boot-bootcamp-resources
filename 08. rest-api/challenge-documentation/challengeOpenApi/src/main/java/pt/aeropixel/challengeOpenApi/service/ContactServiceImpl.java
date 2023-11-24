package pt.aeropixel.challengeOpenApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.aeropixel.challengeOpenApi.exception.ContactNotFoundException;
import pt.aeropixel.challengeOpenApi.pojo.Contact;
import pt.aeropixel.challengeOpenApi.repository.ContactRepository;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact getContactById(String id) {
        return contactRepository.getContact(findIndexById(id));
    }

    @Override
    public void saveContact(Contact contact) {
        contactRepository.saveContact(contact);
    }

    @Override
    public List<Contact> getContacts() {
        return contactRepository.getContacts();
    }


    private int findIndexById(String id) {
        return IntStream.range(0, contactRepository.getContacts().size())
                .filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ContactNotFoundException(id));
    }
}
