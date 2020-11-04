package part01.lesson05.task01.animalsbox.model;

import part01.lesson05.task01.animalsbox.myexceptions.AnimalsDublicateException;
import part01.lesson05.task01.animalsbox.myexceptions.IndexDublicateException;

/**
 * @author RusskihEvgeny
 * Основной интерфейс для операций с картотекой животных
 */
public interface AnimalsBoxOperations {

    /**
     * Метод добавления в словарь животного.
     *
     * @param animal - обьект Animal для добавления нового животного в картотеку.
     * @param index  - индекс обьекта в мап, некоторое целое число связанное с второй мапой для поиска.
     *               AnimalsDublicateException - выброс исключения в случае попытки добавления дубликата животного.
     */
    void addAnimal(Integer index, Animal animal) throws AnimalsDublicateException, IndexDublicateException;

    /**
     * Метод поиска животного по имени (кличке).
     * В случае нахождения -распечатывает данные по искомой кличке.
     *
     * @param name - имя животного по которому осуществляется поиск по картотеке.
     */
    void searchAnimal(String name);

    /**
     * Метод для правки животного по id.
     *
     * @param id       задаем идентификатор id животного в словаре.
     * @param newName  задаем новое имя (кличку) животного
     * @param newOwner задаем нового владельца - обьектPerson.
     * @param newMass  задаем новое значение веса (массы) животного.
     */
    void editAnimal(int id, String newName, Person newOwner, int newMass);


    /**
     * Метод распечатки всех животных (содержимого картотеки) в отсортированном виде.
     * Поля и порядок сортировки: хозяин, кличка животного, вес.
     */
    void dumpAnimals();

}
