package HomeWork8.model.classes;

public class Teacher extends Human {
    private String discipline;
    private static int code = 100;

    public Teacher(String firstName, String midlName, String lastName, String discipline) {
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
        return "Преподаватель:" + " Фамилия = " + super.getLastName() + " Имя = " + super.getFirstName() + " Отчество = " + super.getMidlName() + " Дисциплина = " + discipline;
    }

}
