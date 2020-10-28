package part01.lesson03.task02.objectbox;

import part01.lesson03.task02.objectbox.model.ObjectBox;
import part01.lesson03.task02.objectbox.model.TestObject;

/**
 * DZ3 Task02 program ObjectBox
 *
 * @author RusskihEvgeny
 * <p>
 * Задание 2. Создать класс ObjectBox, который будет хранить коллекцию Object.
 * У класса должен быть метод addObject, добавляющий объект в коллекцию.
 * У класса должен быть метод deleteObject,
 * проверяющий наличие объекта в коллекции и при наличии удаляющий его.
 * Должен быть метод dump, выводящий содержимое коллекции в строку.
 */

public class MainClass {
    /**
     * Основной метод с демонстрацией работы по условию задачи.
     *
     * @param args ARGS standart param input command line
     */
    public static void main(String[] args) {
        ObjectBox objectBox = new ObjectBox();
        //заполним коллекцию на пример обьектами TestObject
        //воспользуемся для этого методом addObject
        TestObject testObject1 = new TestObject(1);
        TestObject testObject2 = new TestObject(2);
        TestObject testObject3 = new TestObject(3);
        TestObject testObject4 = new TestObject(4);
        TestObject testObject5 = new TestObject(5);

        objectBox.addObject(testObject1);
        objectBox.addObject(testObject2);
        objectBox.addObject(testObject3);
        objectBox.addObject(testObject4);
        objectBox.addObject(testObject5);

        // распечатаем содержимое коллекции методом dump()
        objectBox.dump();
        System.out.println();

        //удалим обьект и распечатаем результат
        objectBox.deleteObject(testObject1);
        System.out.println("Коллекция после удаления обьекта: ");
        objectBox.dump();

    }
}
