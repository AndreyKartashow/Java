package HomeWork13.model;

import java.util.ArrayList;
import java.util.logging.Logger;

public class OptionWorkerList implements IOptionWorkerList {
    Logger logger = Logger.getAnonymousLogger();
    OptionPerson optionPerson = new OptionPerson();

    @Override
    public String allWorkers(WorkerList listWorker) {
        StringBuilder sbWorker = new StringBuilder();

        if (listWorker.list != null) {
            for (Person person : listWorker.list){
                sbWorker.append(optionPerson.getInfo(person) + "\n");
            }
        }

        if (listWorker.list.isEmpty() | listWorker.list == null) {
            logger.info("Список сотрудников пуст");
            return "Лист сотрудников пуст";
        }
        logger.info("Список сотрудников сформирован");
        return sbWorker.toString();
    }

    @Override
    public Person addWorker(Person worker, WorkerList listWorker) {
        listWorker.list.add(worker);
        logger.info("Сотрудник добавлен");
        return worker;
    }

    @Override
    public String removeWorker(Integer id, WorkerList listWorker) {
        String resultAction = "";
        for (Person person : listWorker.list){
            if (id == person.id) {
                resultAction = optionPerson.getInfo(person);
                listWorker.list.remove(person);
                logger.info("Сотрудник удален");

                return resultAction;
            } else {
                logger.info("Введеное ID отсутствует в списке");
            }
        }
        return "Введеное ID отсутствует в списке";
    }

    @Override
    public String searchWorker(String name, WorkerList listWorker) {
        StringBuilder workerFoundList = new StringBuilder();
        for (Person person : listWorker.list){
            if (name.equals(person.midlName) | name.equals(person.firstName) | name.equals(person.lastName)) {
                workerFoundList.append(optionPerson.getInfo(person) + "\n");
            }
        }
        if (workerFoundList.isEmpty()) {
            logger.info("Совпадения не найдены");
            return "Совпадения не найдены";
        }
        return workerFoundList.toString();
    }
}
