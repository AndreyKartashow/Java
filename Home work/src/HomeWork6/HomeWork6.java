package HomeWork6;

import java.util.*;

public class HomeWork6 {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.runServer();
    }
}

class Notebook {
    private String manufacturer;
    private String model;
    private String ram;
    private String memoryHardDisk;
    private String operationSystem;
    private String processor;
    private String videoCard;

    public Notebook(String manufacturer, String model, String ram, String memoryHardDisk, String operationSystem, String processor, String videoCard) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.ram = ram;
        this.memoryHardDisk = memoryHardDisk;
        this.operationSystem = operationSystem;
        this.processor = processor;
        this.videoCard = videoCard;
    }

    @Override
    public String toString() {
        return "HomeWork6.Notebook{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", RAM=" + ram +
                ", memoryHardDisk=" + memoryHardDisk +
                ", opetationSystem='" + operationSystem + '\'' +
                ", processor='" + processor + '\'' +
                ", videoCard='" + videoCard + '\'' +
                '}';
    }
}

class NotebookCollection {
    Map<Notebook, String> mapNotebook;

    NotebookCollection() {
        mapNotebook = new HashMap<>();
    }

    protected void addNotebook(Notebook notebook, String count) {
        mapNotebook.put(notebook, count);
    }

    protected void printMapNotebook() {
        Scanner scanner = new Scanner(System.in);

        for (Map.Entry<Notebook, String> set : mapNotebook.entrySet()) {
            System.out.println(set.getKey() + " - В наличии: " + set.getValue());
        }

        System.out.println();
        System.out.println("Нажмите Enter для продолжения");
        scanner.nextLine();
    }

    protected void findNotebook(List<String> parametersSearch) {
        Map<Notebook, String> treeMapNotebook = new LinkedHashMap<>();
        int maxCountParameters = parametersSearch.size();

        while (maxCountParameters > 0) {
            for (Map.Entry<Notebook, String> set : mapNotebook.entrySet()) {
                int currentCountParameters = 0;
                for (String parameter : parametersSearch) {
                    if (set.getKey().toString().contains(parameter)) {
                        currentCountParameters++;
                        if (currentCountParameters == maxCountParameters) {
                            treeMapNotebook.put(set.getKey(), set.getValue());
                        }
                    }
                }
            }
            maxCountParameters--;
        }

        for (Map.Entry<Notebook, String> set : treeMapNotebook.entrySet()) {
            System.out.println(set.getKey() + " - В наличии: " + set.getValue());
        }

    }
}

class Chop {
    protected static NotebookCollection initProducts() {
        NotebookCollection notebookMap = new NotebookCollection();

        Notebook notebook1 = new Notebook("ASUS", "A456-7", "32Гб", "1Тб", "Windows8", "Intel i5", "NVIDIA 1560");
        Notebook notebook2 = new Notebook("Lenovo", "975-4", "64Гб", "1Тб", "Windows7", "Intel i5", "NVIDIA 1560");
        Notebook notebook3 = new Notebook("Lenovo", "47-4527A", "32Гб", "1Тб", "Windows8", "Intel i5", "NVIDIA 1560");
        Notebook notebook4 = new Notebook("ASUS", "Super-756X", "64Гб", "1Тб", "Windows10", "Intel i5", "NVIDIA 1560");
        Notebook notebook5 = new Notebook("Lenovo", "FGN54-561", "32Гб", "1Тб", "Windows8", "Intel i5", "NVIDIA 1560");
        Notebook notebook6 = new Notebook("ASUS", "6452-Atlanta x7", "32Гб", "1Тб", "Windows10", "Intel i5", "NVIDIA 1560");

        notebookMap.addNotebook(notebook1, "10");
        notebookMap.addNotebook(notebook2, "5");
        notebookMap.addNotebook(notebook3, "2");
        notebookMap.addNotebook(notebook4, "12");
        notebookMap.addNotebook(notebook5, "7");
        notebookMap.addNotebook(notebook6, "9");

        return notebookMap;
    }
}

class UserInterface {
    protected static void callUpUserInterface() {
        System.out.println();
        System.out.println("МЕНЮ");
        System.out.println("1 - посмотреть весь ассортимент");
        System.out.println("2 - найти товар");
        System.out.println("3 - выйти из приложения");
        System.out.println();
    }

    protected static String chooseAction() {
        Scanner scanner = new Scanner(System.in);
        String operation = "";
        while (!(operation.equals("1") | operation.equals("2") | operation.equals("3"))) {
            System.out.println("Введите цифру с соответствующей операцией и подтвердите действие");
            operation = scanner.next();
        }
        return operation;
    }

    protected static List<String> searchProducts() {
        Scanner scanr = new Scanner(System.in);
        System.out.println("Введите через пробел необходимые характеристики");

        String[] paramArray = scanr.nextLine().split(" ");
        return Arrays.asList(paramArray);
    }
}

class Controller {
    protected void runServer() {
        NotebookCollection notebookMap = Chop.initProducts();

        System.out.println();
        System.out.println("Добро пожаловать в маркетплейс");

        boolean flag = true;
        while (flag) {
            UserInterface.callUpUserInterface();
            String action = UserInterface.chooseAction();


            switch (action) {
                case "1" :
                    notebookMap.printMapNotebook();
                    break;
                case "2" :
                    List<String> listParameters = UserInterface.searchProducts();
                    notebookMap.findNotebook(listParameters);
                    break;
                case "3" :
                    flag = false;
                    break;
            }
        }
    }
}