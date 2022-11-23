package HomeWork7.model;

/**
 * Обобщеный интерфейс представляет абстракцию торгового автомата, в который можно загрузить товыры с определенным количеством,
 * который может выдавать товары по наименованию, а так же предоставить полный ассортимент товаров, находящихся в
 * этом автомате.
 */
public interface VendingMachine<T> {

    String getProduct(T product);

    String addProduct (T product, int countPortions);

    void printAllProducts();
}
