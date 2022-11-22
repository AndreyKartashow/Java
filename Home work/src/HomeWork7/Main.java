package HomeWork7;

public class Main {
    public static void main(String[] args) {
        HotDrink tea1 = new HotDrink("чай черный", 0.25, 75);
        HotDrink tea2 = new HotDrink("чай зеленый", 0.25, 75);
        HotDrink tea3 = new HotDrink("чай красный", 0.25, 75);

        VendingMachineHotDrink machine = new VendingMachineHotDrink();
        machine.addProduct(tea1, 5);
        machine.addProduct(tea2, 5);
        machine.addProduct(tea3, 5);
        machine.printAllProducts();
        System.out.println();

        machine.getProduct("чай зеленый");
        machine.printAllProducts();
        System.out.println();

        machine.addProduct(tea2, 1);
        machine.printAllProducts();
        System.out.println();

        System.out.println(machine.getProduct("чай зеленый"));
        System.out.println(machine.getProduct("чай зеленый"));
        System.out.println(machine.getProduct("чай зеленый"));
        System.out.println(machine.getProduct("чай зеленый"));
        System.out.println(machine.getProduct("чай зеленый"));

        System.out.println();
        machine.printAllProducts();
        System.out.println();

        System.out.println(machine.getProduct("чай зеленый"));
        machine.printAllProducts();


    }
}
