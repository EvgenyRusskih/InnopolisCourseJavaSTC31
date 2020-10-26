package part01.lesson03.task01.mathbox.utils;

import java.util.Random;

/**
 * @author RusskihEvgeny
 * Генератор массива значений с типом Number
 * Элементы в массиве могут повторятся
 */

public class GeneratorNumbers {

    /**
     * Максимальное значение генерируемых чисел в массие.
     * То есть: задаем диапазон чисел в массиве 0-MAXNUM
     */
    final int MAXNUMS = 20;

    /**
     * @param count на вход передаем размер генерируемого массива
     * @return Возвращаем сгенерированный массив типа Number.
     */
    public Number[] generateNumbers(int count) {
        Number[] numbers = new Number[count];
        //Генерируем числа в диапазоне от 0-MAXNUM
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            numbers[i] = random.nextInt(MAXNUMS);
        }
        return numbers;
    }

}