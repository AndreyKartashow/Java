package HomeWork8.model.classes;

import HomeWork8.model.classes.Human;

public class Teacher extends Human {
    private String discipline;

    public Teacher(String firstName, String midlName, String lastName, String discipline) {
        super(firstName, midlName, lastName);
        this.discipline = discipline;
    }


    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "lastName='" + super.getLastName() + '\'' +
                "firstName='" + super.getFirstName() + '\'' +
                "midlName='" + super.getMidlName() + '\'' +
                "discipline='" + discipline + '\'' +
                '}';
    }
}
