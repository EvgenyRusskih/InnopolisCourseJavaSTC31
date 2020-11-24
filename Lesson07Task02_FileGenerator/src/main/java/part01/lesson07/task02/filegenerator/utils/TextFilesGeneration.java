package part01.lesson07.task02.filegenerator.utils;

import part01.lesson07.task02.filegenerator.model.WordsBox;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Класс для генерации файлов со сгенерированным текстом по правилам.
 * Текст состоит из абзацев (Paragraph).
 */
public class TextFilesGeneration {

    /**
     * поля передаваемые в конструктор и используемые в методах класса
     */
    ParagraphGeneration paragraphGeneration;
    WordsBox wordsBox;

    public TextFilesGeneration(ParagraphGeneration paragraphGeneration, WordsBox wordsBox) {
        this.paragraphGeneration = paragraphGeneration;
        this.wordsBox = wordsBox;
    }

    /**
     * Метод генерирующий текстовые файлы.
     *
     * @param path Путь к папке где будут создаватсья файлы.
     * @param n    Количество файлов.
     * @param size Размер каждого файла в байтах .
     */
    public void getFiles(String path, int n, int size) throws UnsupportedEncodingException {
        //генерируем файлы в цикле
        for (int i = 0; i < n; i++) {
            //задаем байтовый массив
            byte[] buff = new byte[size];
            String text = "";
            while (text.length() < (size)) {
                text = text + paragraphGeneration.getParagraph(wordsBox) + "\r\n";
            }
            buff = text.getBytes("UTF-8");
            String filename = "file" + i + ".txt";
            String pathFull = path + filename;
            File dir = new File(path);
            File file = new File(path + filename);

            // проверяем есть ли директория, если нету - создаем ее
            if (!dir.exists()) {
                dir.mkdir();
            }
            try {
                FileOutputStream fos = new FileOutputStream(new File(pathFull));
                fos.write(buff);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
