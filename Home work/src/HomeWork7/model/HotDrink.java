package HomeWork7.model;


/**
 * Класс реализующий абстрактный класс <b>Drink</b> и представляет <b>Горячий напиток</b>
 * со своим полем <b>int temperature</b>
 */
public class HotDrink extends Drink {
    protected int temperature;

    /**
     * Конструктор принимает 3 параметра и характерезует объект <b>Горячий напиток</b>
     * @param name имя напитка, тип <b>String</b>
     * @param volume объем напитка, тип <b>double</b>
     * @param temperature температура напитка, тип <b>int</b>
     */
    public HotDrink(String name, double volume, int temperature) {
        super(name, volume);
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "HotDrink: " +
                "наименование = " + name + ", " +
                "объем = " + volume + "л, " +
                "температура = " + temperature + "С";
    }
}
