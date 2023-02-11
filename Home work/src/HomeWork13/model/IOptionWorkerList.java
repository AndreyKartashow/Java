package HomeWork13.model;

public interface IOptionWorkerList {
    String allWorkers(WorkerList listWorker);
    Person addWorker(Person worker, WorkerList listWorker);
    String removeWorker(Integer id, WorkerList listWorker);
    String searchWorker(String name, WorkerList listWorker);
}
