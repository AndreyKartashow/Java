import java.util.*;
import java.util.logging.Logger;


public class HomeWork4 {
    public static void main(String[] args) {
        //Задание 1.
        //Пусть дан LinkedList с несколькими элементами.
        //Реализуйте метод, который вернет “перевернутый” список.

        Task1<String> list1 = new Task1<>("груши", "яблоки", "мандарины");
        list1.printList();
        list1.reverseList();
        list1.printList();
        System.out.println();

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
        System.out.println();

        //Задание 3*.
        //В калькулятор добавьте возможность отменить последнюю операцию
        //Вместо этого переделал калькулятор на расчет простого выражения (без приоритета по скобкам)

        Calc calc = new Calc("2+2*1+2*3+4/2-1");
        System.out.println(calc.equete);
        calc.calculation();
        System.out.println(calc.result);
        System.out.println();

        //Задание 4.
        //Реализовать алгоритм перевода из инфиксной записи в постфиксную
        //для арифметического выражения.

        String a = PostfixNotationUtils.convertInfixToPostfix("2+2*3");
        System.out.println(a);
        String b = PostfixNotationUtils.calculatePostfixExpression(a);
        System.out.println(b);


    }

}

class Task1<T> {
    private final LinkedList<T> list;

    @SafeVarargs
    Task1(T... n) {
        Logger log = Logger.getAnonymousLogger();
        list = new LinkedList<>(Arrays.asList(n));
        log.info("Объект \"Задача 1\" инициализирован");
    }

    /**
     * Возвращает текущий <b>LinkedList<T></b> в обратном порядке.
     */
    public void reverseList() {
        Logger log = Logger.getAnonymousLogger();
        log.info("Запрос на реверс объекта \"Задача 1\"");
        Collections.reverse(list);
        log.info("Реверс объекта выполнен");
    }

    /**
     * Выводит в консоль все элементы текущей коллекции
     */
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
    private final LinkedList<T> myQueue;

    @SafeVarargs
    Task2(T... n) {
        Logger log = Logger.getAnonymousLogger();
        myQueue = new LinkedList<>(Arrays.asList(n));
        log.info("Объект \"Задача 2\" инициализирован");
    }

    /**
     * Добавляет элемент в конец коллекццции
     * @param object объект, добавляемый в коллекцию
     */
    public void enqueue(T object) {
        Logger log = Logger.getAnonymousLogger();
        log.info("Запрос на добавление нового элемента в очередь");
        myQueue.add(object);
        log.info("Добавление нового элемента выполнено успешно");
    }

    /**
     * Возвращает текущий элемент из очереди с последующим его удалением
     * @return текущий элемент из очереди
     */
    public T dequeue() {
        Logger log = Logger.getAnonymousLogger();
        log.info("Запрос на получение элемента очереди с последующим удалением");
        return myQueue.pollFirst();
    }

    /**
     * Возвращает текущий элемент коллекции
     * @return текущий элемент коллекции
     */
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
    private ArrayList<String> equalList;
    public double result;
    public String equete;

    Calc(String equals) {
        Logger logger = Logger.getAnonymousLogger();
        this.equete = equals;
        logger.info("Инициализировано выражение в классе Calc");
        this.equalList = new ArrayList<>(Arrays.stream(equals
                        .replaceAll("[*]", " * ")
                        .replaceAll("[/]", " / ")
                        .replaceAll("[-]", " - ")
                        .replaceAll("[+]", " + ")
                        .split(" "))
                        .toList());
    }

    /**
     * Удаляет текущий и предыдущий элемент
     * из коллекции после проведения математической операции
     * @param equalList объект <b>ArrayList</b>
     *                  из которого удаляются элементы
     * @param i индекс элемента, соответствующего
     *          символу математической операции
     */
    private void removeAfterSingleOperation(ArrayList<String> equalList, int i) {
        equalList.remove(i + 1);
        equalList.remove(i - 1);
    }

    /**
     * Выполняет все возможные математические операции
     * в строковом выражении, соответствующие заданному математическому символу,
     * оставляя в исходном выражении результаты
     * @param ch строковое представление математического символа
     */
    private void singleOperation(String ch) {
        int len = equalList.size();
        int i = 0;

        while (i < len & len != 1) {
            if (equalList.get(i).equals(ch) & ch.equals("/")) {
                equalList.set(i, Double.toString(Double.parseDouble(equalList.get(i - 1)) / Double.parseDouble(equalList.get(i + 1))));
                removeAfterSingleOperation(equalList, i);
                len -= 2;
                i--;
            } else if (equalList.get(i).equals(ch) & ch.equals("*")) {
                equalList.set(i, Double.toString(Double.parseDouble(equalList.get(i - 1)) * Double.parseDouble(equalList.get(i + 1))));
                removeAfterSingleOperation(equalList, i);
                len -= 2;
                i--;
            } else if (equalList.get(i).equals(ch) & ch.equals("-")) {
                equalList.set(i, Double.toString(Double.parseDouble(equalList.get(i - 1)) - Double.parseDouble(equalList.get(i + 1))));
                removeAfterSingleOperation(equalList, i);
                len -= 2;
                i--;
            } else if (equalList.get(i).equals(ch) & ch.equals("+")) {
                equalList.set(i, Double.toString(Double.parseDouble(equalList.get(i - 1)) + Double.parseDouble(equalList.get(i + 1))));
                removeAfterSingleOperation(equalList, i);
                len -= 2;
                i--;
            }

            i++;
        }
    }

    /**
     * Возвращает результат проведения математических операций строкового выражения
     * @return числовое значение строкового выражения
     */
    public double calculation() {
        Logger logger = Logger.getAnonymousLogger();
        logger.info("Получен запрос на получение результата выражения класса Calc");

        String[] operatorArray = {"/", "*", "-", "+"};

        for (String op : operatorArray) {
            singleOperation(op);
        }

        return result = Double.parseDouble(equalList.get(0));

    }
}

class PostfixNotationUtils {

    /**
     * Явлется ли символ <b>ch</b> оператором.
     * @param ch символ для проверки
     * @return <b>true</b> если символ является оператором, иначе <b>false</b>
     */
    private static boolean isOperator(char ch) {
        return (ch == '/' || ch == '*' || ch == '-' || ch == '+');
    }

    /**
     * Возвращает приоритет оператора.
     * @param ch символ оператора
     * @return приоритет оператора
     */
    private static int getOpPriority(char ch) {
        if      (ch == '+' || ch == '-') return 1;
        else if (ch == '*' || ch == '/') return 2;
        else                             return -1;
    }

    /**
     * Собирает последовательность символов, представляющих одно число, в одну строчку.
     * Учитывает, что число может состоять из цифр, десятичного разделителя и знаков ±, представляющих
     * унарный минус.
     *
     * @param ch первый символ числа
     * @param str вся строка, из которой будут забираться символы
     * @param index индекс символа <b>ch</b> в строке <b>str</b>
     * @return строка, представляющая число.
     */
    private static String gatherNumber(char ch, String str, int index) {
        StringBuilder sb = new StringBuilder();

        /*
         * Последовательно проверяем все символы и, до тех пор пока они относятся к нашему числу,
         * присоединяем их к строке.
         */
        while (Character.isDigit(ch) || ch == ',' || ch == '.' || ch == '±') {
            sb.append(ch);
            index++;
            if (index >= str.length()) break; //следим за выходом за границы строки
            ch = str.charAt(index);
        }

        return sb.toString();
    }

    /**
     *  Переводит строку <b>number</b> в значение типа double.
     *  Если в начале строки стоят символы унарного минуса ±, то учитываем
     *  знак числа, в соответсвие с количеством унарных минусов.
     * @param number строка с числом
     * @return число типа double.
     */
    private static double parseNumber(String number) {
        int sign = 1;

        char ch = number.charAt(0);

        while (ch == '±'){
            sign *= -1;
            number = number.substring(1);
            ch = number.charAt(0);
        }

        double d = Double.parseDouble(number);
        d *= sign;
        return d;
    }

    /**
     * Переводит строку в инфиксной нотации в постфиксную (обратную польскую) нотацию.
     * @param infixStr строка в инфиксной нотации
     * @return строка в постфиксной нотации, <b>null</b> в случае, если строка <b>infixStr</b> введена
     * некорректно.
     */
    public static String convertInfixToPostfix(String infixStr) {
        boolean mayUnary = true; //может ли следующий оператор быть унарным

        Stack<Character> stack = new Stack<>(); //стек операторов и символов

        StringBuilder psb = new StringBuilder(); //билдер выходной строки

        int len = infixStr.length(); //длинна строки

        try {

            for (int i = 0; i < len; i++) {
                char ch = infixStr.charAt(i);

                if (Character.isDigit(ch)) {

                    String number = gatherNumber(ch, infixStr, i);
                    i += number.length() - 1;
                    psb.append(number);
                    psb.append(' ');

                    mayUnary = false;

                } else if (ch == '(') {

                    stack.push(ch);
                    mayUnary = true;

                } else if (ch == ')') {

                    char temp = '\n';

                    /*
                     * пока верхним элементом не станет открывающаяся скобка,
                     * выталкиваем символы в строку
                     */
                    while ((temp = stack.pop()) != '(' ) {
                        psb.append(temp);
                        psb.append(' ');
                    }

                    mayUnary = false;

                } else if (isOperator(ch)) {

                    if (mayUnary && (ch == '+' || ch == '-')) {

                        if (ch == '-') {        //если унарный минус - заменяем его на ±
                            psb.append('±');
                        } else {                //если плюс, то просто опускаем символ
                            continue;
                        }

                    } else {
                        /*
                         * пока приоритет оператора меньше или равен приоритету оператора
                         * на верщине стека, выталкиваем символы из стека в строку
                         */
                        while (stack.size() > 0
                                && getOpPriority(ch) <= getOpPriority(stack.peek())) {
                            psb.append(stack.pop());
                            psb.append(' ');
                        }

                        stack.push(ch);
                    }

                    mayUnary = true;
                }
            }

            while (stack.size() > 0) {
                psb.append(stack.pop());
                psb.append(' ');
            }
            return psb.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Вычисляет значение выражения, записанного в постфиксной нотации.
     * @param postfixStr строка в постфиксной нотации
     * @return строка с результатом, <b>null</b> в случае, если строка <b>postfixStr</b> введена
     * некорректно.
     */
    public static String calculatePostfixExpression(String postfixStr) {

        Stack<Double> stack = new Stack<>(); //при вычислении используется стэк
        int len = postfixStr.length(); //длинна строки

        try {
            for (int i = 0; i < len; i++) {
                char ch = postfixStr.charAt(i);

                if (ch == ' ') {
                    /* do nothing */
                } else if (Character.isDigit(ch) || ch == '±') {

                    String number = gatherNumber(ch, postfixStr, i);
                    i += number.length() - 1;
                    double d = parseNumber(number);
                    stack.push(d);

                } else if (isOperator(ch)) {
                    /* выполняем действие в зависимости от оператора */

                    double b = stack.pop();
                    double a = stack.pop();

                    if(ch == '+') {
                        a = a + b;
                    } else if (ch == '-') {
                        a = a - b;
                    } else if (ch == '*') {
                        a = a * b;
                    } else if (ch == '/') {
                        if (b == 0) return null;  //ошибка деления на ноль
                        a = a / b;
                    }

                    stack.push(a);

                } else {
                    return null;
                }
            }

            double result = stack.pop();
            int intRes = (int) result;

            /* Определяем в каком формате выводить число: int или double */
            if (intRes == result) {
                return Integer.toString(intRes);
            } else {
                return Double.toString(result);
            }
        } catch (Exception e) {
            return null;
        }
    }

}