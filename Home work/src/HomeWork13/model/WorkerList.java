package HomeWork13.model;

import HomeWork13.model.Person;

import java.util.ArrayList;
import java.util.List;

public class WorkerList {
    protected ArrayList<Person> workerList;

    public WorkerList() {}
    public WorkerList(Person ...person) {
        this.workerList.addAll(List.of(person));
    }
}
