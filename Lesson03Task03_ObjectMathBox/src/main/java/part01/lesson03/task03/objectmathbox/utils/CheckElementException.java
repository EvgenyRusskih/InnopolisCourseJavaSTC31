package part01.lesson03.task03.objectmathbox.utils;

/**
 * Пользовательское исключение выбрасываемое при проверке элементов коллекции
 */
public class CheckElementException extends Exception {
    public CheckElementException(String message) {
        super(message);
    }
}
