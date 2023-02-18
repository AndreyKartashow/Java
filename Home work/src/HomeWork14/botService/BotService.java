package HomeWork14.botService;


import HomeWork14.controller.Controller;
import HomeWork14.vue.Output;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BotService {
    long timeStart = System.currentTimeMillis();
    Controller controller = new Controller();
    Output output = new Output();
    Random random = new Random();
    List<String> listMname = Arrays.asList("Иванов", "Петров", "Сидоров", "Козлов", "Соколов", "Дроздов", "Раскольников", "Соловьев", "Москвин", "Гнездов", "Лермонтов", "Толстов");
    List<String> listFname = Arrays.asList("Петр", "Семен", "Игнат", "Игорь", "Андрей", "Валерий", "Александр", "Роман", "Олег", "Павел", "Дмитрий", "Сергей");
    List<String> listLname = Arrays.asList("Иванович", "Александрович", "Петрович", "Романович", "Игоревич", "Олегович", "Дмитриевич", "Сергеевич", "Андреевич", "Игнатович", "Семенович", "Павлович");

    private Customer createBot() {
        String midlName = listMname.get(random.nextInt(listMname.size()));
        String firstName = listFname.get(random.nextInt(listFname.size()));
        String lastName = listLname.get(random.nextInt(listLname.size()));
        return new Customer(midlName, firstName, lastName);
    }

    private String getNameToy() {
        return controller.getPrice().get(random.nextInt(controller.getPrice().size()));
    }


    public void start() {
        controller.connectedStory();
        long currentTime;
        int countIteration = 0;
        int limitIteration = 5;
        long timeUpdate = 3000; // 3 секунды
        boolean flag = true;

        while (flag) {
            currentTime = System.currentTimeMillis();

            if (currentTime > timeStart + timeUpdate) {
                Customer bot = createBot();
                String action = getNameToy();
                output.printAction(action);
                output.printResult(controller.eventHeandler(bot, action));
                timeStart = System.currentTimeMillis();
                countIteration++;
            }
            if (countIteration >= limitIteration) {
                Customer bot = createBot();
                String action = "отказ";
                output.printAction(action);
                output.printResult(controller.eventHeandler(bot, action));
                flag = false;
            }

        }
    }

}
