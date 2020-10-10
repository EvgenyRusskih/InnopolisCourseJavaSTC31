package part01.lesson02.task01.helloworldexception;

/**
 * @author RusskihEvgeny
 * Класс для получения своего исключения MyException
 */

class MyExceptionExample {
    void getMyException() throws MyException {
        throw new MyException("Throw my exception ");
    }
}
