package HomeWork8.controller.repositories;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static void writ(String nameFile, String text, boolean append) {
        try (FileWriter writer = new FileWriter(nameFile, append)) {
            writer.write(text);
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static List<String> read(String nameFile) {
        List<String> listData = new ArrayList<>();

        try (FileReader fr = new FileReader(nameFile); BufferedReader reader = new BufferedReader(fr)) {
            String line = reader.readLine();
            while (line != null) {
                listData.add((line));
                line = reader.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return listData;
    }
}
