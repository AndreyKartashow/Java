package HomeWork8;

import HomeWork8.model.classes.Student;

public class Program {
    public static void main(String[] args) {
        Student s1 = new Student("Петр", "Сергеевич", "Иванов", "123А");
        Student s2 = new Student("Петр", "Сергеевич", "Иванов", "123А");
        Student s3 = new Student("Петр", "Сергеевич", "Иванов", "123А");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
