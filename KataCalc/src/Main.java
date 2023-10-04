import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математическую операцию");
        String operation = scanner.nextLine();
        operation = operation.replace(" ", "");             //убираем пробелы для корректной работы программы
        System.out.println("Ответ: " + calc(operation));                                 //вывод математической операции
    }
    public static String calc(String input) throws Exception {
        int a;
        int b;
        String action;
        String result;
        boolean romanValue;
        String[] numbers = input.split("[*/+\\-]");      //тут проверяем количество операндов
        action = findAction(input);                            // перемещаемся в метод findAction и находим введенное пользователем действие
        if (action == null) throw new Exception("//т.к. строка не является математической операцией");         // если action != null, то идем дальше
        if (numbers.length != 2) throw new Exception("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор");
        if (RomanNumbers.roman(numbers[0]) && RomanNumbers.roman(numbers[1])) {                    // тут проверяем систему счисления введенных операндов

            a = RomanNumbers.arabianСonversion(numbers[0]);                                        //конвертируем числа в арабскую систему счисления
            b = RomanNumbers.arabianСonversion(numbers[1]);
            romanValue = true;
        }
        else if (!RomanNumbers.roman(numbers[0]) && !RomanNumbers.roman(numbers[1])) {       // если первое число НЕ римское и второе тоже НЕ римское, то введенные числа арабские
            a = Integer.parseInt(numbers[0]);                                                // конвертируем строку в int
            b = Integer.parseInt(numbers[1]);
            romanValue = false;
        }

        else {                            //если числа из разных систем счисления, то ...
            throw new Exception("//т.к. используются одновременно разные системы счисления");
        }
        if (a > 11 && b > 11) {                               // ограничение вводимых чисел по модулю
            throw new Exception("Вводимые числа должны быть от 1 по 10");
        }
        int arabe = calculation(a, b, action);                                              // с помощью метода calculation выполняем заданное пользователем действие
        if (romanValue) {

            if (arabe <= 0) {                                                               // если ответ равняется 0 или отриц. значению, то выбрасываем исключение
                throw new Exception("//т.к. в римской системе нет отрицательных чисел");
            }
            result = RomanNumbers.romanСonversion(arabe);                                   // с помощью массива romanArr конвертируем результат действия из int в римское по индексу в массиве
        } else {
            result = String.valueOf(arabe);                                                 //Конвертируем арабское число в тип String
        }

        return result;                                                           // возвращаем результат операции из метода
    }

    public static String findAction(String operation) {                          //ищем введенное пользователем действие
        if (operation.contains("*")) return "*";
        else if (operation.contains("/")) return "/";
        else if (operation.contains("+")) return "+";
        else if (operation.contains("-")) return "-";
        else return null;                                                        //если из перечня действия мы не нашли подходящее, возвращаем null в строку 20
    }
    static int calculation(int a, int b, String various) {                       // приходим сюда, находим введенное пользователем действие и по нему вычисляем
        return switch (various) {
            case "*" -> a * b;
            case "/" -> a / b;
            case "+" -> a + b;
            case "-" -> a - b;
            default -> a;
        };
    }
}