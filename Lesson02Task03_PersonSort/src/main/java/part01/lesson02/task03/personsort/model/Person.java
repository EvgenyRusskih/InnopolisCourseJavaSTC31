package part01.lesson02.task03.personsort.model;

import java.util.Random;

/**
 * Class Person
 *
 * @author RusskihEvgeny
 * Класс Person, имеет пол возраст пол и имя.
 */

public class Person {

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    /**
     * age-возраст от 0 до 100 (генерируется random)
     * sex - пол MAN, WOMAN (генерируется random и в конструкторе преобразуем по условию в String)
     * name - имя (получаем случайным образом из массива имен)
     */
    private final int age;
    private final String sex;
    private final String name;

    // constructor Person - создаем Person с различными значениями полей
    public Person(int age, String sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    @Override
    public String toString() {
        return sex + "      " + age + "     " + name;
    }
}
