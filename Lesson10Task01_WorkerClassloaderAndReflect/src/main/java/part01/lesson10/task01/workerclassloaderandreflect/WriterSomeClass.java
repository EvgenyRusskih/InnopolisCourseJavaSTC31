package part01.lesson10.task01.workerclassloaderandreflect;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;

/**
 * Класс записывающий код(текст)  класса в фаил .java
 */
public class WriterSomeClass {
    /**
     * Поля: Логгер для класса
     * Содержимое класса (начальное значение) к оторому дописываем код метода doWork()
     *
     */

    protected static final Logger logger = LogManager.getLogger(WriterSomeClass.class);
    String textStartClass = "import "+Worker.class.getName()+";"+
            "\n" +
            "public class SomeClass implements Worker {\n" +
            "\n" +
            "@Override"+"\n"+
            "public void doWork()";

    /**
     * Метод пишет в фаил исходный код всего класса с нужным методом (текстовое содержимое по сути)
     * @param text текст метода класса без учета основных фигурных скобок
     */
    public void writeSomeClassJava(String text, String pathClassTxtFile) {
        String text_doWork = "{"+"\n" + text+ "}";
        String text_endClass="\n}";

        try (FileWriter writer = new FileWriter(pathClassTxtFile); BufferedWriter bufferedWriter = new BufferedWriter(writer);
             BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(new FileInputStream(pathClassTxtFile))) )
        {
            // пишем в файл содержимое (код)
            bufferedWriter.write(textStartClass+text_doWork+text_endClass);

        } catch (IOException e) {
            logger.error("IO Exception for writeSomeClassJava method: "+ e);
        }

    }

}
