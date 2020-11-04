package part01.lesson05.task01.animalsbox.model;

import java.util.Comparator;

/**
 * @author RusskihEvgeny
 * Клас реализующий comparator, для сравнения обьектов
 */
public class AnimalComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal a1, Animal a2) {
        if (a1.getOwner().getNamePerson().compareTo(a2.getOwner().getNamePerson()) == 0) {
            if (a1.getNameAnimal().compareTo(a2.getNameAnimal()) == 0) {
                if (a1.getMass() == a2.getMass()) {
                    return 0;
                }
            } else return a1.getNameAnimal().compareTo(a2.getNameAnimal());
        }
        return a1.getOwner().getNamePerson().compareTo(a2.getOwner().getNamePerson());
    }
}
