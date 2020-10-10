package part01.lesson02.task01.helloworldexception;

import java.util.Random;

/**
 * program HelloWorldException generate example
 *
 * @author RusskihEvgeny
 * <p>
 * ДЗ_2
 * Задание 1. Написать программу ”Hello, World!”.
 * В ходе выполнения программы она должна выбросить исключение и завершиться с ошибкой.
 * <p>
 * Смоделировав ошибку «NullPointerException»
 * Смоделировав ошибку «ArrayIndexOutOfBoundsException»
 * Вызвав свой вариант ошибки через оператор throw
 */

public class MainClass {

    /**
     * @throws MyException
     * @throws NullPointerException
     * @throws ArrayIndexOutOfBoundsException Метод генерирует случайным образом три числа.
     *                                        В зависимости от сгенерированного числа (0,1,2) - получаем тот или иной exception.
     *                                        0 -NullPointerException
     *                                        1- ArrayIndexOutOfBoundsException
     *                                        2 -MyException
     */

    public static void main(String[] args) throws MyException, NullPointerException, ArrayIndexOutOfBoundsException {
        NullPointerExceptionExample nullpointer_exception = new NullPointerExceptionExample();
        ArrayIndexOutOfBoundsExceptionExample arrayindexofbound_exception = new ArrayIndexOutOfBoundsExceptionExample();
        MyExceptionExample myexception = new MyExceptionExample();
        Random random = new Random();
        int k = random.nextInt(3);
        switch (k) {
            case 0:
                nullpointer_exception.getNullPointerException();
                break;
            case 1:
                arrayindexofbound_exception.getArrayIndexOutOfBoundsException();
                break;
            case 2:
                myexception.getMyException();
                break;
        }
        System.out.println("Hello World ");
    }
}

