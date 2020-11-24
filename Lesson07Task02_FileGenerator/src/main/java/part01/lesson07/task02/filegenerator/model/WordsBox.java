package part01.lesson07.task02.filegenerator.model;

import part01.lesson07.task02.filegenerator.MainClass;
import part01.lesson07.task02.filegenerator.utils.WordsGeneration;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Контейнер для хранения массива обьектов сгенерированных строк.
 * Строки оборачиваем в обьекты с полем int приоритета (probability),
 * начальное значение которого можем задать основном в методе и
 * далее это поле используем в очереди с приоритетом для изменения вероятности попадания слов.
 */
public class WordsBox {
    /**
     * Поля для храненения масива сгенерированных слов и
     * поле для хранения ссылки экзэмпляра.
     * поле для хранения обертки над словом для обозначения его приоритета
     * начальное значение -вероятность вхождения слова в след предложение, получаем из поля основного метода
     */
    private String[] wordsArray = new String[MainClass.wordsBoxSize];
    private WordsBox wordsBox;
    private ArrayList<WordWrapperProbability> wordsBoxWrapperProbability = new ArrayList<>();
    private PriorityQueue<WordWrapperProbability> prQueueWords;

    /**
     * Constructor
     * Массив заполняем при создании обьекта
     * а также ссылку на текущий обьект
     */
    public WordsBox(int sizeArray, byte initProbability) {
        addWordsBox(sizeArray, initProbability);
        wordsBox = this;
        // Comparator для сравнения (приоритета)
        WordWrapperComparator wordWrapperComparator = new WordWrapperComparator();
        prQueueWords = new PriorityQueue<>(wordsBoxWrapperProbability.size(), wordWrapperComparator);
        //заполняем очередь
        for (WordWrapperProbability wwp : wordsBoxWrapperProbability) {
            prQueueWords.add(wwp);
        }
    }

    /**
     * Getters
     */
    public String[] getWordsArray() {
        return wordsArray;
    }

    public WordsBox getWordsBox() {
        return wordsBox;
    }


    /**
     * Метод для заполнения массива и листа со строками с приоритетом
     */
    public void addWordsBox(int sizeArray, byte initProbability) {
        WordsGeneration wordsGeneration = new WordsGeneration();
        for (int i = 0; i < sizeArray; i++) {
            String str = wordsGeneration.getWord();
            WordWrapperProbability wWrapper = new WordWrapperProbability(initProbability, str);
            wordsArray[i] = (str);
            wordsBoxWrapperProbability.add(wWrapper);
        }
    }

    /**
     * Метод печатающий содержимое массива в консоль
     */
    public void printlnWordsArray() {
        for (String str : wordsArray) {
            System.out.println(str);
        }
    }

    /**
     * Метод печатающий содержимое коллекции (листа) в консоль
     */
    public void printlnWordsList() {
        for (WordWrapperProbability wWord : wordsBoxWrapperProbability) {
            System.out.println("Начальная вероятность: " + wWord.getProbability() + " Cлово: " + wWord.getWord());
        }
    }


    /**
     * Метод получения случайного слова с учетом его вероятности
     * Используем: очередь с приоритетом и массив оберток надо словами (List) из класса WordsBox
     *
     * @return слово случайно полученное на основе его вероятности
     */
    public String getProbabilityWord() {
        WordWrapperProbability wwp = prQueueWords.remove();
        String wordProbability = wwp.getWord();
        //Уменьшаем вероятность на 1 и снова возвращаем в очередь
        byte newProbability = (byte) (wwp.getProbability() - 5);
        //если она уменьшилась до 0 до снова возвращаем прежнее значение
        if (newProbability < 5) {
            newProbability = MainClass.probability;
        }
        wwp.setProbability(newProbability);
        prQueueWords.add(wwp);
        //увеличиваем вероятность для следующего элемента (если она ниже порога)
        WordWrapperProbability wwp2 = prQueueWords.remove();
        byte pr2 = wwp2.getProbability();
        if (MainClass.probability > 5 && pr2 < MainClass.probability - 3) {
            pr2 = (byte) (pr2 + 3);
            wwp2.setProbability(pr2);
        }
        prQueueWords.add(wwp2);

        return wordProbability;
    }

}
