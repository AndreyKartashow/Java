package HomeWork8.model.classes;

import HomeWork8.model.classes.Human;

public class Student extends Human {
    private String numberGroup;
    private static int code = 100000;
    private  int codeStudent;

    public Student(String lastName, String firstName, String midlName, String numberGroup) {
        super(firstName, midlName, lastName);
        this.numberGroup = numberGroup;
        this.codeStudent = code++;
    }

    public String getNumberGroup() {
        return numberGroup;
    }

    public int getCodeStudent() {
        return codeStudent;
    }


    @Override
    public String toString() {
        return "Student{" +
                "lastName='" + super.getLastName() + '\'' +
                "firstName='" + super.getFirstName() + '\'' +
                "midlName='" + super.getMidlName() + '\'' +
                "numberGroup='" + numberGroup + '\'' +
                "codeStudent='" + codeStudent + '\'' +
                '}';
    }

}
