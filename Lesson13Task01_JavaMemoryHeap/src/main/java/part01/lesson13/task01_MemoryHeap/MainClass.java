package part01.lesson13.task01_MemoryHeap;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.*;

/**
 * MainClass for DZ13
 * Exception Java OutOfMemory from Heap Space (from staic field)
 * VM option - default and wait 10-15 seconds from my hardware
 */
public class MainClass {

    /**
     * Logger field
     * List - static field for Double objects
     * Flag - continiue cycle add Objects to list
     */
    protected static final Logger logger=Logger.getLogger(MainClass.class);
    private static List<Double> list=new ArrayList<>();
    private static boolean flagAdd=true;

    /**
     * Add and remove objects from static field list
     * and print free memory VM.
     * @param args - standart main parameters
     */
    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        int i=0;
        while (flagAdd) {
            mainClass.addListObjDouble();
            list.remove(list.size()-1);
                if(i%10000==0) {
                    logger.info("Free memory: " + Runtime.getRuntime().freeMemory());
                }
        i++;
        }
    }

    /**
     * List add objects Double
     */
    public void addListObjDouble(){
        for (int i=0; i<1000; i++) {
            list.add(Math.random());
        }
    }
}
