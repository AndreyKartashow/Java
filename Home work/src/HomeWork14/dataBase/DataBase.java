package HomeWork14.dataBase;

import HomeWork14.botService.Customer;
import HomeWork14.model.toyModel.Toy;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class DataBase {
    public static String url = "jdbc:mysql://localhost:3306/mysql";
    public static String username = "root";
    public static String password = "1111";
    public static Connection connection;
    public static Statement statement;

    // Подключение к базе данных
    static {
        try {
            connection = DriverManager.getConnection(url, username, password);
        }
        catch(SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    // Запрос на создание БД, если ее нет и ее подключение
    private void createDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("CREATE DATABASE IF NOT EXISTS ToyStory;");
    }
    private void useDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("USE ToyStory;");
    }

    // Запросы на создание таблиц, если их нет
    private void initTableToy() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS toy (" +
                "id_toy INT PRIMARY KEY AUTO_INCREMENT," +
                "name_toy VARCHAR(45) NOT NULL," +
                "description_toy TEXT NOT NULL," +
                "price_toy DOUBLE NOT NULL);");
    }
    private void initTableStorehouse() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS storehouse (" +
                "id_position INT PRIMARY KEY AUTO_INCREMENT," +
                "id_toy INT NOT NULL, FOREIGN KEY (id_toy) REFERENCES toy (id_toy)," +
                "count_toy INT NOT NULL);");
    }
    private void initTableCustomer() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS customer (" +
                "id_customer INT PRIMARY KEY AUTO_INCREMENT," +
                "m_name_customer VARCHAR(45) NOT NULL," +
                "f_name_customer VARCHAR(45) NOT NULL," +
                "l_name_customer VARCHAR(45) NOT NULL);");
    }
    private void initTableTransaction() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS transaction (" +
                "id_transaction INT PRIMARY KEY AUTO_INCREMENT," +
                "data_transaction DATETIME NOT NULL," +
                "id_customer INT NOT NULL, FOREIGN KEY (id_customer) REFERENCES customer (id_customer)," +
                "id_toy INT NOT NULL, FOREIGN KEY (id_toy) REFERENCES toy (id_toy));");
    }

    // Создание всех таблиц
    public void createTables() throws ClassNotFoundException, SQLException{
        createDB();
        useDB();
        initTableToy();
        initTableStorehouse();
        initTableCustomer();
        initTableTransaction();
    }

    // Запрос на заполнение сущности toy, если в ней нет данных
    private void CeedDataToy() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM toy");


        if (!resultSet.next()) {
            statement.executeUpdate("INSERT INTO toy (name_toy, description_toy, price_toy) VALUES " +
                    "('Тироназавр Рекс', 'Зеленый плюшевый динозавр, наполнитель пух', 2.30)," +
                    "('Медвежонок Барни', 'Плюшевый медведь, наполнитель пух', 3.45)," +
                    "('Черная Мамба', 'Черная плюшевая змея, наполнитель нейлон', 5.75)," +
                    "('Лайка', 'Плюшевая белая собака Лайка, наполнитель пух', 4.90)," +
                    "('Сердце', 'Красное плюшевое сердце на день влюбленных, наполнитель нейлон', 3.80)," +
                    "('Купидон', 'Плюшевая игрушка Купидон на день влюбленных, наполнитель пух', 2.30);");
        }
    }
    // Запрос на заполнение сущности toy, если в ней нет данных
    private void CeedDataStorehouse() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM storehouse");
        if (!resultSet.next()) {
            statement.executeUpdate("INSERT INTO storehouse (id_toy, count_toy) VALUES " +
                    "(1, 10)," +
                    "(2, 10)," +
                    "(3, 10)," +
                    "(4, 10)," +
                    "(5, 10)," +
                    "(6, 10);");
        }
    }

    // Запрос на заполнение всех сущностей тестовыми данными
    public void insertCeedData() throws ClassNotFoundException, SQLException{
        CeedDataToy();
        CeedDataStorehouse();
    }

    // Запрос на получение данных для создания моделей
    public ArrayList<Toy> getDataToy() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ResultSet resultSet = statement.executeQuery("SELECT toy.id_toy, name_toy, description_toy, price_toy, count_toy " +
                "FROM toy INNER JOIN storehouse ON toy.id_toy = storehouse.id_toy;");
        ArrayList<Toy> listToy = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name_toy = resultSet.getString(2);
            String description_toy = resultSet.getString(3);
            Double price_toy = resultSet.getDouble(4);
            int count_toy = resultSet.getInt(5);
            Toy toy = new Toy(id, name_toy, description_toy, price_toy, count_toy);
            listToy.add(toy);
        }
        return listToy;
    }

    // Запрос на внесение покупателя в базу данных (добавить если его нет)
    private void addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM customer " +
                "WHERE m_name_customer = " + "'" + customer.getMname() + "' AND " +
                        "f_name_customer = " + "'" + customer.getFname() + "' AND " +
                        "l_name_customer = " + "'" + customer.getLname() + "';");
        if (!resultSet.next()) {
            statement.executeUpdate("INSERT INTO customer (m_name_customer, f_name_customer, l_name_customer) VALUES " +
                    "(\"" + customer.getMname() + "\", \"" + customer.getFname() + "\", \"" + customer.getLname() +"\");");
        }
    }
    // Запрос на изменение количества товара (уменьшение)
    private void reduceCountToy(int iDToy) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        ResultSet resultSet = statement.executeQuery("SELECT count_toy " +
                "FROM storehouse WHERE id_toy = " + iDToy +";");

        int countForReplace = 0;
        if (resultSet.next()) {
            countForReplace = resultSet.getInt(1) - 1;
        }

        statement.executeUpdate("UPDATE storehouse SET count_toy = " + countForReplace + " WHERE id_toy = " + iDToy + ";");
    }
    // Запрос на создание транзакции
    private void createTransaction(Customer customer, int idToy) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ResultSet resultSet = statement.executeQuery("SELECT id_customer FROM customer " +
                "WHERE m_name_customer = " + "'" + customer.getMname() + "' AND " +
                "f_name_customer = " + "'" + customer.getFname() + "' AND " +
                "l_name_customer = " + "'" + customer.getLname() + "';");

        int idCustomer = 0;
        if (resultSet.next()) {
            idCustomer = resultSet.getInt(1);
        }

        if (!resultSet.next()) {
            statement.executeUpdate("INSERT INTO transaction (data_transaction, id_customer, id_toy) VALUES " +
                    "('" + LocalDateTime.now() + "', " + idCustomer + ", " + idToy +");");
        }
    }

    // Запрос на продажу товара
    public void sell(Customer customer, int iDToy) throws SQLException, ClassNotFoundException {
        addCustomer(customer);
        reduceCountToy(iDToy);
        createTransaction(customer, iDToy);
    }


    // Запрос на изменение количества товара (увеличение)
    public void addCountToy(Integer iDToy, int addCount, int currentCount) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        // currentCount возвращается из структуры сервиса
        String countForUpdate = String.valueOf((currentCount + addCount));
            statement.executeUpdate("UPDATE storehouse SET count_toy = " + countForUpdate + " WHERE id_toy = " + iDToy.toString() + ";");
    }


    // Запрос на получение всех транзакций
    public String getAllTransaction() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        StringBuilder allTransaction = new StringBuilder();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM transaction;");

        while (resultSet.next()) {
            allTransaction.append( resultSet.getTimestamp(2) +
                    ", клиент id - " + resultSet.getInt(3) +
                    ", товар id - " + resultSet.getInt(3) + "\n" );
        }
        return allTransaction.toString();
    }
}
