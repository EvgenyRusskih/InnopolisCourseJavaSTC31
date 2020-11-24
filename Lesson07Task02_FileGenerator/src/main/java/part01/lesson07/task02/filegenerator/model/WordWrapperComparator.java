package part01.lesson07.task02.filegenerator.model;

import java.util.Comparator;

/**
 * Компаратор для сравнения оберток строк по их вероятности
 */
public class WordWrapperComparator implements Comparator<WordWrapperProbability> {

    /**
     * Данные обьекты должны сравниваться по вероятности
     */
    @Override
    public int compare(WordWrapperProbability wwp1, WordWrapperProbability wwp2) {
        return wwp2.getProbability() - wwp1.getProbability();
    }

}

