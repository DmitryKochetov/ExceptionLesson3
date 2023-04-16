// 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, 
// ри подаче массива другого размера необходимо бросить исключение MyArraySizeException.
// 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. 
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), 
// должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
// 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и 
// MyArrayDataException и вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).
package DZ3;

import javax.swing.text.TableView.TableRow;

public class task1 {
    public static void main(String[] args) {
        String[][] arrayForCheck = {
                { "1", "1", "2", "4" },
                { "2", "4", "2", "4" },
                { "4", "2", "2", "4" },
                { "1", "1", "2", "4" },
        };
        try {
            System.out.println("Сумма элементов массива: " + sumArray(arrayForCheck));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int sumArray(String[][] array) throws MyArrayDataException, MyArraySizeException {
        if (array.length != 4) {
            throw new MyArraySizeException("Массив имеет размер не 4х4");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Массив имеет размер не 4х4");
            }
        }
        int sum = 0;
        int val = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    val = Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В ряду " + i + ", столбец " + j + " лежит не число");
                }
                sum += val;
            }
        }
        return sum;

    }

}

class MyArraySizeException extends RuntimeException {

    public MyArraySizeException(String message) {
        super(message);
    }

}

class MyArrayDataException extends NumberFormatException {

    public MyArrayDataException(String message) {
        super(message);
    }

}
