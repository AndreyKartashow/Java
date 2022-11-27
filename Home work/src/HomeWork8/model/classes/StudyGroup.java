package HomeWork8.model.classes;


import java.util.ArrayList;
import java.util.List;

public class StudyGroup<T extends Human> {
    private List<T> listTeacher;
    private List<T> listStudent;
    private List<T> listStudentGroup;

    {
        this.listTeacher = new ArrayList<>();
        this.listStudent = new ArrayList<>();
        this.listStudentGroup = new ArrayList<>();
    }

    public StudyGroup() {
    }

    @SafeVarargs
    public StudyGroup(T teacher, T... students) {
        this.listTeacher.add(teacher);

        this.listStudent.addAll(List.of(students));

        this.listStudentGroup.add(teacher);
        this.listStudentGroup.addAll(listStudent);
    }

    public List<T> getListTeacher() {
        return listTeacher;
    }

    public List<T> getListStudent() {
        return listStudent;
    }

    public List<T> getListStudentGroup() {
        return listStudentGroup;
    }
}
