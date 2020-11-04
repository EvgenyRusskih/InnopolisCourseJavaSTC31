package part01.lesson03.task02.objectbox.model;

/**
 * @author RusskihEvgeny
 * Класс TestObject для использования и тестирования в коллекции objects.
 */
public class TestObject {
    int numObject;
    String strObject;

    public TestObject(int numObj) {
        this.strObject = "My testObject number:" + numObj;
        this.numObject=numObj;
    }

    @Override
    public String toString() {
        return strObject;
    }
}
