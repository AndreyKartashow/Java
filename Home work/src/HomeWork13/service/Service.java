package HomeWork13.service;

import HomeWork13.model.OptionWorkerList;
import HomeWork13.model.Person;
import HomeWork13.model.WorkerList;
import java.util.logging.Logger;

public class Service {
    OptionWorkerList optionWorkerList = new OptionWorkerList();
    WorkerList workerList = new WorkerList();
    Logger logger = Logger.getAnonymousLogger();

    public Person initPerson(String data) {
        String[] dataPerson = data.split(" ");
        Person newPerson = new Person (dataPerson);
        optionWorkerList.addWorker(newPerson, workerList);
        logger.info("Новый сотрудник инициализирован и добавлен в общий список сотрудников");
        return newPerson;
    }
}
