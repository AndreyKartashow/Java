package HomeWork7;

public interface VendingMachine {
    String getProduct(String nameDrink);

    String addProduct(Drink drink, int countPortions);

    void printAllProducts();
}
