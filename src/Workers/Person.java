package Workers;

import java.util.Objects;
class Person {
    private String name;
    private String surname;
    private Genders gender;

    protected Person(String name, String surname, Genders gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    //Getters and Setters=====================================
    public Genders getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    //=========================================================

    //Object methods============================
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;

        Person person = (Person) obj;
        return Objects.equals(person.name, name) && Objects.equals(person.surname, surname) && Objects.equals(person.gender, gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, gender);
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
    //==========================================
}
