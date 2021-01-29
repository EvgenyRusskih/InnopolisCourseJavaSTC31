package part01.lesson13.task02_MemoryMetaspace;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * My classloader for SomeClass
 */
public class MyClassloader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File(name + ".class");
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            //С помощью потока считываем файл в массив байт
            byte[] b = new byte[(int) file.length()];
            int readL = bis.read(b);
            //С помощью функции defineClass загружаем класс
            return defineClass(name, b, 0, readL);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException("Проблемы с байт кодом");
        }

    }

}
