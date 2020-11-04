package part01.lesson03.task01.mathbox.model;

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
        // Заполняем HashSet
        for (Number number : numbersArray) {
            numbers.add(number);
        }
    }

    /**
     * возвращает сумму (Целое число) всех элементов коллекции this.numbers;
     *
     * @return сумма элементов коллекции
     */
    public Integer summator() {
        int sum = 0;
        for (Number i : numbers) {
            sum = sum + i.intValue();
        }
        return sum;
    }

    /**
     * делит все элементы коллекции на делитель,
     * сохраняет результат в новую коллекцию и заменям ссылку в поле на новую коллекцию
     */
    public void splitter(int divide) {
        Set set = new HashSet<>();
        for (Number i : numbers) {
            set.add(i.doubleValue() / divide);
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
            numbers.remove(number_delete);
            System.out.println("Заданное число= " + number_delete + " было найдено и удалено из коллекции");
        }

    }

    /**
     * Метод распечатывающий содержимоое коллекции текущего обьекта MathBox.
     */
    public void printMatchBoxNumbers() {
        for (Number i : numbers) {
            System.out.println(i);
        }
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