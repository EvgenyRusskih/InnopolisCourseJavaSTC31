package part01.lesson07.task02.filegenerator.utils;

import part01.lesson07.task02.filegenerator.MainClass;
import part01.lesson07.task02.filegenerator.model.WordsBox;

/**
 * Класс - для генерации абзацев текста.
 * Абзац текста- это набор из предложений в определенном диапазоне [1-20].
 * В конце абзаца стоит разрыв строки и перенос каретки.
 */

public class ParagraphGeneration {
    /**
     * Диапазон определяющий количество предложений в абзаце (диапазон).
     */
    int minLegthParagraph = 1;
    int maxLegthParagraph = 20;
    MessagesGeneration messagesGeneration;

    /**
     * Constructor
     */
    public ParagraphGeneration(MessagesGeneration mesGenerator) {
        this.messagesGeneration = mesGenerator;
    }


    /**
     * Метод для формирования набора предложений для текста (абзац)
     *
     * @return Возвращаем сгенерированный абзац (набор из нескольких предложенй)
     */
    public String getParagraph(WordsBox wordsBox) {
        //Параграф, определяем переменную
        String paragraph = "";
        // генерируем случайную длину параграфа (количество предложений)
        int lengthParagraph = MainClass.getRandom(minLegthParagraph, maxLegthParagraph);
        for (int i = 0; i < lengthParagraph; i++) {
            paragraph = paragraph + messagesGeneration.getMessage(wordsBox) + "\r\n";

        }
        return paragraph;
    }

}
