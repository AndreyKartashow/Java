package HomeWork8.controller;

import HomeWork8.controller.servise.StudentGroupServes;
import HomeWork8.view.UserInterface;

public class Controller {
    /**
     * Метод организует логику пользовательского меню в автомате горячих напитков
     * @param machine Принимает инициализированный и заполненный напитками автомат горячих напитков
     */
    public static void runServer() {
        StudentGroupServes serves = new StudentGroupServes();

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
