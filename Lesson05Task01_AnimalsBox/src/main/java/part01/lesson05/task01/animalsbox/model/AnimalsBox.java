package part01.lesson05.task01.animalsbox.model;

import part01.lesson05.task01.animalsbox.myexceptions.AnimalsDublicateException;
import part01.lesson05.task01.animalsbox.myexceptions.IndexDublicateException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author RusskihEvgeny
 * AnimalsBox - реализует содержимое картотеки (справочника) животных.
 */

public class AnimalsBox implements AnimalsBoxOperations {

    /**
     * 1 - HashMap в которой храним ключ id и Animals.
     * 2 - HashMap для быстрого поиска по имени (если оно уникально), в которой храним ключ String name
     * и связанный Integer ключ (индекс) от первого HashMap для доступа к обьекту Animal.
     * 3 - Внутренний HashSet - для хранения множества уникальных индексов для поиска по второй мапе.
     */
    private HashMap<Integer, Animal> animals = new HashMap<>();
    private HashMap<String, HashSet<Integer>> animalsNameSearch = new HashMap<>();


    @Override
    public void addAnimal(Integer index, Animal animal) throws AnimalsDublicateException, IndexDublicateException {
        //exception!!! в случае попытки добавления дубликата (такое животное уже есть в картотеке).
        if (animals.containsValue(animal)) {
            throw new AnimalsDublicateException("AnimalsDublicateException");
        }
        //exception!!! в случае попытки добавления дубликата в индекс
        if (animals.containsKey(index)) {
            throw new IndexDublicateException("IndexDublicateException");
        }

        String name = animal.getNameAnimal();
        HashSet<Integer> listindexes = new HashSet<>();
        //проверка по name, если содержится уже данное имя в списке имен, то еще добавляем индекс в список индексов
        if (animalsNameSearch.containsKey(name)) {
            listindexes = animalsNameSearch.get(name);
            listindexes.add(index);
            animals.put(index, animal);
        }
        //если нет то добавляем новое имя
        else {
            listindexes.add(index);
            animalsNameSearch.put(name, listindexes);
            animals.put(index, animal);
        }
    }


    @Override
    public void searchAnimal(String name) {
        //ищем имя по мапе для поиска, чтобы получить список индексов для данного имени
        if (animalsNameSearch.containsKey(name)) {
            HashSet<Integer> listindexes;
            listindexes = animalsNameSearch.get(name);
            //Получаем обьекты поиска по списку индексов
            for (Integer i : listindexes) {
                if (animals.get(i) != null) {
                    System.out.println("Найден обьект с именем: " + name + " : " + animals.get(i).toString());
                } else {
                    System.out.println("Не найден обьект по индексу с номером: " + i);
                }
            }
        } else {
            System.out.println("Не найден обьект с именем: " + name);
        }
    }


    @Override
    public void editAnimal(int id, String newName, Person newOwner, int newMass) {
        //ищем id в мап1, если находим получаем обьект и присваиваем новые значения
        if (animals.containsKey(id)) {
            Animal animalNew;
            animalNew = animals.get(id);
            HashSet<Integer> listindexes;
            //новое имя не совпадает со старым - удаляем неактуальный индекс
            if (!newName.equals(animals.get(id).getNameAnimal())) {
                listindexes = animalsNameSearch.get(animals.get(id).getNameAnimal());
                listindexes.remove(id);
            }
            //если имеется заданное новое имя - то добавляем индекс
            if (animalsNameSearch.containsKey(newName)) {
                listindexes = animalsNameSearch.get(newName);
                listindexes.add(id);
            }
            animalNew.setNameAnimal(newName);
            animalNew.setOwner(newOwner);
            animalNew.setMass(newMass);
        }
    }

    @Override
    public void dumpAnimals() {
        AnimalComparator animalComparator = new AnimalComparator();
        ArrayList<Animal> orderAnimals = new ArrayList<>(animals.values());
        orderAnimals.sort(animalComparator);
        for (Animal animals : orderAnimals) {
            System.out.println(animals.getOwner().getNamePerson() + ",   " + animals.getNameAnimal() + ",    " + animals.getMass());
        }
    }

    @Override
    public String toString() {
        return "AnimalsBox содержит коллекцию: {" +
                "animals=" + animals +
                '}';
    }
}
