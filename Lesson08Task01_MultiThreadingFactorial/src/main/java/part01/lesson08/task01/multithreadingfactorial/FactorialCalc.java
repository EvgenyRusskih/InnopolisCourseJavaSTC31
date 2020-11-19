package part01.lesson08.task01.multithreadingfactorial;

import java.math.BigInteger;
import java.util.concurrent.Callable;

/**
 * Класс реализующий вычисление факториала.
 */
public class FactorialCalc implements Callable<BigInteger> {
    /**
     * Задаем число для которого вычисляем факториал.
     */
    int num;

    public FactorialCalc(int num) {
        this.num = num;
    }

    /**
     * вычисление факториала числа.
     */
    public BigInteger call() {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
