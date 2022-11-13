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