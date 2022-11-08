import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Logger;


public class HomeWork4 {
    public static void main(String[] args) {
        //Задание 1.
        //Пусть дан LinkedList с несколькими элементами.
        //Реализуйте метод, который вернет “перевернутый” список.

        Task1<String> list1 = new Task1<>("груши", "яблоки", "мандарины");
        list1.reverseList();
        list1.printList();

        //Задание 2.
        //Реализуйте очередь с помощью LinkedList со следующими методами:
        //enqueue() - помещает элемент в конец очереди,
        //dequeue() - возвращает первый элемент из очереди и удаляет его,
        //first() - возвращает первый элемент из очереди, не удаляя.

        Task2<Integer> list2 = new Task2<>(1, 2, 3, 4, 5);

        list2.enqueue(6);
        list2.enqueue(7);
        list2.printMyQueue();

        list2.dequeue();
        list2.dequeue();
        list2.printMyQueue();

        System.out.println(list2.first());

    }

}

class Task1<T> {
    private LinkedList<T> list;

    @SafeVarargs
    Task1(T... n) {
        Logger log = Logger.getAnonymousLogger();
        list = new LinkedList<>(Arrays.asList(n));
        log.info("Объект \"Задача 1\" инициализирован");
    }

    public void reverseList() {
        Logger log = Logger.getAnonymousLogger();
        log.info("Запрос на реверс объекта \"Задача 1\"");
        Collections.reverse(list);
        log.info("Реверс объекта выполнен");
    }

    public void printList() {
        Logger log = Logger.getAnonymousLogger();
        log.info("Запрос на вывод объекта \"Задача 1\" в консоль");
        for (T element : list) {
            System.out.print(element + " ");
        }
        log.info("Вывод в консоль выполнен");
        System.out.println();
    }
}

class Task2<T> {
    private LinkedList<T> myQueue;

    @SafeVarargs
    Task2(T... n) {
        Logger log = Logger.getAnonymousLogger();
        myQueue = new LinkedList<>(Arrays.asList(n));
        log.info("Объект \"Задача 2\" инициализирован");
    }

    public void enqueue(T object) {
        Logger log = Logger.getAnonymousLogger();
        log.info("Запрос на добавление нового элемента в очередь");
        myQueue.add(object);
        log.info("Добавление нового элемента выполнено успешно");
    }

    public LinkedList<T> dequeue() {
        Logger log = Logger.getAnonymousLogger();
        log.info("Запрос на получение элемента очереди с последующим удалением");
        myQueue.pollFirst();
        log.info("Вывод элемента из очереди и его удаление выполнено");
        return myQueue;
    }

    public T first() {
        Logger log = Logger.getAnonymousLogger();
        log.info("Запрос на получение первого элемента очереди");
        return myQueue.get(0);
    }

    public void printMyQueue() {
        Logger log = Logger.getAnonymousLogger();
        log.info("Запрос на вывод объекта \"Задача 2\" в консоль");
        for (T element : myQueue) {
            System.out.print(element + " ");
        }
        System.out.println();
        log.info("Вывод в консоль выполнен");
    }
}

class Calc {

}