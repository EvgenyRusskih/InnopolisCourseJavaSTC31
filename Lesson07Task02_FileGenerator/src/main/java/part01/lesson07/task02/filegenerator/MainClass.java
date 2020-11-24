package part01.lesson07.task02.filegenerator;

import part01.lesson07.task02.filegenerator.model.WordsBox;
import part01.lesson07.task02.filegenerator.utils.MessagesGeneration;
import part01.lesson07.task02.filegenerator.utils.ParagraphGeneration;
import part01.lesson07.task02.filegenerator.utils.TextFilesGeneration;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * Основной класс.
 * Файлы генерируются в папке с проектом:  ./resources/genFiles (По карайне мере должны на Windows)
 * Проверяется папка и если ее нет - то она создается.
 * При генерации файлов точность около 1кб тк проверка осуществляется на уровне абзацев.
 * Файлы при перезапуске - каждый раз перезаписываются.
 */
public class MainClass {
    /**
     * Определяем: размер массива строк wordsBoxSize
     * Вероятность вхождения слова в предложение и размер массива строк.
     * Путь для генерации файлов.
     */
    public static int wordsBoxSize = 1000;
    public static byte probability = 50; //вероятность [0-100]%
    String path = new File("").getAbsolutePath() + "\\Lesson07Task02_FileGenerator\\src\\main\\resources\\genFiles\\";

    public static void main(String[] args) throws UnsupportedEncodingException {
        // генератор слов
        WordsBox wordsBox = new WordsBox(wordsBoxSize, probability);
        // генератор предложений (messages)
        MessagesGeneration messagesGeneration = new MessagesGeneration(wordsBox.getWordsArray());
        //генератор абзацев (Paragraph)
        ParagraphGeneration paragraphGeneration = new ParagraphGeneration(messagesGeneration);
        // генератор текстовых файлов,
        // задаем: путь path, количество файлов n,
        // размер каждого файла size (байт)
        int n = 20;
        int size = 20000;
        String path = new File("").getAbsolutePath() + "\\Lesson07Task02_FileGenerator\\src\\main\\resources\\genFiles\\";
        TextFilesGeneration textFilesGeneration = new TextFilesGeneration(paragraphGeneration, wordsBox);
        textFilesGeneration.getFiles(path, n, size);
        System.out.println("Файлы должны сгенерироваться в папке: " + path);
    }


    /**
     * Универсальный метод - генерирует целое число в заданном диапазоне
     * Заданные значения включаются в диапазон: [min-max]
     * Должно быть max >=min
     *
     * @param min мин число диапазонва (положительное число)
     * @param max макс число диапазона (положительное число)
     * @return случайное целое число в диапазоне.
     */
    public static int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt((max + 1) - min) + min;     //крайние цифры тоже включаютя в диапазон
    }

}
