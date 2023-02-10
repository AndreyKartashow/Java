package HomeWork13.controller;

import java.util.logging.Logger;

public class Validator {
    Logger logger = Logger.getAnonymousLogger();

    public boolean isValidLength(String formText) {
        try {
            if (formText.split(" ").length > 6) {
                System.out.println("Вы ввели лишние данный");
                throw new RuntimeException();
            } else if (formText.split(" ").length < 6) {
                System.out.println("Вы ввели не все данные");
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            logger.info("Форма не корректна. Количество элементов в отправленной форме не соответствует стандарту");
        }
        return true;
    }

    public boolean isValidName(String formText) {
        try {
            String[] data = formText.split(" ");

            if (!(data[0].matches("[А-Яа-я]+") & data[1].matches("[А-Яа-я]+") & data[2].matches("[А-Яа-я]+"))) {
                System.out.println("ФИО содержит недопустимые символы");
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            logger.info("Форма не корректна. Присутствуют недопустимые символы при вводе ФИО");
        }
        return true;
    }

    public boolean isValidDate(String formText) {
        try {
            String[] data = formText.split(" ");

            if (!(data[3].matches("([0-9]{2})[-/.]([0-9]{2})[-/.]([0-9]{4})"))) {
                System.out.println("Дата рождения не соответствует формату дд.мм.гггг");
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            logger.info("Форма не корректна. Ошибка при вводе даты рождения");
        }
        return true;
    }

    public boolean isValidGender(String formText) {
        try {
            String[] data = formText.split(" ");

            if (!data[4].equals("f") | !(data[4].equals("m"))) {
                System.out.println("Пол не соответствует символу f/m");
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            logger.info("Форма не корректна. Присутствуют недопустимые символы при вводе пола");
        }
        return true;
    }

    public boolean isValidPhone(String formText) {
        try {
            String[] data = formText.split(" ");

            if (!data[5].matches("[0-9]")) {
                System.out.println("Номер телефона содержит недопустимые символы");
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            logger.info("Форма не корректна. Присутствуют недопустимые символы при вводе номера телефона");
        }
        return true;
    }
}
