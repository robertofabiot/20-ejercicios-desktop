package com.example.ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class ContactDao {
    private List<Contact> contactList = new ArrayList<>();


    public List<Contact> getContactList() {
        return contactList;
    }

    public void addContact(Contact contact){
        contactList.add(contact);
    }

    public boolean deleteContact(Contact contact){
        return contactList.remove(contact);
    }
}
