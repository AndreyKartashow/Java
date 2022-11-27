package HomeWork8.model.classes;

import HomeWork8.model.classes.Human;

public class Teacher extends Human {
    private String discipline;
    private static int code = 100;

    public Teacher(String lastName, String firstName, String midlName, String discipline) {
        super(firstName, midlName, lastName);
        this.discipline = discipline;
        super.setId(code++);
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "Преподаватель:" +
                " " + super.getLastName() +
                " " + super.getFirstName() +
                " " + super.getMidlName() +
                " " + discipline;
    }

}
