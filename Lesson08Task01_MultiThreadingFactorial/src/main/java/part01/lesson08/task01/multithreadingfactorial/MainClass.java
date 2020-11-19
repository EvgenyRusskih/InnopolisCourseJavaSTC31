package part01.lesson08.task01.multithreadingfactorial;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainClass {
    /**
     * Основной метод с демонстрацией работы программы.
     */
    public static void main(String[] args) {
        //Получим массив случайных чисел
        NumbersBox numbersBox = new NumbersBox();
        int[] arrayNumbers = numbersBox.getArrayNumbers();
        // Используем пул потоков для решения задачи
        // Проходим по массиву и вызываем вычисление факториала для каждого числа.
        System.out.println("Проходим по массиву случайных чисел и вызываем вычисление факториала для каждого числа. ");
        System.out.println("Для решения задачи используется пул потоков. ");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            for (int i : arrayNumbers) {
                FactorialCalc factorialCalc = new FactorialCalc(i);
                final Future<BigInteger> future = executorService.submit(factorialCalc);
                System.out.println("Факториал для числа: " + i + "= " + future.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
