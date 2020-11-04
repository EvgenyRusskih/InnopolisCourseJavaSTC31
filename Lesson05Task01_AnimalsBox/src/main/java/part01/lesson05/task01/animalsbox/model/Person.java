package part01.lesson05.task01.animalsbox.model;

import java.util.Objects;

/**
 * @author RusskihEvgeny
 * Person определяет класс хозяина животного .
 */
public class Person {
    /**
     * namePerson - имя хозяина животного.
     * age - возраст.
     * sex - пол.
     */

    private String namePerson;
    private int age;
    private String sex;

    // getters and setters
    public String getNamePerson() {
        return namePerson;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public Person(String name, int age, String sex) {
        this.namePerson = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(namePerson, person.namePerson) &&
                Objects.equals(sex, person.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namePerson, age, sex);
    }


    @Override
    public String toString() {
        return "Person{" +
                "namePerson='" + namePerson + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }


}
