package part01.lesson10.task01.workerclassloaderandreflect;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class MainClass {

    /**
     * Log4j logger for Main class
     * Путь до файла с кодом программы java для нашего метода и класслоадера
     */
    protected static final Logger logger = LogManager.getLogger(MainClass.class);
    public static final String pathSomeClassJava = new File("").getAbsolutePath() + "\\SomeClass.java";

    public static void main(String[] args) {
        String txtMethod = readConsoleMethod();
        // Пишем содержимое класса и метода в файл класса
        WriterSomeClass writerSomeClass = new WriterSomeClass();
        writerSomeClass.writeSomeClassJava(txtMethod, pathSomeClassJava);
        // запускаем компиляцию, передаем ему входной фаил .java
        CompilerSomeClass compilerSomeClass = new CompilerSomeClass();
        compilerSomeClass.compileFile(pathSomeClassJava);
        loadRunDoWork();

    }

    /**
     * Read text method from console
     */
    static String readConsoleMethod() {
        //Считываем с консоли текст для будущей реализации метода.
        Scanner input = new Scanner(System.in);
        logger.info("Введите текст метода: ");
        String line = "";
        String textMethod = "";
        //принимаем текст пока не введем сигнал выхода ...
        int i = 0;
        while (true) {
            // выход при получении пустой строки после начала ввода (просто enter с консоли)
            if (i > 0 && line.equals("")) {
                break;
            }
            i = i + 1;
            line = input.nextLine();
            textMethod = textMethod + line + "\n";
        }
        input.close();
        logger.info("Ввод текста метода завершен ");
        return textMethod;
    }

    /**
     * Load class and run method
     */
    static void loadRunDoWork() {
        // загружаем класс и запускаем метод
        try {
            MySomeClassloader mySomeClassloader = new MySomeClassloader();
            final Class<?> someClass = Class.forName("SomeClass", true, mySomeClassloader);
            Worker instance = (Worker) someClass.getDeclaredConstructor().newInstance();
            instance.doWork();
            logger.info("My class for classloader: " + instance.getClass());
            logger.info("My classloader: " + instance.getClass().getClassLoader());

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            logger.error("Exception from loadRunDoWork() method; "+e);
        }
    }
}
