package HomeWork10.model.contact;

import java.util.Objects;

public class Phone {
	private String phoneNumber;

	public Phone(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "phoneNumber: " + phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Phone phone = (Phone) o;
		return phoneNumber.equals(phone.phoneNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(phoneNumber);
	}
}
