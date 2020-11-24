package part01.lesson07.task01.fileio;

import java.io.*;

/**
 * DZ7 Task01 program FileIO
 *
 * @author RusskihEvgeny
 * Задание 1. Написать программу, читающую текстовый файл.
 * Программа должна составлять отсортированный по алфавиту список слов, найденных в файле
 * и сохранять его в файл-результат.
 * Найденные слова не должны повторяться, регистр не должен учитываться.
 * Одно слово в разных падежах – это разные слова. –  хозяин, кличка животного, вес.
 */
public class MainClass {
    /**
     * Основной метод с демонстрацией работы по условию задачи.
     *
     * @param args ARGS standart param input command line
     */
    public static void main(String[] args) {
        // получаем все необходимые настройки
        Settings settings = new Settings();
        File file_Out = new File(settings.getPathOutputFile());
        File file_In = new File(settings.getPathInputFile());
        String regexp = settings.getRegexpression();     //регулярное выражение-разделения строк на слова

        //слова из файла считываем, обрабатываем и загружаем в коллекцию Box
        WordsBox wordsBox = new WordsBox();
        wordsBox.fileWordsAddAlltoBox(file_In, regexp);
        // Записываем отсортированные слова из коллекции в фаил
        wordsBox.wordsWriteBoxToFile(file_Out);
        // Выводим записанный результат из файла на консоль
        wordsBox.fileWordsPrintFile(file_Out);
    }

}
