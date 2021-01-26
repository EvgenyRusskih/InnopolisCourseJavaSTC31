package part01.lesson10.task01.workerclassloaderandreflect;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.util.Collections;

public class CompilerSomeClass {

    public void compileFile(String path) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler
                .getStandardFileManager(null, null, null);

        Iterable<? extends JavaFileObject> compilationUnits = fileManager
                .getJavaFileObjectsFromStrings(Collections.singletonList(path));
        compiler.getTask(null, fileManager, null, null, null, compilationUnits).call();
    }
}
