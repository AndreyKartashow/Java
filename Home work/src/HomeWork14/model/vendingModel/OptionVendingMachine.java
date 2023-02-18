package HomeWork14.model.vendingModel;

import HomeWork14.model.toyModel.OptionToy;
import HomeWork14.model.toyModel.Toy;

import java.util.ArrayList;

public class OptionVendingMachine implements IOptionVendingMachine{
    OptionToy optionToy = new OptionToy();

    @Override
    public String addToy(VendingMachine vendingMachine, Toy toy) {
                vendingMachine.listToy.add(toy);
        return "Игрушка " + optionToy.getToyInfo(toy) + " добавлена";
    }

    @Override
    public int returnToy(VendingMachine vendingMachine, int idToy) {
        for (Toy toy : vendingMachine.listToy) {
            if (optionToy.getId(toy) == idToy) {
                toy.setCountToy(optionToy.getCountToy(toy) - 1);
                return optionToy.getId(toy);
            }
        }
        return 0;
    }

    @Override
    public ArrayList<Toy> checkCountToy(VendingMachine vendingMachine) {
        int conditionCheck = 5;
        ArrayList<Toy> listPositionForUpdate = new ArrayList<>();
        for (Toy toy : vendingMachine.listToy) {
            if (optionToy.getCountToy(toy) <= conditionCheck) {
                listPositionForUpdate.add(toy);
            }
        }
        return listPositionForUpdate;
    }

    @Override
    public void updateCountToy(VendingMachine vendingMachine, Toy toy, int count) {
        toy.setCountToy(optionToy.getCountToy(toy) + count);
    }



}
