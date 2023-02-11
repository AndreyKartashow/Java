package HomeWork13.controller;

import java.util.logging.Logger;

public class Validator {
    Logger logger = Logger.getAnonymousLogger();

    public boolean isValidForm(String formText) {
        return isValidLength(formText) &&
                isValidName(formText) &&
                isValidDate(formText) &&
                isValidGender(formText) &&
                isValidNumber(formText);
    }

    private boolean isValidLength(String formText) {
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
            return false;
        }
        return true;
    }

    public boolean isValidName(String formText) {
        try {
            String[] data = formText.split(" ");

            for (int i = 0; i < 3; i++) {
                if (!data[i].matches("[А-Яа-я]+") ) {
                    System.out.println("ФИО содержит недопустимые символы");
                    throw new RuntimeException();
                }
            }

        } catch (RuntimeException e) {
            logger.info("Форма не корректна. Присутствуют недопустимые символы при вводе ФИО");
            return false;
        }
        return true;
    }

    private boolean isValidDate(String formText) {
        try {
            String[] data = formText.split(" ");

            if (!(data[3].matches("([0-9]{2})[-/.]([0-9]{2})[-/.]([0-9]{4})"))) {
                System.out.println("Дата рождения не соответствует формату дд.мм.гггг");
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            logger.info("Форма не корректна. Ошибка при вводе даты рождения");
            return false;
        }
        return true;
    }

    private boolean isValidGender(String formText) {
        try {
            String[] data = formText.split(" ");

            if (!(data[4].equals("f") | (data[4].equals("m")))) {
                System.out.println("Пол не соответствует символу f/m");
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            logger.info("Форма не корректна. Присутствуют недопустимые символы при вводе пола");
        }
        return true;
    }

    public boolean isValidNumber(String formText) {
        try {
            String[] data = formText.split(" ");
            for (char c : data[5].toCharArray())
            {
                if (!Character.isDigit(c)) {
                    System.out.println("Введенные данные должны состоять только из цифр");
                    throw new RuntimeException();
                }
            }

        } catch (RuntimeException e) {
            logger.info("Форма не корректна. Присутствуют недопустимые символы при вводе числового значения");
            return false;
        }
        return true;
    }
}


