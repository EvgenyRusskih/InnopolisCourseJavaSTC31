package part01.lesson07.task02.filegenerator.utils;

import part01.lesson07.task02.filegenerator.MainClass;
import part01.lesson07.task02.filegenerator.model.WordsBox;

/**
 * Класс для генерации предложений (сочетание слов по определенным правилам)
 * Предложения формируются по правилам определенным в задании:
 * Предложение состоит из 1<=n1<=15 слов,
 * После произвольных слов могут находиться запятые,
 * Слова разделены пробелом,
 * Начало предложения с заглавной буквы,
 * Предложение заканчивается (.|!|?)+" " .
 * Файлы генерируются в папке с проектом resources\genFiles\
 */
public class MessagesGeneration {

    /**
     * Диапазон определяющий длины слов от min до max символов
     * Массив сгенерированных строк из которых строится предложение (передается в конструктор).
     * Также коллекция оберток слов которые имеют поле с приоритетом.
     */
    int minLegthMessage = 1;
    int maxLegthMessage = 15;
    String[] words;

    /**
     * Constructor
     *
     * @param wordsArray Сгенерированный массив строк
     */
    public MessagesGeneration(String[] wordsArray) {
        this.words = wordsArray;
    }

    /**
     * Метод генерирут предложение (сообщение) по заданным правилам.
     *
     * @return возвращаем сгенерированное предложение.
     */
    public String getMessage(WordsBox wordsBox) {
        // Предложение
        String message = "";
        // генерируем случайную длину предложения (количество слов)
        int lengthMessage = MainClass.getRandom(minLegthMessage, maxLegthMessage);
        for (int i = 0; i < lengthMessage; i++) {
            //генерируем и добавляем случайные запятые в середину предложения
            int comma = MainClass.getRandom(0, 3); // для случайной генерации запятой в середине предложения
            String str = " ";
            if (i == lengthMessage - 1) {    // если последнее слово - окончание генерируем далее, пробел тут ненужен
                str = "";
            }
            if (i > 0 && i < (lengthMessage - 1) && comma == 1) {
                str = ", ";
            }

            //получаем случайные слова из метода
            message = message + wordsBox.getProbabilityWord() + str;
        }


        // Делаем первую букву предложения с заглавной буквы
        message = message.substring(0, 1).toUpperCase() + message.substring(1);
        // для генерации окончания предложения
        int endMessage = MainClass.getRandom(0, 5);
        String endStr;
        switch (endMessage) {
            case 2:
                endStr = "! ";
            case 3:
                endStr = "? ";
                break;
            default:
                endStr = ". ";
                break;
        }

        return message + endStr;
    }


}
