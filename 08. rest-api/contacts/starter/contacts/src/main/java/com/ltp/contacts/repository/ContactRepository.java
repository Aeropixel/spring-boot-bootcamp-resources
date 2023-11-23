package com.ltp.contacts.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ltp.contacts.pojo.Contact;

@Repository
public class ContactRepository {

        private List<Contact> contacts = new ArrayList<>();
//    Provisory initial data
//    private List<Contact> contacts = Arrays.asList(
//            new Contact("123", "António", "964645079"),
//            new Contact("234", "Nuno", "912321123"),
//            new Contact("345", "Tiago", "932143254")
//            );

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact getContact(int index) {
        return contacts.get(index);
    }

    public void saveContact(Contact contact) {
        contacts.add(contact);
    }

    public void updateContact(int index, Contact contact) {
        contacts.set(index, contact);
    }

    public void deleteContact(int index) {
        contacts.remove(index);
    }

}
