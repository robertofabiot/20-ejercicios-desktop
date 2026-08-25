package com.example.ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class ContactDao {
    private final List<Contact> contactList = new ArrayList<>();

    public List<Contact> getContactList() {
        return contactList;
    }

    public void addContact(Contact contact){
        contactList.add(contact);
    }

    public Contact searchContact(String name){
        for(Contact contact: contactList){
            if(contact.getName().equals(name)){
                return contact;
            }
        }
        return null;
    }

    public boolean deleteContact(String name){
        for(Contact contact: contactList){
            if(contact.getName().equals(name)){
                return contactList.remove(contact);
            }
        }
        return false;
    }
}
