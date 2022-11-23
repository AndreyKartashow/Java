package HomeWork7.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

public class VendingMachineHotDrink implements VendingMachine<Drink> {

    private Map<Drink, Integer> mapHotDrink;

    /**
     * По умолчанию в конструкторе инициализируется пустая карта товаров <b> Map "Drink, Integer" </b>
     */
    public VendingMachineHotDrink() {
        this.mapHotDrink = new LinkedHashMap<>();
    }

    /**
     * Конструктор принимает карту товаров и инициализирует ее в торговом автомате
     * @param mapHotDrink карта товаров <b>Map "Drink, Integer"</b>
     */
    public VendingMachineHotDrink(LinkedHashMap<Drink, Integer> mapHotDrink) {
        this.mapHotDrink = mapHotDrink;
    }

    /**
     * Метод возвращает карту автомата
     * @return Возвращает карту автомата с напитками
     */
    public Map<Drink, Integer> getMapHotDrink() {
        return mapHotDrink;
    }

    /**
     * Метод выдает пользователю напиток понаименованию.
     * Если количество равно 0, то пользователь получит предупреждение что напиток закончился.
     * Если такого напитка нет в автомате, то пользователь получит предупреждение что такого напитка нет
     * @param nameDrink наименование напитка, тип <b>Drink</b>
     * @return Возвращает оповещание о проведение операции выдачи товара
     */
    @Override
    public String getProduct(Drink nameDrink) {
        Logger log = Logger.getAnonymousLogger();
        for (Map.Entry<Drink, Integer> set : mapHotDrink.entrySet()){
            if (mapHotDrink.containsKey(nameDrink) & mapHotDrink.get(nameDrink) != 0){
                mapHotDrink.replace(nameDrink, mapHotDrink.get(nameDrink) - 1);
                log.info("Продукт " + nameDrink + " выдан, остаток: " + mapHotDrink.get(nameDrink));
                return "Выдан " + set.getKey();
            } else if (mapHotDrink.containsKey(nameDrink) & mapHotDrink.get(nameDrink) == 0) {
                log.info("Продукт " + nameDrink + " закончился");
                return "Такого продукта нет в наличии";
            }
        }
        return "Такого продукта нет";
    }

    /**
     * Метод позволяет загрузить автомат товарами.
     * Если такой товар уже есть, то его количество обновляется.
     * Если такого товара еще нет, то карта продукции будет обновлена.
     * @param drink екземпляр напитка, тип <b>Drink</b>
     * @param countPortions количество порций тип <b>int</b>
     * @return Возвращает строковое представление проведенной операции добавления товара
     */
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

    /**
     * Метод возвращает список всех товаров, загруженных в автомат и количество порций
     */
    @Override
    public void printAllProducts() {
        for (Map.Entry<Drink, Integer> set : mapHotDrink.entrySet()){
            System.out.println(set.getKey() + " - колличество " + set.getValue() + " порций");
        }
    }

}
