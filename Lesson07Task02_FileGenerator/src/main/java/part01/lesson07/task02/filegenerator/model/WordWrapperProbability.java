package part01.lesson07.task02.filegenerator.model;

/**
 * Класс обертка над строкой для задания ей поля с вероятностью
 */
public class WordWrapperProbability {
    private byte probability;
    private String word;

    /**
     * Getters
     */
    public byte getProbability() {
        return probability;
    }

    public String getWord() {
        return word;
    }

    /**
     * Setters
     */
    public void setProbability(byte probability) {
        this.probability = probability;
    }


    /**
     * Constructor
     *
     * @param probability вероятность
     * @param word        слово
     */
    public WordWrapperProbability(byte probability, String word) {
        this.probability = probability;
        this.word = word;
    }
}
