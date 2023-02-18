package HomeWork14.vue;

public class Output {

    public void printAction(String act) {
        if (act.equals("отказ")) {
            System.out.println("Бот решил закончить выполнение программы");
        } else {
            System.out.println("Бот захотел купить товар");
        }
    }

    public void printResult(String result) {
        System.out.println(result);
    }
}
