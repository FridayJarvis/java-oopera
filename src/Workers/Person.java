package Workers;

import java.util.Objects;
class Person {
    protected String name;
    protected String surname;
    protected Genders gender;

    protected Person(String name, String surname, Genders gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    public Genders getGender() {
        return gender;
    }

    //Object methods============================
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;

        Person person = (Person) obj;
        return Objects.equals(person.name, name) && Objects.equals(person.surname, surname) && Objects.equals(person.gender, gender);
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
    //==========================================
}
