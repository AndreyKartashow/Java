package HomeWork10.model.contact;

import java.util.ArrayList;
import java.util.Objects;

public class Contact {
	private User user;
	ArrayList<Phone> phones;

	public Contact(User user) {
		this.user = user;
		phones = new ArrayList<>();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Contact contact = (Contact) o;
		return Objects.equals(user, contact.user);
	}

	@Override
	public int hashCode() {
		return Objects.hash(user, phones);
	}

	public void addPhone(Phone phone){
		this.phones.add(phone);
	}

	@Override
	public String toString() {
		return "Contact{" +
			 "user=" + user +
			 ", phones=" + phones +
			 '}';
	}
}
