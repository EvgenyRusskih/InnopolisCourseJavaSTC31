package part01.lesson07.task01.fileio;

import java.io.*;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author RusskihEvgeny
 * Класс для хранения и обработки строк полученных из входного файла
 */
public class WordsBox {

    /**
     * Коллекция для хранения отсортированного набора уникальных слов, считанных из файла.
     */
    private TreeSet<String> wordsSet = new TreeSet<String>();

    /**
     * Метод осуществляет чтение строк из файла,
     * разделение строк на слова,
     * загрузку слов в коллекцию для обработки.
     */
    public void fileWordsAddAlltoBox(File file_In, String regexp) {
        // создаем обьект с настройками и считываем текстовый фаил построчно.
        try (FileReader fr = new FileReader(file_In); BufferedReader reader = new BufferedReader(fr)) {
            // считываем фаил построчно
            String line = reader.readLine();
            while (line != null) {
                line = line.toLowerCase();            //приводим слова к нижнему регистру.
                // обрабатываем строку регулярным выражением для разделения на слова
                Pattern pattern = Pattern.compile(regexp);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    wordsSet.add(matcher.group());
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Метод записывает в файл - строки хранящиеся в коллекции Box.
     */
    public void wordsWriteBoxToFile(File fileOut) {
        try (FileWriter writer = new FileWriter(fileOut); BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            // пишем в файл
            bufferedWriter.write("Отсортированный список слов найденных в файле \"input_file\": " + "\r");
            for (String str : wordsSet) {
                bufferedWriter.write(str + "\r");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод считывает и печатает в консоль строки из файла output_file
     */
    public void fileWordsPrintFile(File file) {
        try (FileReader fr = new FileReader(file); BufferedReader bufReader = new BufferedReader(fr)) {
            // считываем и печатаем в консоль содержимое файла
            String line = bufReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Метод выводит в консоль список слов из коллекции содержащихся в Box
     */
    public void dump() {
        for (String word : wordsSet) {
            System.out.println(word);
        }
        System.out.println(wordsSet);
    }

}
