import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
    private String opetationSystem;
    private String processor;
    private String videoCard;

    public Notebook(String manufacturer, String model, String ram, String memoryHardDisk, String opetationSystem, String processor, String videoCard) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.ram = ram;
        this.memoryHardDisk = memoryHardDisk;
        this.opetationSystem = opetationSystem;
        this.processor = processor;
        this.videoCard = videoCard;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", RAM=" + ram +
                ", memoryHardDisk=" + memoryHardDisk +
                ", opetationSystem='" + opetationSystem + '\'' +
                ", processor='" + processor + '\'' +
                ", videoCard='" + videoCard + '\'' +
                '}';
    }
}

class NotebookCollection{
    Map<Notebook, String> mapNotebook;

    NotebookCollection(){
        mapNotebook = new HashMap<>();
    }

    protected void addNotebook(Notebook notebook, String count){
        mapNotebook.put(notebook, count);
    }

    protected void printMapNotebook(){
        Scanner scanner = new Scanner(System.in);

        for (Map.Entry<Notebook, String> set : mapNotebook.entrySet()){
            System.out.println(set.getKey() + " - В наличии: " + set.getValue());
        }

        System.out.println();
        System.out.println("Нажмите Enter для продолжения");
        scanner.nextLine();
    }

    protected Map<Notebook, String> findNotebook(){
        Scanner scanner = new Scanner(System.in);



        return mapNotebook;
    }
}

class Chop{
    protected static NotebookCollection initProducts(){
        NotebookCollection notebookMap = new NotebookCollection();

        Notebook notebook1 = new Notebook("ASUS", "A456-7", "32Гб", "1Тб", "Windows10", "Intel i5", "NVIDIA 1560");
        Notebook notebook2 = new Notebook("Lenovo", "975-4", "64Гб", "1Тб", "Windows7", "Intel i5", "NVIDIA 1560");
        Notebook notebook3 = new Notebook("Lenovo", "47-4527A", "32Гб", "1Тб", "Windows8", "Intel i5", "NVIDIA 1560");
        Notebook notebook4 = new Notebook("ASUS", "Super-756X", "32Гб", "1Тб", "Windows10", "Intel i5", "NVIDIA 1560");
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

class UserInterface{
    protected static void callUpUserInterface(){
        System.out.println();
        System.out.println("МЕНЮ");
        System.out.println("1 - посмотреть весь ассортимент");
        System.out.println("2 - найти товар");
        System.out.println("3 - выйти из приложения");
        System.out.println();
    }

    protected static String chooseAction(){
        Scanner scanner = new Scanner(System.in);
        String operation = "";
        while (! (operation.equals("1") | operation.equals("2") | operation.equals("3"))) {
            System.out.println("Введите цифру с соответствующей операцией и подтвердите действие");
            operation = scanner.next();
        }
        return operation;
    }

    //protected
}

class Controller{
    protected void runServer(){
        NotebookCollection notebookMap = Chop.initProducts();

        System.out.println();
        System.out.println("Добро пожаловать в маркетплейс");

        boolean flag = true;
        while (flag) {
            UserInterface.callUpUserInterface();
            String action = UserInterface.chooseAction();

            switch (action){
                case "1" -> notebookMap.printMapNotebook();
                case "2" -> notebookMap.findNotebook();
                case "3" -> flag = false;
            }
        }
    }
}