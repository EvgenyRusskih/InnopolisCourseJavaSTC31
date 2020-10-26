package part01.lesson02.task03.personsort.utils;

import part01.lesson02.task03.personsort.model.Person;

/**
 * @author RusskihEvgeny
 * Класс для проверки массива Person
 */

public class PersonCheck {

    /**
     * Проверка входного массива на совпадение имени и возраста
     * если совпадение есть то выбрасываем свое исключение
     *
     * @param p входной массив Person
     */
    public void check_persons(Person[] p) throws CheckPersonsException {
        for (int i = 0; i < p.length; i++) {
            for (int j = i + 1; j < p.length - 1; j++) {
                if (p[i].getName().equals(p[j].getName())
                        && p[i].getAge() == p[j].getAge()) {
                    throw new CheckPersonsException("Check exception persons, double name and age: " + p[i].getName() + "   " + p[i].getAge());
                }
            }
        }
    }
}
