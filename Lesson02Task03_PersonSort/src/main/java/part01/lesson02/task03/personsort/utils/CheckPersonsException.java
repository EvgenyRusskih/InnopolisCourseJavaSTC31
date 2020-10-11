package part01.lesson02.task03.personsort.utils;

/**
 * Пользовательское исключение выбрасываемое при проверке массива
 */
public class CheckPersonsException extends Exception {
    CheckPersonsException(String message) {
        super(message);
    }
}
