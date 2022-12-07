package HomeWork10.model.service;

import HomeWork10.model.contact.Contact;
import HomeWork10.model.contact.Phone;
import HomeWork10.model.contact.User;
import java.util.ArrayList;

public interface ContactService <T extends User, E extends Phone>  {

	public boolean isCorrect(T user, ArrayList<E> phones);
	public Contact createContact(T user, ArrayList<E> phones);

}
