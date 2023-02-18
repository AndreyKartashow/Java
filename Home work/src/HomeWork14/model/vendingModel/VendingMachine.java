package HomeWork14.model.vendingModel;

import HomeWork14.model.toyModel.Toy;
import java.util.ArrayList;
import java.util.Arrays;


public class VendingMachine extends AbstractVendingMachine{
    public VendingMachine(ArrayList<Toy> list) {
        this.listToy = new ArrayList<>(list);
    }
    // Этот класс реализует конструктор абстрактного класса и позволяет создать экземпляр торгового автомата
}
