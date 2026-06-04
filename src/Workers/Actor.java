package Workers;

import java.util.Objects;

public class Actor extends Person {
    private int height;

    public Actor(String name, String surname, Genders gender, int height) {
        super(name, surname, gender);
        this.height = height;
    }

    //Getters and setters======================
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    //==========================================

    //Object methods============================
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        return super.equals(obj) && ((Actor) obj).height == height;
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + " (" + height + " см)";
    }
    //==========================================
}
