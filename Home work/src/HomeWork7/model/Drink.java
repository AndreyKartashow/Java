package HomeWork7.model;

/**
 * Абстрактный класс представляющий сущность напиток с полями
 * <b>String name</b> и <b>double volume</b>
 */
public abstract class Drink {
    protected String name;
    protected double volume;

    public Drink(String name, double volume) {
        this.name = name;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }
}
