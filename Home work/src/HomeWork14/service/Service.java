package HomeWork14.service;

import HomeWork14.botService.Customer;
import HomeWork14.dataBase.DataBase;
import HomeWork14.model.toyModel.OptionToy;
import HomeWork14.model.toyModel.Toy;
import HomeWork14.model.vendingModel.OptionVendingMachine;
import HomeWork14.model.vendingModel.VendingMachine;

import java.sql.SQLException;
import java.util.ArrayList;


public class Service {
    // Инициализация DataBase
    DataBase dataBase = new DataBase();
    // Инициализация VendingMachine
    OptionVendingMachine optionVendingMachine = new OptionVendingMachine();
    OptionToy optionToy = new OptionToy();
    VendingMachine vendingMachine;
    long timeStartService = System.currentTimeMillis();



    // Заполнить БД данными, если они отсутствуют
    private void initContextDB() throws SQLException, ClassNotFoundException {
        dataBase.createTables();
        dataBase.insertCeedData();
    }
    // считать БД и заполнить структуру
    public String initDataForModelMachine() throws SQLException, ClassNotFoundException {
        initContextDB();
        vendingMachine = new VendingMachine(dataBase.getDataToy());
        return "Данные инициализированы";
    }

    // Продать игрушку
    private String seelToy(Customer customer, String nameToy) throws SQLException, ClassNotFoundException {
        for (Toy toy : vendingMachine.listToy) {
            if (optionToy.getNameToy(toy).equals(nameToy)) {
                int id = optionToy.getId(toy);
                optionVendingMachine.returnToy(vendingMachine, id);
                dataBase.sell(customer, id);
                return "Товар " + optionToy.getNameToy(toy) + " продан";
            }
        }
        return "Товар не найден";
    }

    // Пополнить ассортимент магазина
    private String updateCountToy() throws SQLException, ClassNotFoundException {
        ArrayList<Toy> listToyForUpdate = optionVendingMachine.checkCountToy(vendingMachine);
        if (! listToyForUpdate.isEmpty()) {
            int countAddition = 5;
            for (Toy toy : listToyForUpdate) {
                dataBase.addCountToy(optionToy.getId(toy), countAddition, optionToy.getCountToy(toy));
                optionVendingMachine.updateCountToy(vendingMachine, toy, countAddition);
            }
        }
        return "Все необходимые товары пополнены";
    }

    // Получить все транзакций после завершения работы
    private String getAllTransaction() throws SQLException, ClassNotFoundException {
        return dataBase.getAllTransaction();
    }


    // action - наименование товара или отказ от покупки и закрытие приложения
    public String startService(Customer customer, String action) throws SQLException, ClassNotFoundException {
        StringBuilder resultAction = new StringBuilder();
        long timeUpdate = 3000; // 3 секунды
        if (System.currentTimeMillis() >= timeStartService + timeUpdate) {
            resultAction.append(updateCountToy() + " \n");
            timeStartService = System.currentTimeMillis();
        }

        if (action.equals("отказ")) {
             resultAction.append(getAllTransaction());
        } else {
            resultAction.append(seelToy(customer, action) + " \n");
        }
        return resultAction.toString();
    }

    public ArrayList<String> getListName() {
        ArrayList<String> listName = new ArrayList<>();
        for (Toy toy : vendingMachine.listToy) {
            listName.add(optionToy.getNameToy(toy));
        }
        return listName;
    }

}
