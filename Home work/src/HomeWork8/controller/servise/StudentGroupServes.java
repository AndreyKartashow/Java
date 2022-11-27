package HomeWork8.controller.servise;

import HomeWork8.controller.repositories.Util;
import HomeWork8.model.classes.Human;
import HomeWork8.model.classes.Student;
import HomeWork8.model.classes.StudyGroup;
import HomeWork8.model.classes.Teacher;
import HomeWork8.model.interfaces.IStudyGroup;

import java.util.*;


public class StudentGroupServes extends StudyGroup<Human> implements IStudyGroup<Human> {

    private LinkedHashMap<Integer, Human> mapHuman;

    public StudentGroupServes() {
        mapHuman = new LinkedHashMap<>();
    }

    public StudentGroupServes(Human teacher, Human... students) {
        super(teacher, students);

        for (var human : super.getListStudentGroup()) {
            mapHuman.put(human.getId(), human);
        }
    }

    @Override
    public void printAll() {
        System.out.println();
        System.out.println("Полный список:");
        for (Map.Entry<Integer, Human> map : mapHuman.entrySet()) {
            System.out.println("Личный идентификатор " + map.getKey() + ". " + map.getValue());
        }
        if (mapHuman.size() == 0) {
            System.out.println("Список пуст");
        }
    }

    @Override
    public boolean addStudent() {
        Scanner scanner = new Scanner(System.in);
        int size = mapHuman.size();

        System.out.println();
        System.out.println("Введите Фамилию");
        String lastName = scanner.next();
        System.out.println("Введите Имя");
        String firstName = scanner.next();
        System.out.println("Введите Отчество");
        String midlName = scanner.next();
        System.out.println("Введите номер учебной группы");
        String numberGroup = scanner.next();

        Human student = new Student(lastName, firstName, midlName, numberGroup);

        super.getListStudent().add(student);
        mapHuman.put(student.getId(), student);
        Util.writ("Student.txt", student.getId() + " " + student, true);

        System.out.println(student + " Добавлен");

        return mapHuman.size() > size;
    }

    @Override
    public boolean addTeacher() {
        Scanner scanner = new Scanner(System.in);
        int size = mapHuman.size();

        System.out.println();
        System.out.println("Введите Фамилию");
        String lastName = scanner.next();
        System.out.println("Введите Имя");
        String firstName = scanner.next();
        System.out.println("Введите Отчество");
        String midlName = scanner.next();
        System.out.println("Введите наименование дисциплины");
        String discipline = scanner.next();

        Human teacher = new Teacher(lastName, firstName, midlName, discipline);

        super.getListTeacher().add(teacher);
        mapHuman.put(teacher.getId(), teacher);
        Util.writ("Teacher.txt", teacher.getId() + " " + teacher, true);

        System.out.println(teacher + " Добавлен");

        return mapHuman.size() > size;
    }

    @Override
    public boolean removeHuman() {
        int size = mapHuman.size();
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Укажите личный идентификатор");
        int position = Integer.parseInt(scanner.next());

        if (mapHuman.containsKey(position)) {
            mapHuman.remove(position);
        }

        Util.writ("Teacher.txt", "", false);
        Util.writ("Student.txt", "", false);
        for (Map.Entry<Integer, Human> set : mapHuman.entrySet()) {
            if (set.getValue().toString().contains("Преподаватель")) {
                Util.writ("Teacher.txt", set.getKey().toString() + " " + set.getValue().toString(), true);
            } else {
                Util.writ("Student.txt", set.getKey().toString() + " " + set.getValue().toString(), true);
            }
        }

        return mapHuman.size() < size;
    }

    @Override
    public boolean findHuman() {
        List<Human> listSearch = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Введите параметр поиска:");
        String parameter = scanner.next();

        for (Map.Entry<Integer, Human> map : mapHuman.entrySet()) {
            if (map.getValue().toString().contains(parameter)) {
                listSearch.add(map.getValue());
                System.out.println(map.getKey() + " " + map.getValue());
            }
        }

        if (listSearch.size() == 0) {
            System.out.println("Поиск по данному параметру произвести не удалось");
        } else {
            System.out.println("Все возможные совпадения найдены");
        }

        return listSearch.size() > 0;
    }

    public void teacherFileRead() {
        List<String> listPerson = Util.read("Teacher.txt");

        for (String str : listPerson) {
            String[] teacherArray = str.split(" ");

            Human teacher = new Teacher(teacherArray[2], teacherArray[3], teacherArray[4], teacherArray[5]);
            teacher.setId(Integer.parseInt(teacherArray[0]));

            super.getListTeacher().add(teacher);
            mapHuman.put(teacher.getId(), teacher);
        }
    }

    public void studentFileRead() {
        List<String> listPerson = Util.read("Student.txt");

        for (String str : listPerson) {
            String[] studentArray = str.split(" ");

            Human student = new Student(studentArray[2], studentArray[3], studentArray[4], studentArray[5]);
            student.setId(Integer.parseInt(studentArray[0]));

            super.getListStudent().add(student);
            mapHuman.put(student.getId(), student);
        }
    }
}
