package part01.lesson05.task01.animalsbox.myexceptions;

/**
 * @author RusskihEvgeny
 * Exception - Попытка дублирования записи животного
 */
public class AnimalsDublicateException extends Exception {
    public AnimalsDublicateException(String message) {
        super(message);
    }
}
