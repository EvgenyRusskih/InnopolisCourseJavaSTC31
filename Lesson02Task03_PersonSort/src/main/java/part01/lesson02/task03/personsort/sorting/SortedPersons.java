package part01.lesson02.task03.personsort.sorting;

import part01.lesson02.task03.personsort.model.Person;

/**
 * Интерфейс двух различных способов сортировки
 * На вход передаем сортируемый массив.
 * Методы возвращают время работы по сортировке массива в сек.
 * Обьекты массива Person сортируются по трем полям
 * в следующем порядке: sex, age, name.
 */
public interface SortedPersons {
    long bubble_sort(Person[] p);
    long selection_sort(Person[] p);
}
