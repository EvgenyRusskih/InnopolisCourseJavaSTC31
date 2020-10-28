package part01.lesson03.task03.objectmathbox.model;

import part01.lesson03.task03.objectmathbox.utils.CheckElementException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author RusskihEvgeny
 * Класс MathBox реализующий функционал по условию задачи.
 */
public class MathBox extends ObjectBox {
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
        Collections.addAll(numbers, numbersArray);
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
        Set<Number> set = new HashSet<>();
        for (Number i : numbers) {
            set.add(i.doubleValue() / divide);
        }
        //заменяем полученную коллекцию (подменяем ссылку) новой с результатом деления
        numbers = set;
    }

    /**
     * @param number_delete Обьект для поиска и удаления из коллекции
     */
    @Override
    public void deleteObject(Object number_delete) {
        if (numbers.contains(number_delete)) {
            numbers.remove(number_delete);
        }
    }

    /**
     * @param object Обьект для добавления в коллекцию.
     *               После проверки возможности добавления в коллекцию
     *               элемент добавляется в коллекцию иначе выбрасывается пользовательское исключение.
     */
    @Override
    public void addObject(Object object) throws CheckElementException {
        //проверяем перед добавлением полученный обьект
        if (object instanceof Number) {
            Number number = (Number) object;
            numbers.add(number);
        } else {
            throw new CheckElementException("Check element exception");
        }

    }


    /**
     * Метод распечатывающий содержимоое коллекции текущего обьекта MathBox.
     */
    @Override
    public void dump() {
        System.out.println(toString());
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