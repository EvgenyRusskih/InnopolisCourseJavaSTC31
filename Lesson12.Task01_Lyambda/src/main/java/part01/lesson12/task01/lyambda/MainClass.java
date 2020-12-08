package part01.lesson12.task01.lyambda;

import part01.lesson12.task01.lyambda.model.MathBox;
import part01.lesson12.task01.lyambda.utils.GeneratorNumbers;

/**
 * DZ12 Task01 program Lyambda MathBox
 *
 * @author RusskihEvgeny
 * <p>
 * Задание: Перевести одну из предыдущих работ на использование стримов и лямбда-выражений там, где это уместно
 * (возможно, жертвуя производительностью).
 * Методы summator(), splitter(),printMatchBoxNumbers(),deleter а также конструктор  класса MathBox -
 * переделаны с использованием stream and lyambda
 * <p>
 * В качестве предидущей работы взяли задание 1 из Lesson03:
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

        //вызываем метод для печати (который использует Stream) разложенной в коллекцию массива (MathBox)
        System.out.println("Печать элементов. В данном методе используется stream API and lyambda");
        mathBox1.printMatchBoxNumbers();
        System.out.println();

        // получаем сумму элементов коллекции, метод используем со stream and reduce
        System.out.println("В данном методе используется stream API reduce and lyambda");
        int sum_elements = mathBox1.summator();
        System.out.println("Сумма элементов коллекции= " + sum_elements);
        System.out.println();

        //ищем заданное число и если оно там есть - печатаем и удаляем его из коллекции
        mathBox1.deleter(2);
        System.out.println();
        System.out.println("В данном методе используется stream API and lyambda");
        System.out.println("Результат коллекции после поиска и возможного удаления заданного числа: ");
        mathBox1.printMatchBoxNumbers();
        System.out.println();

        // делим коллекцию на делитель с использованием функционального интерфейса и Lyambda
        System.out.println("В данном методе используется функциональный интерфейс и Lyambda");
        System.out.println("Делим коллекцию на делитель и печатаем результат, новую коллекцию после деления");
        System.out.println("Учитываем что порядок следования элементов в HashSet может менятся");
        mathBox1.splitter(2);
        mathBox1.printMatchBoxNumbers();
        System.out.println();

    }
}