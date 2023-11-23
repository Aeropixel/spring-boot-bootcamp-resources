package com.ltp.contacts.exception;

public class ContactNotFoundException extends RuntimeException {

//    Construtor chamado quando a exception é chamada
    public ContactNotFoundException(String id) {
        super("The id '" + id + "' does not exist in our records");
    }
}
