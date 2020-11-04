package part01.lesson05.task01.animalsbox.model;

import java.util.Objects;

/**
 * @author RusskihEvgeny
 * Animals определяет класс животное.
 */
public class Animal {
    /**
     * id - уникальный идентификатор животного.
     * nameAnimal - кличка.
     * owner - хозяин.
     * mass - масса животного.
     */
    private int id;
    private String nameAnimal;
    private Person owner;
    private int mass;


    //getters and setters
    public int getId() {
        return id;
    }

    public String getNameAnimal() {
        return nameAnimal;
    }

    public Person getOwner() {
        return owner;
    }

    public int getMass() {
        return mass;
    }

    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public Animal(int id, String name, Person owner, int mass) {
        this.id = id;
        this.nameAnimal = name;
        this.mass = mass;
        this.owner = owner;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id &&
                mass == animal.mass &&
                Objects.equals(nameAnimal, animal.nameAnimal) &&
                Objects.equals(owner, animal.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameAnimal, owner, mass);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nameAnimal='" + nameAnimal + '\'' +
                ", mass=" + mass +
                ", owner=" + owner +
                '}';
    }

}
