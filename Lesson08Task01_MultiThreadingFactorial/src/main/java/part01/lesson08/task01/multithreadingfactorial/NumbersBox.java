package part01.lesson08.task01.multithreadingfactorial;

import java.util.Random;

/**
 * Класс для получения и хранения массива сгенерированных случайных целых чисел.
 */
public class NumbersBox {
    /**
     * Массив сгенерированных чисел и его размер.
     * Максимальное генерируемое число для массива (0-maxnum)
     */
    private final int sizeArray = 100;
    private final int maxnum = 1000;
    private final int[] arrayNumbers = new int[sizeArray];

    /**
     * Метод генерирующий случайные числа и заполняющий массив.
     *
     * @return Массив целых сгенерированных чисел.
     */
    public int[] getArrayNumbers() {
        Random random = new Random();
        for (int i = 0; i < arrayNumbers.length; i++) {
            arrayNumbers[i] = random.nextInt(maxnum);
        }
        return arrayNumbers;
    }

    /**
     * Печать содержимого массива на консоль.
     */
    public void dumpArrayNumbers() {
        for (int i : arrayNumbers) {
            System.out.println(i);
        }
    }

}
