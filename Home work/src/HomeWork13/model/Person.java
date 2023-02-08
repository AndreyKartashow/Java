package HomeWork13.model;

import java.util.Date;

public class Person extends PersonBase {
    private int counterID = 100000;
    protected int id;
    protected Integer phone;

    Person (String midlName, String firstName, String lastName, Date dateOfBirth, String gender, Integer phone) {
        super(midlName, firstName, lastName, dateOfBirth, gender);
        this.id = ++this.counterID;
        this.phone = phone;
    }


}
