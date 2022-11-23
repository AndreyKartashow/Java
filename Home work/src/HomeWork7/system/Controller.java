package HomeWork7.system;

import HomeWork7.model.VendingMachineHotDrink;

/**
 * Класс реализует автомат с горячими напитками и пользовательский интерфейс
 */
public class Controller {
    public void programRun() {
        VendingMachineHotDrink machine = ProductOunerTerminal.runVendingMachine();
        UsersTerminal.runUserServer(machine);
    }


}
