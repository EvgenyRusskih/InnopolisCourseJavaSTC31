package part01.lesson13.task02_MemoryMetaspace;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Создает классы с помощью нашего загрузчика классов
 * заполняем ими List а также metaspace (тк там хранятся метаданные о классах)
 */
public class ClassGenerator {
    static boolean flagGenerateClassLoop=true;
    static List<Class<?>> listClasses = new ArrayList<>();

    /**
     * Генерируем классы и заполняем metaspace
     * @throws IOException IO exception
     */
    public static void generateClasses() throws IOException {
        int i=0;
        while(flagGenerateClassLoop) {
            listClasses.add(getClass("MyClass"+i));
            System.out.println("Num call method getClass "+i);
        i++;
        }
    }

    /**
     * Метод для получения класса через MyClassloader
     * @param name Name java class
     * @return MyClass
     * @throws IOException IOException for class create
     */
    private static Class<?> getClass(String name) throws IOException {
        String myClass = name + ".java";
        try (FileOutputStream outputStream = new FileOutputStream(myClass)) {
            outputStream.write(("class " +name + " { public static final int x=1000000; }").getBytes());
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileManager = compiler
                    .getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> compilationUnits = fileManager
                    .getJavaFileObjectsFromStrings(Collections.singletonList(myClass));
            compiler.getTask(null, fileManager, null, null, null, compilationUnits).call();

            return Class.forName(name, true, new MyClassloader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            File myClassFile = new File(myClass);
            File classFile = new File(name + ".class");
            if(myClassFile.delete() &&classFile.delete()){
                System.out.println("My class file is deleted");
            }

        }
    return null;
    }

}
