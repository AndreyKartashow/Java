package HomeWork13.model;

public interface IOptionWorkerList {
    void printAllWorkers(WorkerList listWorker);
    Person addWorker(Person worker, WorkerList listWorker);
    void removeWorker(Integer id, WorkerList listWorker);
    Person searchWorker(String name, WorkerList listWorker);
}
