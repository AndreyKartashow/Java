package HomeWork8.model.interfaces;

import HomeWork8.model.classes.Human;

public interface IStudyGroup<T extends Human> {
    public void printAll();

    public boolean addStudent(T human);

    public boolean addTeacher(T human);

    public T removeHuman(String parameter);

    public T findHuman (String parameter);
}
