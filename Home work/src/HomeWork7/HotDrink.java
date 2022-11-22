package HomeWork7;

public class HotDrink extends Drink {
    protected int temperature;

    public HotDrink(String name, double volume, int temperature) {
        this.name = name;
        this.volume = volume;
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
