package part01.lesson07.task02.filegenerator.utils;

import part01.lesson07.task02.filegenerator.MainClass;

/**
 * Генератор слов, состоящих из случайного набора латинских букв
 * с минимальной и максимальной длиной слова заданной в полях min/max legthWord
 */
public class WordsGeneration {
    /**
     * Диапазон определяющий длины слов от min до max символов
     */
    int minLegthWord = 1;
    int maxLegthWord = 15;

    /**
     * Метод генерируем слово в диапазоне заданным в полях.
     *
     * @return возвращаем сгенерированное слово.
     */
    public String getWord() {
        // генерируем случайную длину слова (количство латинских букв) от minLegthWord до maxLegthWord
        int lengthWord = MainClass.getRandom(minLegthWord, maxLegthWord);
        // генерируем набор символов для слова, сгенерированные символы помещаем в массив
        char[] wordchar = new char[lengthWord];
        for (int i = 0; i < lengthWord; i++) {
            //получаем случайный символ (коды латиницы в диапазоне [a-z] : 97-122)
            int charcode = MainClass.getRandom(97, 122);
            wordchar[i] = (char) charcode;
        }
        //из массива получаем строку и возвращаем результат
        String word;
        word = String.valueOf(wordchar);
        return word;
    }

}
