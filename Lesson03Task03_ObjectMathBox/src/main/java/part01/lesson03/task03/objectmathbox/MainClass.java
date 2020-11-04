package part01.lesson03.task03.objectmathbox;

import part01.lesson03.task03.objectmathbox.model.MathBox;
import part01.lesson03.task03.objectmathbox.model.ObjectBox;
import part01.lesson03.task03.objectmathbox.model.TestObject;
import part01.lesson03.task03.objectmathbox.utils.CheckElementException;
import part01.lesson03.task03.objectmathbox.utils.GeneratorNumbers;

/**
 * DZ3 Task03 program ObjectBox and MatchBox
 *
 * @author RusskihEvgeny
 * <p>
 * Задание 3. Доработать классы MathBox и ObjectBox таким образом, чтобы MathBox был наследником ObjectBox.
 * Необходимо сделать такую связь, правильно распределить поля и методы.
 * Функциональность в целом должна сохраниться.
 * При попытке положить Object в MathBox должно создаваться исключение.
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

        try {
            objectBox.addObject(testObject1);
            objectBox.addObject(testObject2);
            objectBox.addObject(testObject3);
            objectBox.addObject(testObject4);
            objectBox.addObject(testObject5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // распечатаем содержимое коллекции ObjectBox методом dump()
        System.out.println("Исходная коллекция ObjectBox: ");
        objectBox.dump();

        //Получим сгенерированный массив случайных чисел с заданным размером и передадим их в MathBox
        GeneratorNumbers generatorNumbersArray = new GeneratorNumbers();
        Number[] numbersArray = generatorNumbersArray.generateNumbers(10);
        MathBox mathBox1 = new MathBox(numbersArray);

        // распечатаем содержимое коллекции MatchBox методом dump()
        System.out.println("Исходная коллекция MathBox: ");
        mathBox1.dump();

        // получаем и распчатаем сумму элементов коллекции
        System.out.println("Сумма элементов коллекции MathBox= " + mathBox1.summator());
        System.out.println();


        try {
            // положим в коллекцию MathBox число
            mathBox1.addObject(10.5);
            // попытка положить в коллекцию MathBox обьект - приводит к исключительной ситуации
            mathBox1.addObject(testObject1);
        } catch (CheckElementException e) {
            System.out.println("Произошла ошибка добавления в коллекцию: " + e.getMessage());
        }

        System.out.println("Коллекция MathBox после добавления элемента: ");
        mathBox1.dump();

        // поиск и удаление элемента коллекции
        objectBox.deleteObject(testObject1);
        System.out.println("Коллекция ObjectBox после удаления элемента:");
        objectBox.dump();

        mathBox1.deleteObject(10.5);
        System.out.println("Коллекция MathBox после удаления элемента:");
        mathBox1.dump();

        mathBox1.splitter(2);
        System.out.println("Коллекция MathBox после деления элементов на делитель:");
        mathBox1.dump();

    }
}
