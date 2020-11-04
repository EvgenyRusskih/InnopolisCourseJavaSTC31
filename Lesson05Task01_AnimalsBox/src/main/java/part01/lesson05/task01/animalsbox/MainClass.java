package part01.lesson05.task01.animalsbox;

import part01.lesson05.task01.animalsbox.model.*;
import part01.lesson05.task01.animalsbox.myexceptions.AnimalsDublicateException;
import part01.lesson05.task01.animalsbox.myexceptions.IndexDublicateException;

/**
 * DZ5 Task01 program Animals box
 *
 * @author RusskihEvgeny
 * Разработать программу – картотеку домашних животных.
 * У каждого животного есть уникальный идентификационный номер,
 * кличка, хозяин (объект класс Person с полями – имя, возраст, пол), вес.
 * <p>
 * Реализовать:
 * метод добавления животного в общий список (учесть, что добавление дубликатов должно приводить к исключительной ситуации)
 * поиск животного по его кличке (поиск должен быть эффективным)
 * изменение данных животного по его идентификатору
 * вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.
 */

public class MainClass {
    /**
     * Основной метод с демонстрацией работы по условию задачи.
     * @param args ARGS standart param input command line
     */
    public static void main(String[] args) {

        // Создадим несколько обьектов Person (Хозяин) и Animal (животное)
        Person person1 = new Person("Dmitry", 20, "MAN");
        Person person2 = new Person("Alex", 30, "MAN");
        Person person3 = new Person("Bob", 25, "MAN");
        Person person4 = new Person("Pavel", 35, "MAN");
        Person person5 = new Person("Nik", 40, "MAN");

        Animal animal1 = new Animal(1, "Taxa", person1, 10);
        Animal animal2 = new Animal(2, "Sharik", person2, 20);
        Animal animal3 = new Animal(3, "Tuzik", person3, 15);
        Animal animal4 = new Animal(4, "Bobik", person4, 22);
        Animal animal5 = new Animal(5, "Atos", person5, 11);
        Animal animal6 = new Animal(6, "Atos", person4, 17);  //животное с той же кличкой и хозяином, но разная масса
        Animal animal7 = new Animal(7, "Atos", person4, 15);
        Animal animal8 = new Animal(7, "Atos", person4, 15);  // создаем дубликат (все поля одинаковы)
        Animal animal9 = new Animal(9, "Atos", person4, 16);
        Animal animal10 = new Animal(10, "Btos",person4, 8);
        Animal animal11 = new Animal(11, "Btos",person4, 9);

        //заполним AnimalsBox нашими обьектами
        AnimalsBox animalsBox=new AnimalsBox();
        try {
            animalsBox.addAnimal(1,animal1);
            animalsBox.addAnimal(2,animal2);
            animalsBox.addAnimal(3,animal3);
            animalsBox.addAnimal(4,animal4);
            animalsBox.addAnimal(5,animal5);
            animalsBox.addAnimal(6,animal6);
            animalsBox.addAnimal(7,animal7);
            animalsBox.addAnimal(8,animal9);
            animalsBox.addAnimal(9,animal10);
            animalsBox.addAnimal(10,animal11);
            animalsBox.addAnimal(7,animal8); //попытка добавить дубликат

        } catch (AnimalsDublicateException | IndexDublicateException e) {
            System.out.println("Попытка добавить дубликат: " + e.getMessage());
        }

        //поиск животного по его кличке
        System.out.println("Поиск животных по имени: ");
        animalsBox.searchAnimal("Sharik");
        animalsBox.searchAnimal("Atos");
        animalsBox.searchAnimal("Bob");

        //Edit animal
        animalsBox.editAnimal(6,"NewDogName", person1, 11 );
        animalsBox.editAnimal(7,"Bobik", person1, 11 );
        animalsBox.editAnimal(8,"Bobik", person1, 12 );
        System.out.println();
        System.out.println("Поиск животных после правки: ");
        animalsBox.searchAnimal("Atos");
        animalsBox.searchAnimal("Bobik");

        System.out.println();
        System.out.println("Отсортированный список животных: ");
        animalsBox.dumpAnimals();

    }
}
