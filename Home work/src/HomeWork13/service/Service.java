package HomeWork13.service;

import HomeWork13.model.OptionPerson;
import HomeWork13.model.OptionWorkerList;
import HomeWork13.model.Person;
import HomeWork13.model.WorkerList;
import HomeWork13.util.Util;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Service {
    OptionWorkerList optionWorkerList = new OptionWorkerList();
    OptionPerson optionPerson = new OptionPerson();
    WorkerList workerList = new WorkerList();
    Logger logger = Logger.getAnonymousLogger();


    public String initWorkerList() {
        int maxID = 100;
        logger.info("Поступил запрос на инициализацию существующего списка сотрудников");
        List<String> listData = Util.Read();
        if (listData.isEmpty() | listData == null) {
            return "Значения в базе данных отсутствуют";
        } else {
            for (String dataPerson : listData) {
                Person newPerson = new Person(Arrays.stream(dataPerson.split(" ")).toList());
                if (newPerson.getId() > maxID) {
                    maxID = newPerson.getId();
                    newPerson.setCounterID(maxID);
                }
                optionWorkerList.addWorker(newPerson, workerList);
            }
        }
        return "Запрос на получение данных выполнен";
    }


    public Person initPerson(String data) {
        logger.info("Поступил запрос на инициализацию нового сотрудника");
        String[] dataPerson = data.split(" ");
        Person newPerson = new Person (dataPerson);
        optionWorkerList.addWorker(newPerson, workerList);
        Util.Write(newPerson.midlName, optionPerson.getInfo(newPerson));
        logger.info("Новый сотрудник инициализирован и добавлен в общий список сотрудников");
        return newPerson;
    }


    public String getAllWorker() {
        logger.info("Поступил запрос на получение списка сотрудников");
        if (!workerList.list.isEmpty()) {
            return optionWorkerList.allWorkers(workerList);
        }
        return "Значения в базе данных отсутствуют";
    }

    public String removePerson(String id) {
        logger.info("Поступил запрос на удаление сотрудника из общего списка сотрудников");

        return optionWorkerList.removeWorker(Integer.parseInt(id), workerList);
    }

    public String searchPerson(String name) {
        logger.info("Поступил запрос на поиск сотрудников из общего списка сотрудников");
        return optionWorkerList.searchWorker(name, workerList);
    }

}
