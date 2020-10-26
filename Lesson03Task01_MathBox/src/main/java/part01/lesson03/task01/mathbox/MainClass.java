package part01.lesson03.task01.mathbox;

import part01.lesson03.task01.mathbox.model.MathBox;
import part01.lesson03.task01.mathbox.utils.GeneratorNumbers;

/**
 * DZ3 Task01 program MatchBox
 *
 * @author RusskihEvgeny
 * <p>
 * Задание 1. Написать класс MathBox, реализующий следующий функционал:
 * <p>
 * Конструктор на вход получает массив Number. Элементы не могут повторяться. Элементы массива внутри объекта раскладываются в подходящую коллекцию (выбрать самостоятельно).
 * Существует метод summator, возвращающий сумму всех элементов коллекции.
 * Существует метод splitter, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель,
 * являющийся аргументом метода. Хранящиеся в объекте данные полностью заменяются результатами деления.
 * Необходимо правильно переопределить методы toString, hashCode, equals, чтобы можно было использовать
 * MathBox для вывода данных на экран и хранение объектов этого класса в коллекциях (например, hashMap).
 * Выполнение контракта обязательно!
 * Создать метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его.
 */

public class MainClass {
    /**
     * Задаем размер генерируемого массива (элементы в массиве могут повторятся)
     */
    public static final int CountNumbers = 10;

    /**
     * Основной метод с демонстрацией работы по условию задачи.
     *
     * @param args ARGS standart param input command line
     */
    public static void main(String[] args) {
        //Получим сгенерированный массив случайных чисел с заданным размером
        GeneratorNumbers generatorNumbersArray = new GeneratorNumbers();
        Number[] numbersArray = generatorNumbersArray.generateNumbers(CountNumbers);
        MathBox mathBox1 = new MathBox(numbersArray);

        //вызываем метод для печати разложенной в коллекцию массива (MathBox)
        System.out.println("Печатаем элементы коллекции HashSet содержащейся в экземпляре MathBox: ");
        System.out.println("Заметим что элементы в коллекции не повторяются");
        mathBox1.printMatchBoxNumbers();

        // получаем сумму элементов коллекции
        int sum_elements = mathBox1.summator();
        System.out.println("Сумма элементов коллекции= " + sum_elements);
        System.out.println();

        //ищем заданное число и если оно там есть - печатаем и удаляем его из коллекции
        mathBox1.deleter(2);
        System.out.println();
        System.out.println("Результат коллекции после поиска и возможного удаления заданного числа: ");
        System.out.println("Учитываем что порядок следования элементов в HashSet может менятся");
        mathBox1.printMatchBoxNumbers();
        System.out.println();

        // делим коллекцию на делитель
        System.out.println("Делим коллекцию на делитель и печатаем результат, новую коллекцию после деления");
        System.out.println("Учитываем что порядок следования элементов в HashSet может менятся");
        mathBox1.splitter(2);
        mathBox1.printMatchBoxNumbers();
        System.out.println();


        // переопределенный метод toString
        System.out.println("Переопределенный метод toString: " + mathBox1.toString());
        System.out.println();

        //создадим еще один MathBox заново сгенерированной коллекцией, сравним их и получим их hashCode
        Number[] numbersArray2 = generatorNumbersArray.generateNumbers(CountNumbers);
        MathBox mathBox2 = new MathBox(numbersArray2);
        System.out.println("Результат сравнения обьектов MathBox2 и MathBox1 переопределенным equals: " + mathBox2.equals(mathBox1));
        System.out.println("hashCode MathBox2= " + mathBox2.hashCode());
        System.out.println("hashCode MathBox1= " + mathBox1.hashCode());

        // создадим еще один MathBox с одинаковым содержимым коллекции и также сравним их и получим hashCode
        MathBox mathBox3 = new MathBox(numbersArray2);
        System.out.println("Результат сравнения обьектов MathBox2 и MathBox3 переопределенным equals: " + mathBox2.equals(mathBox3));
        System.out.println("Обратим внимание что hashCode MathBox3 = hashCode MathBox2!");
        System.out.println("hashCode MathBox3= " + mathBox3.hashCode());

    }
}