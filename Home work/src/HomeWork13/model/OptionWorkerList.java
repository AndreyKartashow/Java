package HomeWork13.model;

import java.util.logging.Logger;

public class OptionWorkerList implements IOptionWorkerList {
    Logger logger = Logger.getAnonymousLogger();

    @Override
    public void printAllWorkers(WorkerList listWorker) {
        OptionPerson optionPerson = new OptionPerson();
        for (Person person : listWorker.workerList){
            System.out.println(optionPerson.getInfo(person));
        }
    }

    @Override
    public Person addWorker(Person worker, WorkerList listWorker) {
        listWorker.workerList.add(worker);
        logger.info("Person adding");
        return worker;
    }

    @Override
    public void removeWorker(Integer id, WorkerList listWorker) {
        for (Person person : listWorker.workerList){
            if (id == person.id) {
                listWorker.workerList.remove(person);
                logger.info("Worker remove");
            } else {
                logger.info("ID for worker is not of list");
            }
        }
    }

    @Override
    public Person searchWorker(String name, WorkerList listWorker) {
        OptionPerson optionPerson = new OptionPerson();
        for (Person person : listWorker.workerList){
            if (name.equals(person.midlName) | name.equals(person.firstName) | name.equals(person.lastName)) {
                System.out.println(optionPerson.getInfo(person));
                logger.info("Worker found");
            } else {
                logger.info("Worker not found");
            }
        }
        return null;
    }
}
