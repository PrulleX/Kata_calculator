public class RomanNumbers {
    static String[] romanArr = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};                   // делаем такой большой массив для операций умножения

    public static boolean roman(String unit) {         //запускаем наш цикл по массиву для нахождения совпадения
        for (int i = 0; i < romanArr.length; i++) {
            if (unit.equals(romanArr[i])) {
                return true;
            }
        }
        return false;
    }
    public static int arabianСonversion(String roman) {      //данный метод проходится по массиву romanArr и ищет соответствие, если его нет,
        for (int i = 0; i < romanArr.length; i++) {      // то число арабское, либо был произведен неправильнный ввод
            if (roman.equals(romanArr[i])) {         // если находим соответсвие в массиве, то берем индекс этого числа
                return i;
            }
        }
        return -2;                                      // если число не найдено, то выводим -2, т.к. этого индекса нет в данном массиве
    }
    public static String romanСonversion(int arab) {        // данный метод создан для конвертации из int в рисмское число по индексу из массива
        return romanArr[arab];
    }
}
