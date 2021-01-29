package part01.lesson13.task02_MemoryMetaspace;

import java.io.IOException;

/**
 * MainClass for DZ13
 * Exception Java OutOfMemory from Metaspace
 * My hardware VM option start application for Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
 * !!! My Appl start VM OPTION: -Xmx25M -XX:MaxMetaspaceSize=20M
 * My hardware wait to exception 10-20 seconds.
 */
public class MainClass {


    /**
     * Generate classes Exception Java OutOfMemory from Metaspace
     * @param args standart parameters for main method
     * @throws IOException Gen class files Exception
     */
    public static void main(String[] args) throws IOException {
        ClassGenerator.generateClasses();
    }

}
