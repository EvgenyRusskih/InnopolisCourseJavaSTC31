package part01.lesson02.task02.numbergeneration;

import java.util.Random;

/**
 * DZ2 Task02 program numbers generator and calc sqrt
 *
 * @author RusskihEvgeny
 * Задание 2. Составить программу, генерирующую N случайных чисел.
 * Для каждого числа k вычислить квадратный корень q.
 * Если квадрат целой части q числа равен k, то вывести это число на экран.
 * Предусмотреть что первоначальные числа могут
 * быть отрицательные, в этом случае генерировать исключение.
 */

public class MainClass {
    /**
     * задаем число генерируемых чисел n
     */
    static int n = 100;

    public static void main(String[] args) throws ArithmeticException {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            try {
                // генерируем целые цисла положительные и отрицательные
                int k = random.nextInt(200) - 100;
                // если число отрицательное то бросаем исключение
                if (k < 0) {
                    throw new ArithmeticException("Exception: k<0, not operation sqrt!!!");
                }
                double q = Math.sqrt(k);
                int partq = (int) q;     //целая часть q (корня k)
                // если квадрат целой части q числа равен k, то вывод искомого числа
                if (partq * partq == k) {
                    System.out.println(k + " - это искомое число ");
                }
                //System.out.println(q + "  " + k);
            } catch (ArithmeticException ae) {
                System.out.println(ae.getMessage());
            }
        }
    }
}
