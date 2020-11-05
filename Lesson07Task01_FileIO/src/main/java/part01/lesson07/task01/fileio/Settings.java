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
     * delimiter - разделитель.
     */
    private final String pathInputFile = new File("").getAbsolutePath() + "\\Lesson07Task01_FileIO\\src\\main\\resources\\input_file.txt";
    private final String pathOutputFile = new File("").getAbsolutePath() + "\\Lesson07Task01_FileIO\\src\\main\\resources\\output_file.txt";
    private final String delimiter = " ";

    // Getters
    public String getPathInputFile() {
        return pathInputFile;
    }
    public String getPathOutputFile() {
        return pathOutputFile;
    }
    public String getDelimiter() {
        return delimiter;
    }
}
