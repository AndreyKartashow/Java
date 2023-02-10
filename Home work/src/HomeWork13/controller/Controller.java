package HomeWork13.controller;

import HomeWork13.vue.UserInterface;
import HomeWork13.service.Service;

import java.util.Scanner;
import java.util.logging.Logger;

public class Controller {
    Logger logger = Logger.getAnonymousLogger();
    UserInterface userInterface = new UserInterface();
    Service service = new Service();

    public void start() {
        System.out.println();
        System.out.println("Добро пожаловать в \"Список Сотрудников\"");

        boolean terminalActive = true;
        while (terminalActive) {

            userInterface.userMenu();
            String action = chooseAction();

            switch (action) {
                case "1" -> System.out.println("Показать всех"); //get
                case "2" -> postForm(); //postForm
                case "3" -> System.out.println("Удалить старого"); //post
                case "4" -> System.out.println("Найти совпадения"); //get
                case "5" -> terminalActive = false;
            }
        }
    }

    private String chooseAction() {
        Scanner scanner = new Scanner(System.in);
        String operation = "";
        while (!(operation.equals("1") | operation.equals("2") | operation.equals("3") | operation.equals("4") | operation.equals("5"))) {
            System.out.println("Введите цифру с соответствующей операцией и подтвердите действие");
            operation = scanner.next();
        }
        Logger logger = Logger.getAnonymousLogger();
        logger.info("Code menu: " + operation);
        return operation;
    }

    protected boolean isValidForm(String formText) {
        Validator validator = new Validator();
        return validator.isValidLength(formText) &
                validator.isValidName(formText) &
                validator.isValidDate(formText) &
                validator.isValidGender(formText) &
                validator.isValidPhone(formText);
    }


    protected boolean postForm() {
        String data = userInterface.inputForm();
        if (isValidForm(data)) {
            service.initPerson(data);
        }
        logger.info("Форма отправленна на сервер");
        return true;
    }




}
