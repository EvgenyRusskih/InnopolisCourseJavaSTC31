package part01.lesson10.task01.workerclassloaderandreflect;

import java.io.*;

/**
 * My classloader for SomeClass
 */
public class MySomeClassloader extends ClassLoader {

    //Переопределяем метод findClass, которому надо передать путь к файлу с расширением .class
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File(name+".class");
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file)))
        {
            //С помощью потока считываем файл в массив байт
            byte[]b = new byte[(int)file.length()];
            int readL= bis.read(b);
            //С помощью функции defineClass загружаем класс
            return defineClass(name, b, 0, readL);
        }catch (Exception e){
            e.printStackTrace();
            throw new ClassNotFoundException("Проблемы с байт кодом");
        }
    }
}
