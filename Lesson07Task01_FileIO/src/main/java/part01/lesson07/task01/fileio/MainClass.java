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
     * @param args ARGS standart param input command line
     */
    public static void main(String[] args) {
        WordsBox wordsBox=new WordsBox();
        wordsBox.fileWordsAddAll();
        wordsBox.dump();

        //System.out.println(pathInputFile);
        //System.out.println(pathOutputFile);

    }



}
