package HomeWork7;

import java.util.HashMap;

import java.util.Map;
import java.util.logging.Logger;

public class VendingMachineHotDrink implements VendingMachine{
    private Map<Drink, Integer> mapHotDrink;

    public VendingMachineHotDrink() {
        this.mapHotDrink = new HashMap<>();
    }

    public VendingMachineHotDrink(HashMap<Drink, Integer> mapHotDrink) {
        this.mapHotDrink = mapHotDrink;
    }

    @Override
    public String getProduct(String nameDrink) {
        Logger log = Logger.getAnonymousLogger();
        for (Map.Entry<Drink, Integer> set : mapHotDrink.entrySet()){
            if (set.getKey().name.equals(nameDrink) & set.getValue() != 0){
                set.setValue(set.getValue() - 1);
                log.info("Продукт " + nameDrink + " выдан, остаток: " + set.getValue());
                return "Выдан " + set.getKey();
            } else if (set.getKey().name.equals(nameDrink) & set.getValue() == 0) {
                log.info("Продукт " + nameDrink + " закончился");
                return "Такого продукта нет в наличии";
            }
        }
        return "Такого продукта нет";
    }

    @Override
    public String addProduct(Drink drink, int countPortions) {
        if (mapHotDrink.containsKey(drink)){
            mapHotDrink.replace(drink, mapHotDrink.get(drink) + countPortions);
        } else {
            mapHotDrink.put(drink, countPortions);
        }
        Logger logger = Logger.getAnonymousLogger();
        logger.info("В автомат добавлен " + drink + " в колличестве " + countPortions);
        return drink.toString() + " количество: " + countPortions;
    }

    @Override
    public void printAllProducts() {
        for (Map.Entry<Drink, Integer> set : mapHotDrink.entrySet()){
            System.out.println(set.getKey() + " - колличество " + set.getValue() + " порций");
        }
    }


}
