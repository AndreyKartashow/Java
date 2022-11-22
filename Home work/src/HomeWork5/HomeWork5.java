package HomeWork5;

import java.util.*;
import java.util.logging.Logger;

public class HomeWork5 {

    public static void main(String[] args) {
        //Задание 1.
        //Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
        //что 1 человек может иметь несколько телефонов.
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.phoneBook();

        //Задание 2.
        //Дан список сотрудников.
        //Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
        //Отсортировать по убыванию популярности.
        List<String> people = Arrays.stream(new String[]{"Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
                "Анна Крутова", "Иван Юрин", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова",
                "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников",
                "Петр Петин", "Иван Ежов"}).toList();

        Workers workers = new Workers(people);

        workers.printListWorkers();
        System.out.println();

        workers.printUnicKeyForListWorkers();
        System.out.println();

        workers.printCountUnicKeyWorkers();
        System.out.println();

        workers.printSortedListWorkers();

        //Задание 3.
        //Реализовать алгоритм пирамидальной сортировки (HomeWork5.HeapSort).
        QueensChess queensChess = new QueensChess(8);
        MyThread tr = new MyThread(queensChess, 0);
        tr.run();


        //Задание 3.
        //Реализовать алгоритм пирамидальной сортировки (HomeWork5.HeapSort).
        int[] sortArr = {12, 6, 4, 1, 15, 10};

        HeapSort.heapSort(sortArr);
        for (int i = 0; i < sortArr.length; i++) {
            System.out.print(sortArr[i] + "\n");
        }
    }
}

class Person {
    protected String name;
    protected String number;

    Person(String firstName, String lastName, String phoneNumber) {
        Logger log = Logger.getAnonymousLogger();
        name = firstName + " " + lastName;
        number = phoneNumber;
        log.info("Зарегистрирован новый контакт: " + getDataPerson());
    }

    /**
     * Метод предназначен для вывода контактных данных о человеке
     *
     * @return Возвращает строковое представление данных
     * о человеке (имя, фамилия, номер телефона)
     */
    protected String getDataPerson() {
        return name + " " + number;
    }
}

class PhoneBook {
    boolean flagProgram = true;
    HashMap<String, String> mapContact = new HashMap<>();
    Logger log = Logger.getAnonymousLogger();

    /**
     * Метод реализует телефонную книгу
     */
    public void phoneBook() {
        while (flagProgram) {
            printMenuProgram();
            String action = сaseAction();
            switch (action) {
                case "1" -> appendNewContact();
                case "2" -> printAllContacts();
                case "3" -> exitProgram();
            }
        }
    }

    /**
     * Этот метод выводит в консоль главное меню телефонной книги
     */
    private void printMenuProgram() {
        System.out.println("В этой телефонной книге вы можете: "
                + "добавить новый контакт"
                + "посмотреть все контакты");
        System.out.println();
    }

    /**
     * Этот метод выводит в консоль список возможных действий в телефонной книге
     * и ожидает ввода данных от пользователя
     * return Возвращает строковое представление номера выбранного действия
     */
    private String сaseAction() {
        System.out.println("Выберите действие введя цифру в консоль:");
        System.out.println("1 - добавить новый контакт");
        System.out.println("2 - посмотреть все контакты");
        System.out.println("3 - выйти из книги");
        System.out.println();

        Scanner scan = new Scanner(System.in);

        String action = "";
        while (!(action.equals("1") | action.equals("2") | action.equals("3"))) {
            action = scan.next();
        }

        switch (action) {
            case "1" -> log.info("Пользователь хочет добавить новый контакт");
            case "2" -> log.info("Пользователь хочет посмотреть все контакты");
            case "3" -> log.info("Пользователь вышел из программы");
        }

        scan.reset();
        return action;
    }

    /**
     * Метод предназначен для добавления нового контакта в телефонную книгу,
     * если контакт с таким именем существует, то к старому номеру добавляется новый
     *
     * @return Возвращает данные о новом контакте
     */
    private String appendNewContact() {
        Scanner scanner = new Scanner(System.in);

        String[] date = scanner.nextLine().split(" ");
        Person person = new Person(date[0], date[1], date[2]);

        if (mapContact.containsKey(person.name)) {
            String temp = mapContact.get(person.name);
            mapContact.replace(person.name, temp + " " + person.number);
            log.info("Контакт " + person.name + " обновлен");
        } else {
            mapContact.put(person.name, person.number);
            log.info("Новый контакт добавлен");
        }

        scanner.reset();
        return person.getDataPerson();
    }

    /**
     * Метод выводит в консоль всю коллекцию с телефонными контактами
     */
    private void printAllContacts() {
        for (Map.Entry<String, String> set : mapContact.entrySet()) {
            System.out.println(set.getKey() + " = " + set.getValue());
        }
        log.info("Телефонная книга полностью выведена на экран");
    }

    /**
     * Метод изменяет логический флаг цикла программы с true на false
     * и позволяет пользователю выйти из нее
     */
    private void exitProgram() {
        flagProgram = false;
    }

}

class Workers {
    protected HashMap<String, String> mapWorkers = new HashMap<>();
    protected HashSet<String> setUnicKey = new HashSet<>();
    protected List<String> listWorkers = new ArrayList<>();
    private Logger logger = Logger.getAnonymousLogger();

    Workers(List<String> workersList) {
        logger.info("Инициализации списка сотрудников");
        listWorkers = workersList;
        logger.info("Инициализации уникальных ключей карты сотрудников");
        setUnicKey = getUnicKeyForListWorkers();

        logger.info("Карта сотрудников инициализирована");
    }

    /**
     * Метод выводит в консоль всех сотрудников из списка
     */
    public void printListWorkers() {
        logger.info("Запрос на вывод списка сотрудников в консоль");
        for (String person : listWorkers) {
            System.out.println(person);
        }
        logger.info("Список сотрудников успешно выведен в консоль");
    }

    /**
     * Метод перебирает список сотрудников и оставляет только уникальные ключи
     *
     * @return Возвращает коллекцию <b>Set</b> с уникальными значениями
     */
    private HashSet<String> getUnicKeyForListWorkers() {
        for (String set : listWorkers) {
            String[] setArray = set.split(" ");
            setUnicKey.add(setArray[0]);
        }
        return setUnicKey;
    }

    /**
     * Метод выводит в консоль уникальные ключи из списка сотрудников
     */
    public void printUnicKeyForListWorkers() {
        logger.info("Запрос на вывод уникальных ключей из списка сотрудников");
        System.out.println(setUnicKey);
        logger.info("Уникальные ключи из списка сотрудников успешно выведены в консоль");
    }

    /**
     * Метод выводит в консоль количество повторений уникальных ключей из списка сотрудников
     *
     * @return Возвращает карту уникальных значений и количество их повторений в списке сотрудников
     */
    public HashMap<String, String> getCountUnicKeyListWorkers() {
        logger.info("Запрос на подсчет количества повторений уникальных ключей из списка сотрудников");
        HashMap<String, String> mapCountValueForUnicKey = new HashMap<>();

        for (String set : listWorkers) {
            String[] setArray = set.split(" ");
            if (! mapCountValueForUnicKey.containsKey(setArray[0])) {
                mapCountValueForUnicKey.put(setArray[0], "1");
            } else {
                String temp = Integer.toString(Integer.parseInt(mapCountValueForUnicKey.get(setArray[0])) + 1);
                mapCountValueForUnicKey.replace(setArray[0], temp);
            }
        }

        logger.info("Подсчет количества повторений уникальных ключей из списка сотрудников выполнен успешно");
        return mapCountValueForUnicKey;
    }

    /**
     * Метод выводит в консоль уникальные ключи и количество их повторений в списке сотрудников
     */
    public void printCountUnicKeyWorkers() {
        for (Map.Entry<String, String> map : getCountUnicKeyListWorkers().entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }
    }

    /**
     * Метод сортирует список сотрудников в соответствии с уменьшением популярности ключей
     * @return Возвращает отсортированную карту сотрудников
     */
    public List<String> getSortedListWorkers() {
        logger.info("Запрос на получение отсортированного списка сотрудников");
        List<String> sortedListWorkers = new ArrayList<>();
        HashMap<String, String> countUnicKeyMapWorkers = getCountUnicKeyListWorkers();
        int maxValue = 0;

        for (Map.Entry<String, String> set : countUnicKeyMapWorkers.entrySet()) {
            if (Integer.parseInt(set.getValue()) > maxValue) {
                maxValue = Integer.parseInt(set.getValue());
            }
        }

        while (maxValue != 0) {
            for (Map.Entry<String, String> set : countUnicKeyMapWorkers.entrySet()) {
                if (Integer.parseInt(set.getValue()) == maxValue) {
                    for (String person : listWorkers) {
                        String[] personArray = person.split(" ");
                        if (personArray[0].equals(set.getKey())) {
                            sortedListWorkers.add(personArray[0] + " " + personArray[1]);
                        }
                    }
                }
            }
            maxValue--;
        }
        logger.info("Запрос на получение отсортированного списка сотрудников выполнен успешно");
        return sortedListWorkers;
    }

    /**
     * Метод выводит в консоль отсортированую карту сотрудником
     * в соответствии с уменьшением популярности
     */
    public void printSortedListWorkers() {
        logger.info("Запрос на вывод в консоль отсортированного списка");
        for (String set : getSortedListWorkers()) {
            System.out.println(set);
        }
        logger.info("Вывод в консоль отсортированного списка выполнен успешно");
    }
}

class QueensChess {
    protected int SIZE ;
    protected int board[][];
    protected int results_count = 0;
    private int threadsCount;
    public QueensChess(){
    }
    public QueensChess(int N){
        SIZE=N;
        board=new int [N][N];
        //zan=new boolean [N][N];
        results_count=0;
    }
    public boolean tryQueen(int a, int b){
        for (int i = 0; i < a; ++i)
            if (board[i][b]==1)
                return false;
        for (int i = 1; i <= a && b - i >= 0; ++i)
            if (board[a - i][b - i]==1)
                return false;

        for (int i = 1; i <= a && b + i < SIZE; i++)
            if (board[a - i][b + i]==1)
                return false;

        return true;
    }
    public void setQueen(int a) throws InterruptedException {
        for(int i = 0; i < SIZE; ++i){
            if (tryQueen(a, i)) {
                board[a][i] = 1;
                Thread thr = new MyThread(this,a+1);
                thr.start();
                thr.join();
                board[a][i] = 0;
            }
        }
        return;
    }
    public  void showBoard(){
        for (int a = 0; a < SIZE; ++a)
        {
            for (int b = 0; b < SIZE; ++b)
            {
                System.out.print((board[a][b]==1) ? "X " : "0 ");
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (int a = 0; a < SIZE; ++a) {
            for (int b = 0; b < SIZE; ++b) {
                if(board[a][b]==1)
                    builder.append( "Q ");
                else
                    builder.append( ". ");
            }
        }
        String completedString = builder.toString();
        return completedString;
    }
}
class MyThread extends Thread {
    private volatile QueensChess clock;
    private volatile int position;

    public MyThread(QueensChess clock1, int pos) {
        position = pos;
        clock = clock1;
    }

    @Override
    public void run() {
        try {
            if (position == clock.SIZE) {
                ++clock.results_count;
                System.out.print("Result #" + clock.results_count + '\n');
                clock.showBoard();
                return;
            }
            for (int i = 0; i < clock.SIZE; ++i) {
                if (clock.tryQueen(position, i)) {
                    clock.board[position][i] = 1;
                    Thread thr = new MyThread(clock, position + 1);
                    thr.start();
                    thr.join();
                    clock.board[position][i] = 0;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class HeapSort {
    //вернуть левого потомка `A[i]`
    private static int LEFT(int i) {
        return (2 * i + 1);
    }

    //вернуть правого потомка `A[i]`
    private static int RIGHT(int i) {
        return (2 * i + 2);
    }

    //вспомогательная функция для замены двух индексов в массиве
    private static void swap(int[] sortArr, int i, int j) {
        int swap = sortArr[i];
        sortArr[i] = sortArr[j];
        sortArr[j] = swap;
    }

    //рекурсивный алгоритм heapify-down. Узел с индексом `i` и 2 его прямых потомка нарушают свойство кучи
    private static void heapify(int[] sortArr, int i, int size) {
        // получить левый и правый потомки узла с индексом `i`
        int left = LEFT(i);
        int right = RIGHT(i);
        int largest = i;

        //сравниваем `A[i]` с его левым и правым дочерними элементами и находим наибольшее значение
        if (left < size && sortArr[left] > sortArr[i]) largest = left;
        if (right < size && sortArr[right] > sortArr[largest]) largest = right;

        //поменяться местами с потомком, имеющим большее значение и вызовите heapify-down для дочернего элемента
        if (largest != i) {
            swap(sortArr, i, largest);
            heapify(sortArr, largest, size);
        }
    }

    //функция для удаления элемента с наивысшим приоритетом (присутствует в корне)
    public static int pop(int[] sortArr, int size) {
        //если в куче нет элементов
        if (size <= 0) {
            return -1;
        }
        int top = sortArr[0];

        //заменяем корень кучи последним элементом массива
        sortArr[0] = sortArr[size - 1];
        //вызовите heapify-down на корневом узле
        heapify(sortArr, 0, size - 1);
        return top;
    }

    //функция для выполнения пирамидальной сортировки массива `A` размера `n`
    public static void heapSort(int[] sortArr) {
        //строим приоритетную очередь и инициализируем ее заданным массивом
        int n = sortArr.length;

        //build-heap: вызывать heapify, начиная с последнего внутреннего
        //узел до корневого узла
        int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(sortArr, i--, n);
        }

        //несколько раз извлекаем из кучи, пока она не станет пустой
        while (n > 0) {
            sortArr[n - 1] = pop(sortArr, n);
            n--;
        }
    }

}