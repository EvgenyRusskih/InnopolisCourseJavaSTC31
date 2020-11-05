package part01.lesson07.task02.filegenerator;

import java.io.*;
import java.util.Arrays;
import java.util.TreeSet;

/**
 *  @author RusskihEvgeny
 *  Класс для хранения и обработки строк полученных из входного файла
 */
public class Merge {

    /**
     * Коллекция для хранения отсортированного набора уникальных слов, считанных из файла.
     *
     */
    private TreeSet<String> wordsSet= new TreeSet<String>();


    /**
     * Метод осуществляет чтение строк из файла,
     * разделение строк на слова,
     * загрузку слов в коллекцию для обработки.
     * @param
     */
    public  void fileWordsAddAll() {
        String hw="Hello World !!!";
        // создаем обьект с настройками и считываем текстовый фаил построчно.
        try {
//            Settings settings=new Settings();
//            File file = new File(settings.getPathInputFile());
//            FileReader fr = new FileReader(file);
//            BufferedReader reader = new BufferedReader(fr);

            // считываем строки в цикле, преобразуем каждую строку в массив слов
            String line = reader.readLine();
            String[] wordsLine;
            while (line != null) {
                //System.out.println(line);
                // Удаляем из строки ненужные символы и приводим слова к нижнему регистру.
                line=line.toLowerCase();
                line=line.replace(',',' ');
                // Разделяем строку на слова и заполняем каждое слово в коллекцию
                wordsLine=line.split(" ");
                for(String word:wordsLine){
                    word.replace(",",""); //удаляем запятые из слов
                    word.replace(".",""); //удаляем точки из слов
                    word.replace("-",""); //удаляем тире
                    word=word.toLowerCase();     // приводим все слова к нижнему регистру
                    wordsSet.add( word);
                }

                line = reader.readLine();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public  void dump() {
        for(String word:wordsSet) {
            System.out.println(word);
        }
    }

}
