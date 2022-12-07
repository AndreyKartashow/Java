package HomeWork10.model.contact;

import java.util.Objects;

public class User {
	private String firstName;
	private String lastName;
	private String company;

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return Objects.equals(firstName, user.firstName) && Objects.equals(lastName,
			 user.lastName) && Objects.equals(company, user.company);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, company);
	}

	@Override
	public String toString() {
		return "User{" +
			 "firstName='" + firstName + '\'' +
			 ", lastName='" + lastName + '\'' +
			 ", company='" + company + '\'' +
			 '}';
	}
}
