package part01.lesson02.task03.personsort.utils;

import part01.lesson02.task03.personsort.MainClass;
import part01.lesson02.task03.personsort.model.Names_MAN;
import part01.lesson02.task03.personsort.model.Names_WOMAN;
import part01.lesson02.task03.personsort.model.Person;

import java.util.Random;

/**
 * @author RusskihEvgeny
 * Класс генерации массива обьектов Person.
 * Обьекты генерируются со случайными значениями полей.
 */

public class PersonGenerator {
    /**
     * @return Возвращает сгенерированный массив обьектов Person
     * Генерируются случайным образом параметры которые затем передаются конструктору Person().
     * age - случайное число в диапазоне 0-100 (возраст).
     * sex - случайное boolean значение.
     * Если sex=true то выбирается случайным образом имя из перечисления мужских имен (Enum: Names_MAN).
     * Если sex=false то из Enum: Names_WOMAN.
     */
    public Person[] generatePerson() {
        Person[] persons = new Person[MainClass.CountPersons];
        Random random = new Random();
        for (int i = 0; i < persons.length; i++) {
            // получаем случ значения возраста от 0 до 100.
            byte age = (byte) random.nextInt(100);
            String sex;
            String name;
            // генерируем boolean для выбора man or woman
            boolean sexman = random.nextBoolean();
            if (sexman == true) {
                sex = "MAN";
                // генерируем случайные значения и получаем имя
                int number_man = random.nextInt(Names_MAN.values().length);
                name = Names_MAN.values()[number_man].toString();
            } else {
                sex = "WOMAN";
                // генерируем случайные значения и получаем имя
                int number_woman = random.nextInt(Names_WOMAN.values().length);
                name = Names_WOMAN.values()[number_woman].toString();
            }
            Person p = new Person(age, sex, name);
            persons[i] = p;
        }
        // возвращаем полученный массив persons
        return persons;
    }
}
