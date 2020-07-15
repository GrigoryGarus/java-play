package io.github.phonebook;

import java.util.ArrayList;
import java.util.List;

public enum ContactStorage {
    INSTANCE;

    private final List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return contacts;
    }
}
