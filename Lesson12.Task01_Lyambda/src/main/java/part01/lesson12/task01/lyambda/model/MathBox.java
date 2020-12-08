package part01.lesson12.task01.lyambda.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author RusskihEvgeny
 * Класс MathBox реализующий функционал по условию задачи.
 */
public class MathBox {
    /**
     * Коллецкия в которую раскладывается массив чисел Number.
     * Так как коллекция - HashSet, элементы не могут повторятся,
     * что соответсвует условию задачи.
     */
    private Set<Number> numbers = new HashSet<>();

    /**
     * Конструктор - получает на вход массив Number
     * Массив раскладывается в коллекцию HashSet- не имеющий повторов.
     *
     * @param numbersArray массив чисел Number
     */
    public MathBox(Number[] numbersArray) {
        // С помощью Stream -заполняем HashSet
        Arrays.stream(numbersArray).forEach(numbers::add);
    }


    /**
     * Используем Stream and reduce
     * возвращает сумму (Целое число) всех элементов коллекции this.numbers;
     *
     * @return сумма элементов коллекции
     */
    public Integer summator() {
        int sum = 0;
        sum = numbers.stream().reduce((s1, s2) -> s1.intValue() + s2.intValue()).get().intValue();
        return sum;
    }


    /**
     * Используем на пример функциональный интерфейс
     * Делим все элементы коллекции на делитель,
     * сохраняет результат в новую коллекцию и заменям ссылку в поле на новую коллекцию
     */
    public void splitter(int divide) {
        Set set = new HashSet<>();
        for (Number i : numbers) {
            LyambdaDivided divs = (n) -> {
                double result = (i.doubleValue() / divide);
                return result;
            };
            set.add(divs.divided(i));
        }
        //заменяем полученную коллекцию (подменяем ссылку) новой с результатом деления
        numbers = set;
    }


    /**
     * Метод получающий на вход число Integer,
     * если такое число в коллекции находится - то удаляет его из коллекции
     */
    public void deleter(Integer number_delete) {
        if (numbers.contains(number_delete)) {
            System.out.println("Заданное число= " + number_delete + " было найдено ");
        }
        numbers.removeIf(x -> (x.equals(number_delete)));

    }


    /**
     * Используем strem API  для печати в методе.
     * Метод распечатывающий содержимоое коллекции текущего обьекта MathBox.
     */
    public void printMatchBoxNumbers() {
        numbers.stream().forEach(System.out::println);
    }


    /**
     * переопределенный метод equals, на основе содержимого коллекции
     *
     * @param o сравниваемый обьект
     * @return boolean обьекты равны/не равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(numbers, mathBox.numbers);

    }

    /**
     * переопределенный метод hashCode вычисляется на основе элементов коллекции.
     *
     * @return возвращает hashCode обьекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    /**
     * переопределенный метод toString
     *
     * @return возвращает строку описывающую текущий обьект и коллекцию содержащуюся в нём.
     */
    @Override
    public String toString() {
        return "MathBox{" +
                "содержит коллекцию numbers=" + numbers +
                '}';
    }
}