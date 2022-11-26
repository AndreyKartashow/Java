package HomeWork8.system.servise;

import HomeWork8.model.classes.Human;
import HomeWork8.model.classes.StudyGroup;
import HomeWork8.model.interfaces.IStudyGroup;


public class StudentGroupServis extends StudyGroup<Human> implements IStudyGroup<Human> {


    public StudentGroupServis(Human teacher, Human... students) {
        super(teacher, students);
    }

    @Override
    public void printAll() {
    }

    @Override
    public boolean addStudent(Human human) {
        return false;
    }

    @Override
    public boolean addTeacher(Human human) {
        return false;
    }


    @Override
    public Human removeHuman(String parameter) {
        return null;
    }

    @Override
    public Human findHuman(String parameter) {
        return null;
    }
}
