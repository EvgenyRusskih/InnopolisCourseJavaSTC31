package part01.lesson02.task03.personsort;

import part01.lesson02.task03.personsort.model.Person;
import part01.lesson02.task03.personsort.sorting.Class1SortPerson;
import part01.lesson02.task03.personsort.sorting.Class2SortPerson;
import part01.lesson02.task03.personsort.utils.CheckPersonsException;
import part01.lesson02.task03.personsort.utils.PersonCheck;
import part01.lesson02.task03.personsort.utils.PersonGenerator;

/**
 * DZ2 Task03 program PersonSort
 * Generation Persons and two type sorts
 *
 * @author RusskihEvgeny
 * <p>
 * Дан массив объектов Person. Класс Person характеризуется полями age (возраст, целое число 0-100),
 * sex (пол – объект класса Sex со строковыми константами внутри MAN, WOMAN), name (имя - строка).
 * Создать два класса, методы которых
 * будут реализовывать сортировку объектов. Предусмотреть единый интерфейс для классов сортировки.
 * Реализовать два различных метода сортировки этого массива по правилам:
 * первые идут мужчины
 * выше в списке тот, кто более старший
 * имена сортируются по алфавиту
 * Программа должна вывести на экран отсортированный список и время работы каждого алгоритма сортировки.
 * Предусмотреть генерацию исходного массива (10000 элементов и более).
 * Если имена людей и возраст совпадают, выбрасывать в программе пользовательское исключение.
 */

public class MainClass {
    /**
     * задаем количество генерируемых обьектов Person
     */
    public static final int CountPersons = 100;


    public static void main(String[] args) {

        //получаем массив случайных Person
        PersonGenerator person_generator = new PersonGenerator();
        Person[] p = person_generator.generatePerson();
        //делаем несколько клонов массивов для передачи в различные методы сортировки
        Person[] pclone1 = p.clone();
        Person[] pclone2 = p.clone();
        Person[] pclone3 = p.clone();
        Person[] pclone4 = p.clone();

        //Выполняем check оригинального массива на одинаковые имена и возраст, перехватываем пользовательское исключение
        // которое выбрасывается методом check и показываем если такой есть (первое нахождение)
        try {
            PersonCheck pcheck = new PersonCheck();
            pcheck.check_persons(p);
        } catch (CheckPersonsException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        //сортируем массив различными методами и получаем время сортировки
        Class1SortPerson class1sort = new Class1SortPerson();
        Class2SortPerson class2sort = new Class2SortPerson();
        long time_bubblesort1_ms = class1sort.bubble_sort(pclone1);
        long time_selectionsort1_ms = class1sort.selection_sort(pclone2);
        long time_bubblesort2_ms = class2sort.selection_sort(pclone3);
        long time_selectionsort2_ms = class2sort.selection_sort(pclone4);


        // выводим отсортированный результат на пример первого клона массива
        for (Person person : pclone1) {
            System.out.println(person.toString());
        }

        // выводим времена различных методов сортировки
        System.out.println();
        System.out.println("Время сортировки алгоритма1 класса1 составило: " + time_bubblesort1_ms + " ms");
        System.out.println("Время сортировки алгоритма2 класса1 составило: " + time_selectionsort1_ms + " ms");
        System.out.println();
        System.out.println("Время сортировки алгоритма1 класса2 составило: " + time_bubblesort2_ms + " ms");
        System.out.println("Время сортировки алгоритма2 класса2 составило: " + time_selectionsort2_ms + " ms");

    }

}
