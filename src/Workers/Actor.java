package Workers;

import java.util.Objects;

public class Actor extends Person {
    protected int height;

    public Actor(String name, String surname, Genders gender, int height) {
        super(name, surname, gender);
        this.height = height;
    }

    //Object methods============================
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        return super.equals(obj) && Objects.equals(((Actor) obj).height, height);
    }

    @Override
    public String toString() {
        return name + " " + surname + " (" + height + " см)";
    }
    //==========================================
}
