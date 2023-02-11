package HomeWork13.model;

import HomeWork13.util.Util;

import java.util.List;

public class Person extends PersonBase {
    private static int counterID = 100000;
    protected int id;
    protected int phone;

    public Person (List<String> dataDB) {
        super(dataDB.get(1), dataDB.get(2), dataDB.get(3), dataDB.get(4), dataDB.get(5));
        this.id = Integer.parseInt(dataDB.get(0));
        this.phone = Integer.parseInt(dataDB.get(6));
    }

    public Person(String[] inputData) {
        super(inputData[0], inputData[1], inputData[2], inputData[3], inputData[4]);
        this.id = ++counterID;
        this.phone = Integer.parseInt(inputData[5]);
        Util.WriteID(this.id);
    }

    public void setCounterID(int id) {
        counterID = id;
    }

    public int getId() {
        return id;
    }
}
