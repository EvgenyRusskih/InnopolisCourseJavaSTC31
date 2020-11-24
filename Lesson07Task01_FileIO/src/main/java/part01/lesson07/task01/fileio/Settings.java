package part01.lesson07.task01.fileio;

import java.io.File;

/**
 * Класс для хранения настроек: пути к входному и выходному файлам.
 *
 * @author RusskihEvgeny
 */
public class Settings {
    /**
     * Пути для входного и выходного файла.
     * regexpression - строка регулярного выражения для разделения строк на слова.
     */
    private final String pathInputFile = new File("").getAbsolutePath() + "\\Lesson07Task01_FileIO\\src\\main\\resources\\input_file.txt";
    private final String pathOutputFile = new File("").getAbsolutePath() + "\\Lesson07Task01_FileIO\\src\\main\\resources\\output_file.txt";
    //все буквы латинского или русского алфавита встречающиеся 1 и более раз (+)!!!
    private final String regexpression = "\\w+|[а-яА-Я]+";

    // Getters
    public String getPathInputFile() {
        return pathInputFile;
    }

    public String getPathOutputFile() {
        return pathOutputFile;
    }

    public String getRegexpression() {
        return regexpression;
    }
}
