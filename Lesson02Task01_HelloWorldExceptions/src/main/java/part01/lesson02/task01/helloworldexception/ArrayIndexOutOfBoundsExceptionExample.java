package part01.lesson02.task01.helloworldexception;

/**
 * @author RusskihEvgeny
 * Класс для получения ArrayIndexOutOfBoundsException
 */

class ArrayIndexOutOfBoundsExceptionExample {
    void getArrayIndexOutOfBoundsException() throws ArrayIndexOutOfBoundsException {
        int[] arr1 = new int[10];
        for (int i = 0; i < 10; i++) {
            arr1[i] = i;
        }
        for (int i = 0; i <= 10; i++) {     //i=10 - exception
            int b = arr1[i];
        }
    }
}
