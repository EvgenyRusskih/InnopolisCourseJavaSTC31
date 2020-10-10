package part01.lesson02.task01.helloworldexception;

/**
 * @author RusskihEvgeny
 * Свой класс исключения, унаследованный от Exception
 * Конструктор вызывает конструктор базового класса Exception и пердает ему сообщение
 */

public class MyException extends Exception {
    MyException(String message) {
        super(message);
    }

}
