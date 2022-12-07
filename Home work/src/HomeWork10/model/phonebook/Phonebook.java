package HomeWork10.model.phonebook;

import HomeWork10.model.contact.Contact;
import java.util.ArrayList;

public class Phonebook {


	private String name;
	private ArrayList<Contact> contacts;

	public Phonebook(String name){
		this.name = name;
		contacts = new ArrayList<>();
	}

	public void addContact(Contact contact){
		this.contacts.add(contact);
	}

	public ArrayList<Contact> getContacts() {
		return contacts;
	}

	@Override
	public String toString() {
		return this.contacts.toString();
	}
}
