import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class HomeWork5 {
    public static boolean isIsomorfStr(String first, String second) {
        Map<Character, Character> stringMap = new HashMap<>();
        char[] firstChars = first.toCharArray();
        char[] secondChars = second.toCharArray();
        if (firstChars.length != secondChars.length) {
            return false;
        }
        for (int i = 0; i < first.length(); i++) {
            if (!stringMap.containsKey(firstChars[i])) {
                if (stringMap.values().contains(secondChars[i])) {
                    return false;
                }
                stringMap.put(firstChars[i], secondChars[i]);
            } else if (!(stringMap.get(firstChars[i]) == secondChars[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        logger.info(String.valueOf(isIsomorfStr("aia", "poor")));
    }

    public static Integer romanToInteger(String roman) {
        Map<Character, Integer> dict = new HashMap<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
        char[] romanNumber = roman.toCharArray();
        int number = 0;
        for (int i = 0; i < romanNumber.length - 1; i++) {
            if (dict.get(romanNumber[i]) >= dict.get(romanNumber[i + 1])) {
                number += dict.get(romanNumber[i]);
            } else {
                number -= dict.get(romanNumber[i]);
            }
        }
        number += dict.get(romanNumber[romanNumber.length - 1]);
        return number;
    }

    public static String integertoRoman(int arabic) {
        Map<Integer,String> dict = new HashMap<>();
        dict.put( 1000, "M");
        dict.put( 500, "D");
        dict.put( 100, "C");
        dict.put( 50, "L");
        dict.put(10, "X");
        dict.put( 5,"V");
        dict.put(1, "I");
        dict.put( 900, "CM");
        dict.put( 400, "CD");
        dict.put(90, "XC");
        dict.put( 40,"XL");
        dict.put( 9,"IX");
        dict.put( 4,"IV");
        //LXXXXVIIII -> XC IX
        // 999 IM -> CMXCIX
        StringBuilder romanNumber = new StringBuilder();
        while (arabic > 0) {
            while (arabic / 1000 >= 1) {
                romanNumber.append(dict.get(1000));
                arabic -= 1000;
            }
            while (arabic / 100 >= 1) {
                if (dict.containsKey(arabic - arabic % 100)) {
                    romanNumber.append(dict.get(arabic - arabic % 100));
                    arabic = arabic % 100;
                }
                if (arabic >= 500) {
                    romanNumber.append(dict.get(500));
                    arabic = arabic - 500;
                }
                else {
                    if (arabic >= 100){
                        romanNumber.append(dict.get(100));
                        arabic -=100;
                    }
                }
            }
            while (arabic / 10 >= 1) {
                if (dict.containsKey(arabic - arabic % 10)) {
                    romanNumber.append(dict.get(arabic - arabic % 10));
                    arabic = arabic % 10;
                }
                if (arabic >= 50) {
                    romanNumber.append(dict.get(50));
                    arabic -=50;
                }
                else {
                    if (arabic >= 10){
                        romanNumber.append(dict.get(10));
                        arabic -=10;
                    }
                }
            }
            while (arabic > 0) {
                if (dict.containsKey(arabic)) {
                    romanNumber.append(dict.get(arabic));
                    arabic = 0;
                }
                if (arabic >= 5) {
                    romanNumber.append(dict.get(5));
                    arabic -=5;
                }
                else {
                    if (arabic >= 1){
                        romanNumber.append(dict.get(1));
                        arabic -=1;
                    }
                }
            }
        }
        return romanNumber.toString();
    }

}
