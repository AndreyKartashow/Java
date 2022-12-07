package HomeWork8.model.interfaces;

import HomeWork8.model.classes.Human;

public interface IStudyGroup<T extends Human> {
    public void printAll();

    public boolean addStudent();

    public boolean addTeacher();

    public boolean removeHuman();

    public boolean findHuman ();
}
