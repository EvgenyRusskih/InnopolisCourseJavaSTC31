package part01.lesson02.task03.personsort.sorting;

import part01.lesson02.task03.personsort.model.Person;

/**
 * Класс №2 с реализацией интерфейса SortedPersons,
 * двух различных сортировок массива Person[].
 */

public class Class2SortPerson implements SortedPersons {

    public long bubble_sort(Person[] p) {
        //Для вычисления времени работы метода фиксируем текущее время
        long starttime = System.currentTimeMillis();
        // алгоритм сортировки
        for (int i = 0; i < p.length - 1; i++) {
            for (int j = 0; j < p.length - i - 1; j++) {
                // с начала сравниваем sex и сортируем
                // тк стандартный метод CompareTo возвращает нужный нам порядок строк MAN > WOMAN то можем использовать его
                if (p[j].getSex().compareTo(p[j + 1].getSex()) > 0) {
                    Person ptemp = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = ptemp;
                }
                // если sex одинаковый то затем сравниваем и сортируем по age
                if (p[j].getSex().compareTo(p[j + 1].getSex()) == 0
                        && (p[j].getAge() < p[j + 1].getAge())) {
                    Person ptemp = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = ptemp;

                }
                // если sex and age одинаковые то затем сортируем по name
                if (p[j].getSex().compareTo(p[j + 1].getSex()) == 0
                        && (p[j].getAge() == p[j + 1].getAge())
                        && (p[j].getName().compareTo(p[j + 1].getName()) > 0)) {
                    Person ptemp = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = ptemp;
                }
            }
        }

        //вычисляем и возвращаем время сортировки массива в сек
        long endtime = System.currentTimeMillis();
        return (int) (endtime - starttime);
    }


    public long selection_sort(Person[] p) {
        //Для вычисления времени работы метода фиксируем текущее время
        long starttime = System.currentTimeMillis();
        //алгоритм сортировки
        for (int i = 0; i < p.length; i++) {
            //Предполагаем, что первый элемент (в каждом подмножестве элементов) является минимальным
            Person pmin = p[i];
            int pmin_i = i;
            //В оставшейся части подмножества ищем элемент,который меньше предположенного минимума
            for (int j = i + 1; j < p.length; j++) {
                // Смотрим по первому полю, если находим, запоминаем его индекс.
                if (p[j].getSex().compareTo(pmin.getSex()) < 0) {
                    pmin = p[j];
                    pmin_i = j;
                }
                // Смотрим еще по второму полю
                if (p[j].getSex().compareTo(pmin.getSex()) == 0
                        && p[j].getAge() > pmin.getAge()) {
                    pmin = p[j];
                    pmin_i = j;
                }
                // Смотрим еще по третьему полю
                if (p[j].getSex().compareTo(pmin.getSex()) == 0
                        && p[j].getAge() == pmin.getAge()
                        && p[j].getName().compareTo(pmin.getName()) < 0) {
                    pmin = p[j];
                    pmin_i = j;
                }
            }
            //Если нашелся элемент, меньший, чем на текущей позиции,меняем их местами
            if (i != pmin_i) {
                Person tmp = p[i];
                p[i] = p[pmin_i];
                p[pmin_i] = tmp;
            }
        }
        //вычисляем и возвращаем время сортировки массива в сек
        long endtime = System.currentTimeMillis();
        return (int) (endtime - starttime);

    }

}
