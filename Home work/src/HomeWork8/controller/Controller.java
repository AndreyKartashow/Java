package HomeWork8.controller;

import HomeWork8.controller.servise.StudentGroupServes;
import HomeWork8.view.UserInterface;

public class Controller {
    public static void runServer() {
        StudentGroupServes serves = new StudentGroupServes();
        serves.studentFileRead();
        serves.teacherFileRead();

        System.out.println();
        System.out.println("Добро пожаловать в журнал студенческой группы!");

        boolean terminalActive = true;
        while (terminalActive) {
            UserInterface.userMenu();
            String action = UserInterface.chooseAction();

            switch (action) {
                case "1" :
                    serves.printAll();
                    break;
                case "2" :
                    serves.addStudent();
                    break;
                case "3" :
                    serves.addTeacher();
                    break;
                case "4" :
                    serves.removeHuman();
                    break;
                case "5" :
                    serves.findHuman();
                    break;
                case "6" :
                    terminalActive = false;
                    break;
            }
        }
    }
}
