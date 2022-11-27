package HomeWork8.model.classes;

import HomeWork8.model.classes.Human;

public class Student extends Human {
    private String numberGroup;
    private static int code = 100000;

    public Student(String lastName, String firstName, String midlName, String numberGroup) {
        super(firstName, midlName, lastName);
        this.numberGroup = numberGroup;
        super.setId(code++);
    }

    public String getNumberGroup() {
        return numberGroup;
    }

    @Override
    public String toString() {
        return "Студент:" +
                " " + super.getLastName() +
                " " + super.getFirstName() +
                " " + super.getMidlName() +
                " " + numberGroup;
    }

}
