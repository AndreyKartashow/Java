package HomeWork13.controller;

import HomeWork13.service.Service;
import HomeWork13.vue.UserInterface;

import java.util.Scanner;
import java.util.logging.Logger;

public class ActionController {
    Logger logger = Logger.getAnonymousLogger();
    Validator validator = new Validator();
    UserInterface userInterface = new UserInterface();
    Service service = new Service();


    protected String initStartData() {
        return service.initWorkerList();
    }

    protected String chooseAction() {
        Scanner scanner = new Scanner(System.in);

        String operation = "";
        while (!(operation.equals("1") | operation.equals("2") | operation.equals("3") | operation.equals("4") | operation.equals("5"))) {
            System.out.println("Введите цифру с соответствующей операцией и подтвердите действие");
            operation = scanner.next();
        }
        logger.info("Code menu: " + operation);
        return operation;
    }


    protected boolean postForm() {
        String data = userInterface.inputForm();
        if (validator.isValidForm(data)) {
            logger.info("Запрос на добавление нового сотрудника отправлен на сервер");
            service.initPerson(data);
        }
        return true;
    }

    protected boolean getAll() {
        logger.info("Запрос на получение списка сотрудников отправлен на сервер");
        userInterface.printAll(service.getAllWorker());
        return true;
    }

    protected boolean postRemove() {
        String id = userInterface.inputIndexForRemove();
        if (validator.isValidNumber(id)) {
            logger.info("Запрос на удаление сотрудника отправлен на сервер");
            userInterface.printWorker(service.removePerson(id));
        }
        return true;
    }

    protected boolean getResultSearch() {
        String name = userInterface.inputSearchName();
        if (validator.isValidName(name)) {
            logger.info("Запрос на поиск сотрудников отправлен на сервер");
            userInterface.printWorker(service.searchPerson(name));
        }
        return true;
    }
}
