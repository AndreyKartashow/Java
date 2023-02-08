package HomeWork13.model;

import java.util.Date;

abstract class PersonBase {

    public String midlName;
    public String firstName;
    public String lastName;
    public Date dateOfBirth;
    public String gender;

    PersonBase(String midlName, String firstName, String lastName, Date dateOfBirth, String gender) {
        this.midlName = midlName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
}
