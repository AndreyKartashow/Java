package HomeWork14.model.vendingModel;

import HomeWork14.model.toyModel.Toy;

import java.util.ArrayList;

public interface IOptionVendingMachine {
    String addToy(VendingMachine vendingMachine, Toy toy);
    int returnToy(VendingMachine vendingMachine, int iDToy);
    ArrayList<Toy> checkCountToy(VendingMachine vendingMachine);
    void updateCountToy(VendingMachine vendingMachine, Toy toy, int count);
}
