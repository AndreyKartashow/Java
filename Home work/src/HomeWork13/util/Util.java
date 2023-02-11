package HomeWork13.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Util {
    static Logger logger = Logger.getAnonymousLogger();
    static String path = "Home work\\src\\HomeWork13\\data\\";

    public static void Write(String nameFile, String text) {
        boolean append = false;

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.getName().equals(nameFile)) {
                    append = true;
                    break;
                }
            }
        }

        try (FileWriter writer = new FileWriter(path + nameFile, append)) {
            writer.write(text);
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            logger.info(ex.getMessage());
        }
    }

    public static List<String> Read() {
        List<String> listData = new ArrayList<>();

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (!file.getName().equals("ID")) {
                    try (FileReader fr = new FileReader(path + file.getName()); BufferedReader reader = new BufferedReader(fr)) {
                        String line = reader.readLine();
                        while (line != null) {
                            listData.add((line));
                            line = reader.readLine();
                        }
                    } catch (IOException ex) {
                        logger.info(ex.getMessage());
                    }
                }
            }
        }

        return listData;
    }

    public static void WriteID(int id) {
        try (FileWriter writer = new FileWriter(path + "ID", false)) {
            writer.write(((Integer) id).toString());
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            logger.info(ex.getMessage());
        }

    }

    public static boolean isFileIdExist(String name) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int ReadID() {
        try (FileReader fr = new FileReader(path + "ID"); BufferedReader reader = new BufferedReader(fr)) {
            System.out.println("мы в потоке");
            String str = reader.readLine();
            System.out.println(str);
            return Integer.parseInt(str);
        } catch (IOException ex) {
            logger.info(ex.getMessage());
        }
        return 0;
    }

}
