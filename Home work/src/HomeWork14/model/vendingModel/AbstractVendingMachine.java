package HomeWork14.model.vendingModel;

import HomeWork14.model.toyModel.Toy;

import java.util.ArrayList;

public class AbstractVendingMachine {
    public ArrayList<Toy> listToy;

    AbstractVendingMachine() {
        this.listToy = new ArrayList<>();
    }
}
