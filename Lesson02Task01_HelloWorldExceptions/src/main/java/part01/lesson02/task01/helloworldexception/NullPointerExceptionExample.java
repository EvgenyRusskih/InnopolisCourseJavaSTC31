package part01.lesson02.task01.helloworldexception;

/**
 * @author RusskihEvgeny
 * Класс для получения NullPointerException
 */

class NullPointerExceptionExample {
    String getNullPointerException() throws NullPointerException {
        String s1 = "Hello World";
        String s2 = null;
        System.out.print(s2.equals(s1));
        return "HW";
    }
}
