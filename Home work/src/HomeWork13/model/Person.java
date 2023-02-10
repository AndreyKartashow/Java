package HomeWork13.model;

import java.util.Date;

public class Person extends PersonBase {
    private int counterID = 100000;
    protected int id;
    protected int phone;

    public Person (String midlName, String firstName, String lastName, String dateOfBirth, String gender, int phone) {
        super(midlName, firstName, lastName, dateOfBirth, gender);
        this.id = ++this.counterID;
        this.phone = phone;
    }

    public Person(String[] arrayData) {
        super(arrayData[0], arrayData[1], arrayData[2], arrayData[3], arrayData[4]);
        this.id = ++this.counterID;
        this.phone = Integer.parseInt(arrayData[5]);
    }

}
