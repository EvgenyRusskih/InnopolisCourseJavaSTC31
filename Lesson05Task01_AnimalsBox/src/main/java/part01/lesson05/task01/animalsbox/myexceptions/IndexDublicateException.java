package part01.lesson05.task01.animalsbox.myexceptions;

/**
 * @author RusskihEvgeny
 * Exception  - попытка дублирования уникального индекса животного
 */
public class IndexDublicateException extends Exception {
    public IndexDublicateException(String message) {
        super(message);
    }
}
