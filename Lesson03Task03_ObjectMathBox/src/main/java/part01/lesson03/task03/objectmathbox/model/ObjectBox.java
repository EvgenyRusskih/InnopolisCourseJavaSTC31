package part01.lesson03.task03.objectmathbox.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author RusskihEvgeny
 * Класс ObjectBox реализующий функционал по условию задачи.
 */
public class ObjectBox {
    /**
     * Коллекция HashSet для хранения обьектов.
     */
    private Set<Object> objects = new HashSet<>();

    /**
     * Добавление обьекта в коллекцию.
     *
     * @param object Обьект для добавления в коллекцию.
     */
    public void addObject(Object object) throws Exception {
        objects.add(object);
    }

    /**
     * Поиск и удаление обьекта из коллекции.
     *
     * @param object Обьект для поиска и удаления из коллекции.
     */
    public void deleteObject(Object object) {
        if (objects.contains(object)) {
            objects.remove(object);
        }

    }

    /**
     * Печать содержимого коллекции в строку.
     */
    public void dump() {
        System.out.println(toString());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectBox objectBox = (ObjectBox) o;
        return Objects.equals(objects, objectBox.objects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objects);
    }

    @Override
    public String toString() {
        return "ObjectBox содержит коллекцию обьектов: {" +
                "objects=" + objects +
                '}';
    }
}
